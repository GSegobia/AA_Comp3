package servlet.secretario;

import dominio.Associacao;
import dominio.PermissaoUsuario;
import dominio.Secretario;
import dominio.Usuario;
import util.MiddlewareSessao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/filiarAssociacao")
public class FiliarAssociacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else { getServletContext().getRequestDispatcher("/filiar_associacao.jsp").forward(req, resp); }
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

                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                        Secretario secretario = new Secretario(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(),
                                                                u.getPermissaoId());
                        Associacao associacao = new Associacao(
                                numeroOficio,
                                sdf.parse(data),
                                nome,
                                sigla,
                                "MAT123" + sigla,
                                endereco,
                                telefone,
                                numComprovantePgto
                        );

                        secretario.filiarAssociacao(associacao);
                        informarSucessoCadastro(req, resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                informarErroCadastro(req, resp);
            }
        }
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        req.getRequestDispatcher("filiar_associacao.jsp").forward(req, resp);
    }

    public void informarSucessoCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoCadastro", true);
        req.getRequestDispatcher("filiar_associacao.jsp").forward(req, resp);
    }

    public void informarErroCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroCadastro", true);
        req.getRequestDispatcher("filiar_associacao.jsp").forward(req, resp);
    }
}
