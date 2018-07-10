package servlet;

import dominio.Usuario;

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

        if(matricula.equals("") || senha.equals("")) { informarErroIdentificacao(req, resp); }
        else {
            try {
                Usuario usuario = Usuario.identificar(matricula, senha);
                permitirAcesso(usuario, req, resp);
            }
            catch (Exception e) {
                e.printStackTrace();
                informarErroIdentificacao(req, resp);
            }
        }
    }

    public void permitirAcesso(Usuario usuario, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("sucessoIdentificacao", true);
        req.getSession().setAttribute("erroIdentificacao", false);
        // TODO: Definir tempo de sessão do usuário DEFAULT 10 min
        req.getSession().setAttribute("nomeUsuario", usuario.getNome());
        req.getSession().setMaxInactiveInterval(600);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroIdentificacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("sucessoIdentificacao", false);
        req.getSession().setAttribute("erroIdentificacao", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
