package servlet.secretario;

import dominio.Associacao;
import dominio.Atleta;
import dominio.DiretorTecnico;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/alterarCadastroAtleta")
public class AlterarCadastroAtleta extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                int id = Integer.valueOf(req.getParameter("id"));
                Atleta atleta = Atleta.get(id);
                Associacao associacao = Associacao.get(atleta.getAssociacao_id());
                req.setAttribute("atleta", atleta);
                req.setAttribute("associacao", associacao);
                getServletContext().getRequestDispatcher("/alterar_cadastro_atleta.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id").trim());
            String nome = req.getParameter("nome").trim();
            String dataNascimento = req.getParameter("dataNascimento").trim();
            String numeroOficio = req.getParameter("numeroOficio").trim();
            String dataOficio = req.getParameter("dataOficio").trim();
            String dataEntrada = req.getParameter("dataEntrada").trim();
            String matriculaAssociacao = req.getParameter("matriculaAssociacao").trim();
            String numComprovantePgto = req.getParameter("numComprovantePgto").trim();
//  Fellipe -                  String categoria = req.getParameter("categoria").trim();

            // TODO: Exception lançada pela camada de domínio
            if(nome.equals("") || dataNascimento.equals("") || numeroOficio.equals("") ||
                    dataOficio.equals("") || dataEntrada.equals("") || matriculaAssociacao.equals("") ||
                    numComprovantePgto.equals("")) {
                informarErroPreenchimento(req, resp);
            }
            else {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

                Associacao associacao = Associacao.get(matriculaAssociacao);
                Atleta atleta = new Atleta(
                        id,
                        associacao.getId(),
                        1,                     // Fellipe - TODO: Inserir combobox de categoria na .jsp e tratar valor
                        associacao.getMatricula(),
                        nome,
                        sdf.parse(dataNascimento),
                        sdf.parse(dataOficio),
                        numeroOficio,
                        sdf.parse(dataEntrada),
                        numComprovantePgto
                );

                if(DiretorTecnico.alterarAtleta(atleta)) informarSucessoAlteracao(req, resp);
                else informarErroAlteracao(req, resp);
            }
        }catch (MatriculaAssociacaoNaoEncontrada e) {
            e.printStackTrace();
            informarErroMatriculaAssociacao(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            informarErroAlteracao(req, resp);
        }
    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/index.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }

    public void informarSucessoAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarAtleta", true);
        doGet(req, resp);
    }

    public void informarErroAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterarAtleta", true);
        doGet(req, resp);
    }
    public void informarErroMatriculaAssociacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroMatriculaAssociacao", true);
        doGet(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        doGet(req, resp);
    }
}
