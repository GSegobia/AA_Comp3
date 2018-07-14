package servlet.diretortecnico;

import dominio.Atleta;
import dominio.DiretorTecnico;
import dominio.ResultadoProva;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
@WebServlet("/inserirResultadoAtleta")
public class InserirResultadoAtleta extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else {
            try {
                int prova_id = Integer.valueOf(req.getParameter("id"));
                ArrayList<Atleta> atletas = DiretorTecnico.listarAtletaInProva(prova_id);
                req.setAttribute("atletas", atletas);
                req.setAttribute("id_prova", prova_id);
                getServletContext().getRequestDispatcher("/inserir_resultado_atleta.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int prova_id = Integer.valueOf(req.getParameter("prova_id").trim());
            String[] id =  req.getParameterValues("id[]");
            String[] tempo = req.getParameterValues("tempo[]");

            // TODO: Exception lançada pela camada de domínio
            if(tempo.equals("")) { informarErroPreenchimento(req, resp); }
            else {
                for(int i=0; i< id.length; i++){
                    ResultadoProva rp = new ResultadoProva(tempo[i], prova_id, Integer.valueOf(id[i]));
                    DiretorTecnico.inserirTempoAtleta(rp);
                }
                informarSucessoInserirTempo(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            informarErroInserirTempo(req, resp);
        }
    }

    @Override
    public void validarIdentidade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("referencia", "/index.jsp");
        getServletContext().getRequestDispatcher("/identificar.jsp").forward(req, resp);
    }

    public void informarSucessoInserirTempo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterar", true);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void informarErroInserirTempo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterar", true);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
