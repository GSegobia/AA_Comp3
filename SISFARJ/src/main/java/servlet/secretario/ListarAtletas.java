package servlet.secretario;

import dominio.Atleta;
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
import java.util.List;

/**
 * Created by Fellipe Bravo on 10/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/listarAtletas")
public class ListarAtletas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    Secretario secretario = new Secretario(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                    List<Atleta> atletas = secretario.listarAtletas();
                    req.setAttribute("atletas", atletas);
                    getServletContext().getRequestDispatcher("/listar_atletas.jsp").forward(req, resp);
                }

            } catch (Exception e) {
                e.printStackTrace();
                informarErroPermissao(req, resp);
            }
        }
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

}
