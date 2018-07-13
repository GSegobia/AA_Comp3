package servlet.diretortecnico;

import dominio.CentroAquatico;
import dominio.DiretorTecnico;
import dominio.PermissaoUsuario;
import dominio.Usuario;
import util.MiddlewareSessao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/alterarLocaisCompeticao")
public class AlterarLocaisCompeticao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId()) || Usuario.checaPermissao(PermissaoUsuario.TECNICO_ASSOCIACAO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    String query = req.getQueryString();
                    int lc_id = this.recuperarId(query);
                    DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                    CentroAquatico ca = CentroAquatico.get(lc_id);
                    req.setAttribute("lc_id", lc_id);
                    req.setAttribute("lc", ca);
                    getServletContext().getRequestDispatcher("/alterar_local_competicao.jsp").forward(req, resp);
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
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId()) || Usuario.checaPermissao(PermissaoUsuario.TECNICO_ASSOCIACAO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    int id = Integer.valueOf(req.getParameter("id").trim());
                    String nome = req.getParameter("nome").trim();
                    String endereco = req.getParameter("endereco").trim();
                    int tamanho = Integer.valueOf(req.getParameter("piscina").trim());

                    if(endereco.equals("")) {
                        informarErroPreenchimento(req, resp);
                    }else{
                        CentroAquatico ca = new CentroAquatico(id, nome, endereco, tamanho);
                        DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(),
                                u.getSenha(), u.getPermissaoId());
                        diretor.alterarLocalCompeticao(ca);
                        informarSucessoAlteracaoLocalCompeticao(req, resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                informarErroAlteracaoLocalCompeticao(req, resp);
            }
        }
    }

    private int recuperarId(String query){ return Integer.valueOf(query.substring(query.lastIndexOf("=") + 1)); }


    public void informarSucessoAlteracaoLocalCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarLocalCompeticao", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroAlteracaoLocalCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterar", true);
        doGet(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        doGet(req, resp);
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }
    
}
