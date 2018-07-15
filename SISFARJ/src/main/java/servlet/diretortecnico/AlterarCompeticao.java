package servlet.diretortecnico;

import dominio.Competicao;
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
@WebServlet("/alterarCompeticao")
public class AlterarCompeticao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else{
            try {
                int id = Integer.valueOf(req.getParameter("id"));
                Competicao ca = Competicao.get(id);
                req.setAttribute("competicao", ca);
                req.setAttribute("id",id);
                getServletContext().getRequestDispatcher("/alterar_competicao.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.valueOf(req.getParameter("id").trim());
            String nome = req.getParameter("nomeCompeticao").trim();
            String dataCompeticao = req.getParameter("dataCompeticao").trim();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Competicao ca = Competicao.get(id);
            ca.setNome(nome);
            ca.setDataCompeticao(sdf.parse(dataCompeticao));

            if(ca.update(ca))informarSucessoAlteracaoCompeticao(req, resp);
            else informarErroAlteracaoCompeticao(req, resp);

        } catch (ErroPreenchimento e) {
            e.printStackTrace();
            informarErroAlteracaoCompeticao(req, resp);
        } catch (Exception e){
            e.printStackTrace();
            informarErroAlteracaoCompeticao(req, resp);
        }
    }

    public void informarSucessoAlteracaoCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarCompeticao", true);
        doGet(req, resp);
    }

    public void informarErroAlteracaoCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterarCompeticao", true);
        doGet(req, resp);
    }
}
