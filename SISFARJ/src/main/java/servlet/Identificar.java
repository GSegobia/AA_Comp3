package servlet;

import dominio.Associacao;

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
public class Identificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Receber dados do Request
        String referencia = req.getParameter("referencia");
        String matricula = req.getParameter("matricula").trim();
        String senha = req.getParameter("senha").trim();

        try {
            Associacao associacao = Associacao.identificar(matricula, senha);
            permitirAcesso(associacao, referencia, req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
            informarErroIdentificacao(referencia, req, resp);
        }
    }

    public void permitirAcesso(Associacao associacao, String referencia, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: Definir tempo de sessão do usuário DEFAULT 10 min
        req.getSession().setAttribute("associacao", associacao);
        req.getSession().setMaxInactiveInterval(600);
        req.setAttribute("sucessoIdentificacao", true);
        getServletContext().getRequestDispatcher(referencia).forward(req, resp);
    }

    public void informarErroIdentificacao(String referencia, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", referencia);
        req.setAttribute("erroIdentificacao", true);
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }

}
