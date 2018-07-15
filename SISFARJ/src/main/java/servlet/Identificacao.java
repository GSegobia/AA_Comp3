package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public interface Identificacao {
    default void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String queryString = req.getQueryString();
        String referencia = queryString == null ? uri : String.format("%s?%s", uri, queryString);
        req.setAttribute("referencia", referencia);
        req.getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }
}
