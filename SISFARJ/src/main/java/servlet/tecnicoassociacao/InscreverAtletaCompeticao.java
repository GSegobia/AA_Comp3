package servlet.tecnicoassociacao;

import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
@WebServlet("/inscreverAtletaCompeticao")
public class InscreverAtletaCompeticao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/inscrever_atleta_competicao.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }
}
