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
import java.text.SimpleDateFormat;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
@WebServlet("/alterarFiliacaoAssociacao")
public class AlterarFiliacaoAssociacao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                int id =  Integer.valueOf(req.getParameter("id").trim());
                Associacao associacao = Associacao.get(id);
                req.setAttribute("associacao", associacao);
                getServletContext().getRequestDispatcher("/alterar_filiacao_associacao.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

            Associacao a = (Associacao) req.getAttribute("associacao");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            a.setNome(nome);
            a.setSigla(sigla);
            a.setNumeroOficio(numeroOficio);
            a.setTelefone(telefone);
            a.setDataOficio(sdf.parse(data));
            a.setNumComprovantePgto(numComprovantePgto);
            a.setEndereco(endereco);
            req.setAttribute("associacao", a);

            a.update();
            informarSucessoAlteracao(req, resp);
        }
        catch (ErroPreenchimento e){
            e.printStackTrace();
            informarErroPreenchimento(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
            informarErroAlteracao(req, resp);
        }
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        doGet(req, resp);
    }

    public void informarSucessoAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarFiliacaoAssociacao", true);
        doGet(req, resp);
    }

    public void informarErroAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterarFiliacaoAssociacao", true);
        doGet(req, resp);
    }
}
