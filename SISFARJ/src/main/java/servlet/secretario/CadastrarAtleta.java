package servlet.secretario;

import dominio.Associacao;
import dominio.Atleta;
import dominio.Secretario;
import exceptions.ErroPreenchimento;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/cadastrarAtleta")
public class CadastrarAtleta extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else getServletContext().getRequestDispatcher("/cadastrar_atleta.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Receber dados do Request
            String nome = req.getParameter("nome").trim();
            String dataNascimento = req.getParameter("dataNascimento").trim();
            String numeroOficio = req.getParameter("numeroOficio").trim();
            String dataOficio = req.getParameter("dataOficio").trim();
            String dataEntrada = req.getParameter("dataEntrada").trim();
            String matriculaAssociacao = req.getParameter("matriculaAssociacao").trim();
            String numComprovantePgto = req.getParameter("numComprovantePgto").trim();
//                    String categoria = req.getParameter("categoria").trim();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Associacao associacao = Associacao.get(matriculaAssociacao);
            Atleta atleta = new Atleta(
                    associacao.getId(),
                    1,                     // TODO: Inserir combobox de categoria na .jsp e tratar valor
                    associacao.getMatricula(),
                    nome,
                    sdf.parse(dataNascimento),
                    sdf.parse(dataOficio),
                    numeroOficio,
                    sdf.parse(dataEntrada),
                    numComprovantePgto
            );
            atleta.create();
            informarSucessoCadastro(req, resp);

        } catch (MatriculaAssociacaoNaoEncontrada e) {
            e.printStackTrace();
            informarErroMatriculaAssociacao(req, resp);
        } catch (ErroPreenchimento e){
            e.printStackTrace();
            informarErroPreenchimento(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
            informarErroCadastro(req, resp);
        }
    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/cadastrar_atleta.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }

    public void informarSucessoCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoCadastro", true);
        getServletContext().getRequestDispatcher("/cadastrar_atleta.jsp").forward(req, resp);
    }

    public void informarErroCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroCadastro", true);
        getServletContext().getRequestDispatcher("/cadastrar_atleta.jsp").forward(req, resp);
    }
    public void informarErroMatriculaAssociacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroMatriculaAssociacao", true);
        getServletContext().getRequestDispatcher("/cadastrar_atleta.jsp").forward(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        getServletContext().getRequestDispatcher("/cadastrar_atleta.jsp").forward(req, resp);
    }

}
