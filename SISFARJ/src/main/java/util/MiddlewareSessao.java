package util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
public class MiddlewareSessao {

    public static void validar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("usuario") == null) {
            req.getServletContext().getRequestDispatcher("/sem_permissao.jsp").forward(req,resp);
        }
    }

}
