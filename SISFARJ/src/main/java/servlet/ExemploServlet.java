package servlet;

import dados.UsuarioDAO;
import dominio.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exemplo")
public class ExemploServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //MAS NAO É O DAO QUE DEVE FAZER ISSO AQUI, É APENAS UM EXEMPLO!!@#!@#
        Usuario u = UsuarioDAO.findAndGet(1);

        //nome do atributo a ser enviado para o servlet e ser recuperado usando request.getAttribute(nomeDoAtributo);
        request.setAttribute("nome",u.getNome());

        request.getRequestDispatcher("Exemplo.jsp").forward(request, response);
    }

}


