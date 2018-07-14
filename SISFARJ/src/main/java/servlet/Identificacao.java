package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public interface Identificacao {
    void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
