package servlet.diretortecnico;

import dominio.CentroAquatico;
import dominio.DiretorTecnico;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
@WebServlet("/incluirLocaisCompeticao")
public class IncluirLocaisCompeticao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else getServletContext().getRequestDispatcher("/criar_local_competicao.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome").trim();
            String endereco = req.getParameter("endereco").trim();
            int tamanho = Integer.parseInt(req.getParameter("tamanho").trim());

            CentroAquatico centro = new CentroAquatico(nome, endereco, tamanho);
            DiretorTecnico.incluirLocalCompeticao(centro);
        } catch (Exception e) {
            e.printStackTrace();
            informarErroCadastro(req, resp);
        }
    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/criar_local_competicao.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }

    public void informarErroCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroCadastro", true);
        getServletContext().getRequestDispatcher("/criar_local_competicao.jsp").forward(req, resp);
    }

    public void informarSucessoCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoCadastro", true);
        getServletContext().getRequestDispatcher("/criar_local_competicao.jsp").forward(req, resp);
    }


}
