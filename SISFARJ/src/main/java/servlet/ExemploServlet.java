package servlet;

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
        Usuario u = null;

        try {
            //Alguns metodos de usuario são estáticos
            u = Usuario.getUsuario(3);
            //nome do atributo a ser enviado para o servlet e ser recuperado usando request.getAttribute(nomeDoAtributo);
            request.setAttribute("nome",u.getNome());

            request.getRequestDispatcher("Exemplo.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
            //envia pra página do erro, possivel também um catch para cada tipo de erro ao invés do genérico Exception
            request.getRequestDispatcher("ExemploErro.jsp").forward(request, response);
        }
    }

}
