package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 09/07/18.
 */
@WebServlet("/identificar")
public class IdentificarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Receber dados do Request
        String matricula = req.getParameter("matricula").trim();
        String senha = req.getParameter("senha").trim();

        if(matricula.equals("") || senha.equals("")) {
            informarErroIdentificacao(req, resp);
        }
        else {
            // TODO: Chamar responsável por Identificar Usuário
//        try {
//
//        }
//        catch (DadosIdentificacaoIncorretos e) {
//            e.printStackTrace();
//            informarErroIdentificacao(req, resp);
//            return;
//        }
            permitirAcesso(req, resp);
        }

    }

    public void permitirAcesso(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: Definir tempo de sessão do usuário DEFAULT 10 min
        req.getSession().setAttribute("nomeUsuario", "Unknown");
        req.getSession().setMaxInactiveInterval(600);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroIdentificacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("erroIdentificacao", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
