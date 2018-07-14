package servlet.diretortecnico;

import dominio.Competicao;
import dominio.DiretorTecnico;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/listarCompeticoes")
public class ListarCompeticoes extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                List<Competicao> competicoes = Competicao.findAll();
                req.setAttribute("competicoes", competicoes);
                getServletContext().getRequestDispatcher("/listar_competicoes.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/listar_competicoes.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }
}
