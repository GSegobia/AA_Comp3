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
 */
@WebServlet("/listarLocaisCompeticao")
public class ListarLocaisCompeticao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId()) || Usuario.checaPermissao(PermissaoUsuario.TECNICO_ASSOCIACAO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                    ArrayList<CentroAquatico> lc = diretor.listarLocaisCompeticao();
                    req.setAttribute("lcompeticoes", lc);
                    getServletContext().getRequestDispatcher("/listar_locais_competicao.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

}
