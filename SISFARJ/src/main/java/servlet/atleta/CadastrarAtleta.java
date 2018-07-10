package servlet.atleta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/atleta")
public class CadastrarAtleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Receber dados do Request
        String nome = req.getParameter("nome").trim();
        String dataNascimento = req.getParameter("dataNascimento").trim();
        String numeroOficio = req.getParameter("numeroOficio").trim();
        String dataOficio = req.getParameter("dataOficio").trim();
        String dataEntrada = req.getParameter("dataEntrada").trim();
        String matriculaAssociacao = req.getParameter("matriculaAssociacao").trim();
        String numComprovantePgto = req.getParameter("numComprovantePgto").trim();

        if(nome.equals("") || dataNascimento.equals("") || numeroOficio.equals("") ||
                dataOficio.equals("") || dataEntrada.equals("") || matriculaAssociacao.equals("") ||
                numComprovantePgto.equals("")) {
            informarErroPreenchimento(req, resp);
        }
        else {
            // TODO: Lógica de cadastro
        }


    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("erroPreenchimento", true);
        req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp);
    }

}
