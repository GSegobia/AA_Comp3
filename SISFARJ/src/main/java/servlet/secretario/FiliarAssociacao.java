package servlet.secretario;

import dominio.Associacao;
import exceptions.ErroPreenchimento;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/filiarAssociacao")
public class FiliarAssociacao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else getServletContext().getRequestDispatcher("/filiar_associacao.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome").trim();
            String sigla = req.getParameter("sigla").trim();
            String numeroOficio = req.getParameter("numeroOficio").trim();
            String telefone = req.getParameter("telefone").trim();
            String data = req.getParameter("data").trim();
            String numComprovantePgto = req.getParameter("numComprovantePgto").trim();
            String endereco = req.getParameter("endereco").trim();

            Associacao associacao = new Associacao(
                    numeroOficio,
                    data,
                    nome,
                    sigla,
                    "MAT123" + sigla,
                    endereco,
                    telefone,
                    numComprovantePgto
            );
            associacao.create(associacao);
            informarSucessoCadastro(req, resp);
        }
        catch (ErroPreenchimento e) {
            e.printStackTrace();
            informarErroPreenchimento(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
            informarErroCadastro(req, resp);
        }
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        getServletContext().getRequestDispatcher("/filiar_associacao.jsp").forward(req, resp);
    }

    public void informarSucessoCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoFiliarAssociacao", true);
        getServletContext().getRequestDispatcher("/filiar_associacao.jsp").forward(req, resp);
    }

    public void informarErroCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroFiliarAssociacao", true);
        getServletContext().getRequestDispatcher("/filiar_associacao.jsp").forward(req, resp);
    }
}
