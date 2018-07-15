package servlet.tecnicoassociacao;

import dominio.Atleta;
import dominio.CompeticaoProva;
import dominio.ProvaAtleta;
import exceptions.ErroPreenchimento;
import servlet.Identificacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by João V. Araújo on 15/07/18.
 */
@WebServlet("/inscreverAtletaCompeticao")
public class InscreverAtletaCompeticao extends HttpServlet implements Identificacao {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("associacao") == null) validarIdentidade(req, resp);
        else{
            try {
                int prova_id = Integer.valueOf(req.getParameter("idProva"));
                int competicao_id = Integer.valueOf(req.getParameter("idCompeticao"));
                int provacompeticao = CompeticaoProva.findProvaCompeticao(competicao_id, prova_id);
                List<Atleta> atletas = Atleta.findAll();
                req.setAttribute("atletas", atletas);
                req.setAttribute("id", provacompeticao);
                req.setAttribute("idProva", prova_id);
                req.setAttribute("idCompeticao", competicao_id);
                getServletContext().getRequestDispatcher("/inscrever_atleta_competicao.jsp").forward(req, resp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id"));
            int id_prova = Integer.valueOf(req.getParameter("idProva"));
            int id_competicao = Integer.valueOf(req.getParameter("idCompeticao"));
            String[] idsAtleta =  req.getParameterValues("atleta[]");
            String matricula = req.getParameter("matricula").trim();

            for(int i=0; i< idsAtleta.length; i++){
                ProvaAtleta pa = new ProvaAtleta(id, Integer.valueOf(idsAtleta[i]));
                if(pa.verificarAtleta(id_competicao, id_prova, matricula)){
                    pa.create(pa);
                    informarSucessoInscreverAtleta(req, resp);
                }
                else informarErroInscreverAtleta(req, resp);
            }
        } catch (Exception e){
            e.printStackTrace();
            informarErroInscreverAtleta(req, resp);
        }
    }

    public void informarSucessoInscreverAtleta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoInserirAtletaCompeticao", true);
        doGet(req, resp);
    }

    public void informarErroInscreverAtleta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroInserirAtletaCompeticao", true);
        doGet(req, resp);
    }

}
