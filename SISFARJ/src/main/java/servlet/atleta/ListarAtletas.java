package servlet.atleta;

import dominio.Atleta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/atletas")
public class ListarAtletas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Atleta> atletas= Atleta.getAtletas();
            req.setAttribute("atletas", atletas);
            req.getRequestDispatcher("listar_atletas.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("atletas", null);
        }
    }
}
