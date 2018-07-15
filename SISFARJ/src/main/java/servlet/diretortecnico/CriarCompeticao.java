package servlet.diretortecnico;

import dominio.CentroAquatico;
import dominio.Competicao;
import dominio.CompeticaoProva;
import dominio.Prova;
import exceptions.ErroPreenchimento;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                List<Prova> provas = Prova.findAll();
                req.setAttribute("locaisProva", locais);
                req.setAttribute("provas", provas);
                getServletContext().getRequestDispatcher("/criar_competicao.jsp").forward(req, resp);
            }   catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String[] prova =  req.getParameterValues("prova[]");
            String nome = req.getParameter("nomeCompeticao").trim();
            String dataCompeticao = req.getParameter("dataCompeticao").trim();
            int idLocalCompeticao = Integer.valueOf(req.getParameter("local").trim());
            int tamanhoPiscina = Integer.valueOf(req.getParameter("tipoPiscina").trim());

            Competicao c = new Competicao(nome, idLocalCompeticao, sdf.parse(dataCompeticao),tamanhoPiscina);
            c.create(c);
            int competicao_id = c.getCompeticaoId(c);

            for(int i=0; i< prova.length; i++){
                CompeticaoProva cp = new CompeticaoProva(competicao_id, Integer.valueOf(prova[i]));
                cp.create(cp);
                cp = null;
            }
            informarSucessoCriarCompeticao(req, resp);

        } catch (ErroPreenchimento e) {
            e.printStackTrace();
            informarErroCriarCompeticao(req, resp);
        } catch (Exception e){
            e.printStackTrace();
            informarErroCriarCompeticao(req, resp);
        }
    }

    public void informarSucessoCriarCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoCadastroCompeticao", true);
        doGet(req, resp);
    }

    public void informarErroCriarCompeticao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroCadastroCompeticao", true);
        doGet(req, resp);
    }

}
