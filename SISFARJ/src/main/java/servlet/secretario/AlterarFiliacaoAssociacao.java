package servlet.secretario;

import dominio.Associacao;
import dominio.PermissaoUsuario;
import dominio.Usuario;
import util.MiddlewareSessao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
@WebServlet("/alterarFiliacaoAssociacao")
public class AlterarFiliacaoAssociacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    String query = req.getQueryString();
                    Associacao associacao = Associacao.get(this.recuperarId(query));
                    req.setAttribute("associacao", associacao);
                    req.getRequestDispatcher("alterar_filiacao_associacao.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    String nome = req.getParameter("nome").trim();
                    String sigla = req.getParameter("sigla").trim();
                    String numeroOficio = req.getParameter("numeroOficio").trim();
                    String telefone = req.getParameter("telefone").trim();
                    String data = req.getParameter("data").trim();
                    String numComprovantePgto = req.getParameter("numComprovantePgto").trim();
                    String endereco = req.getParameter("endereco").trim();

                    if(nome.equals("") || sigla.equals("") || numeroOficio.equals("") || telefone.equals("") ||
                            data.equals("") || numComprovantePgto.equals("") || endereco.equals("")){
                        informarErroPreenchimento(req, resp);
                    } else{
                        Associacao a = (Associacao) req.getAttribute("associacao");
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                        a.setNome(nome);
                        a.setSigla(sigla);
                        a.setNumeroOficio(numeroOficio);
                        a.setTelefone(telefone);
                        a.setDataOficio(sdf.parse(data));
                        a.setNumComprovantePgto(numComprovantePgto);
                        a.setEndereco(endereco);
                        if(Associacao.update(a)) informarSucessoAlteracao(req, resp);
                        else informarErroAlteracao(req, resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int recuperarId(String query){
        return Integer.valueOf(query.substring(query.lastIndexOf("=") + 1));
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento"+req.getQueryString(), true);
        doGet(req, resp);
    }

    public void informarSucessoAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarFiliacaoAssociacao"+req.getQueryString(), true);
        doGet(req, resp);
    }

    public void informarErroAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterarFiliacaoAssociacao"+req.getQueryString(), true);
        doGet(req, resp);
    }
}
