package servlet.diretortecnico;

import dominio.Competicao;
import dominio.Prova;
import servlet.Identificacao;

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
public class ListarProvas extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int competicao_id = Integer.valueOf(req.getParameter("id"));
            Competicao c = Competicao.get(competicao_id);
            List<Prova> provas = c.listarProvas(competicao_id);
            req.setAttribute("provas", provas);
            req.setAttribute("competicao", c);
            getServletContext().getRequestDispatcher("/listar_provas.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
