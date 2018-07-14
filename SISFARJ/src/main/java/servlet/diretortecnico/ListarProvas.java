package servlet.diretortecnico;

import dominio.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by  João V. Araújo on 12/07/18.
 */
@WebServlet("/listarProvas")
public class ListarProvas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Boolean possuiPermissao = false;
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");

                if(u != null) {
                    possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId()) || Usuario.checaPermissao(PermissaoUsuario.TECNICO_ASSOCIACAO.id, u.getId());
                }else{
                    //informarErroPermissao(req, resp);
                    String query = req.getQueryString();
                    int competicao_id = this.recuperarId(query);
                    List<Prova> provas = Competicao.listarProvas(competicao_id);
                    Competicao c = Competicao.get(competicao_id);
                    req.setAttribute("provas", provas);
                    req.setAttribute("competicao", c);
                    getServletContext().getRequestDispatcher("/listar_provas.jsp").forward(req, resp);
                }
                if(!possuiPermissao) {

                }else {
                    String query = req.getQueryString();
                    int competicao_id = this.recuperarId(query);
                    DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                    List<Prova> provas = diretor.listarProvas(competicao_id);
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
