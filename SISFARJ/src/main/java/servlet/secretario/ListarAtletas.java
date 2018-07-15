package servlet.secretario;

import dominio.Atleta;
import servlet.Identificacao;

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
public class ListarAtletas extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                List<Atleta> atletas = Atleta.findAll();
                req.setAttribute("atletas", atletas);
                getServletContext().getRequestDispatcher("/listar_atletas.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
