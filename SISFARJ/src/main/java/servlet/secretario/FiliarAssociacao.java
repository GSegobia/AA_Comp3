package servlet.secretario;

import dominio.Associacao;
import dominio.Secretario;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

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

            // TODO: Exception lançada pela camada de domínio
            if(nome.equals("") || sigla.equals("") || numeroOficio.equals("") || telefone.equals("") ||
                    data.equals("") || numComprovantePgto.equals("") || endereco.equals("")){
                informarErroPreenchimento(req, resp);
            }
            else {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                Associacao associacao = new Associacao(
                        numeroOficio,
                        sdf.parse(data),
                        nome,
                        sigla,
                        "MAT123" + sigla,
                        endereco,
                        telefone,
                        numComprovantePgto
                );
                Secretario.filiarAssociacao(associacao);
                informarSucessoCadastro(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            informarErroCadastro(req, resp);
        }
    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/filiar_associacao.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
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
