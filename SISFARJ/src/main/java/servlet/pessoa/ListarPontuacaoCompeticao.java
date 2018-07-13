package servlet.pessoa;

import dominio.Associacao;
import dominio.Atleta;
import dominio.Competicao;
import dominio.ResultadoProva;
import exceptions.ModeloNaoExiste;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/listarPontuacaoCompeticao")
public class ListarPontuacaoCompeticao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String query = req.getQueryString();
        int id = this.recuperarId(query);
        if(id == 0){
            ArrayList<Competicao> competicoes = null;

            try {
                competicoes = Competicao.findAll();
                req.setAttribute("competicoes", competicoes);
                getServletContext().getRequestDispatcher("/listar_competicoes.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            try {
                ArrayList<ResultadoProva> rp = ResultadoProva.findAllByTempo(id);
                ArrayList<Atleta> at = new ArrayList<>();
                for (ResultadoProva r: rp) {
                    Atleta atleta = Atleta.get(r.getAtleta_id());
                    at.add(atleta);
                    atleta = null;
                }
                try {
                    ArrayList<Associacao> aas = new ArrayList<>();
                    for (Atleta a: at ) {
                        Associacao as = Associacao.get(a.getAssociacao_id());
                        aas.add(as);
                        as = null;
                    }
                    req.setAttribute("resultados", rp);
                    req.setAttribute("atletas", at);
                    req.setAttribute("associacao", aas);
                    getServletContext().getRequestDispatcher("/listar_provas_pontos.jsp").forward(req, resp);
                } catch (ModeloNaoExiste modeloNaoExiste) {
                    modeloNaoExiste.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ModeloNaoExiste modeloNaoExiste) {
                modeloNaoExiste.printStackTrace();
            }


        }


    }

    private int recuperarId(String query){
        return Integer.valueOf(query.substring(query.lastIndexOf("=") + 1));
    }

}
