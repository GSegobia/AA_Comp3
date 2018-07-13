package servlet.diretortecnico;

import dominio.*;
import util.MiddlewareSessao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by  João V. Araújo on 12/07/18.
 */
@WebServlet("/listarProvas")
public class ListarProvas extends HttpServlet {

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
                    int competicao_id = this.recuperarId(query);
                    DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                    ArrayList<Prova> provas = diretor.listarProvas(competicao_id);
                    Competicao c = Competicao.get(competicao_id);
                    req.setAttribute("provas", provas);
                    req.setAttribute("competicao", c);
                    getServletContext().getRequestDispatcher("/listar_provas.jsp").forward(req, resp);
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

}
