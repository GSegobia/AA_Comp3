package servlet.diretortecnico;

import dominio.CentroAquatico;
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
 */
@WebServlet("/criarCompeticao")
public class    CriarCompeticao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                List<CentroAquatico> locais = CentroAquatico.findAll();
                req.setAttribute("locaisProva", locais);
                getServletContext().getRequestDispatcher("/criar_competicao.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/criar_competicao.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }
}
