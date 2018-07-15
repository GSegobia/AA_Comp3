package servlet.diretortecnico;

import dominio.CentroAquatico;
import exceptions.ErroPreenchimento;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/alterarLocaisCompeticao")
public class AlterarLocaisCompeticao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                int lc_id = Integer.valueOf(req.getParameter("id"));
                CentroAquatico ca = CentroAquatico.get(lc_id);
                req.setAttribute("lc_id", lc_id);
                req.setAttribute("lc", ca);
                getServletContext().getRequestDispatcher("/alterar_local_competicao.jsp").forward(req, resp);
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
            String endereco = req.getParameter("endereco").trim();
            int tamanho = Integer.valueOf(req.getParameter("piscina").trim());

            CentroAquatico ca = new CentroAquatico(id, nome, endereco, tamanho);

            if(ca.update(ca))informarSucessoAlteracaoLocalCompeticao(req, resp);
            else informarErroAlteracaoLocalCompeticao(req, resp);

        } catch (ErroPreenchimento e) {
            e.printStackTrace();
            informarErroAlteracaoLocalCompeticao(req, resp);
        } catch (Exception e){
            e.printStackTrace();
            informarErroAlteracaoLocalCompeticao(req, resp);
        }
    }

    public void informarSucessoAlteracaoLocalCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarLocalCompeticao", true);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void informarErroAlteracaoLocalCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterarLocalCompeticao", true);
        doGet(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        doGet(req, resp);
    }
    
}
