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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/listarPontuacaoCompeticao")
public class ListarPontuacaoCompeticao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("idProva"));
        if(id == 0){
            List<Competicao> competicoes = null;
            try {
                competicoes = Competicao.findAll();
                req.setAttribute("competicoes", competicoes);
                getServletContext().getRequestDispatcher("/listar_competicoes.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                int prova_id = Integer.valueOf(req.getParameter("idProva"));
                int competicao_id = Integer.valueOf(req.getParameter("idCompeticao"));
                ArrayList<ResultadoProva> rp = ResultadoProva.findAllByTempo(competicao_id, prova_id);
                ArrayList<Atleta> at = new ArrayList<>();
                ArrayList<Associacao> aas = new ArrayList<>();
                for (ResultadoProva r : rp) {
                    Atleta atleta = Atleta.get(r.getAtleta_id());
                    at.add(atleta);
                }
                for (Atleta a : at) {
                    Associacao as = Associacao.get(a.getAssociacao_id());
                    aas.add(as);
                }
                req.setAttribute("resultados", rp);
                req.setAttribute("atletas", at);
                req.setAttribute("associacao", aas);
                getServletContext().getRequestDispatcher("/listar_provas_pontos.jsp").forward(req, resp);
            }catch (ModeloNaoExiste modeloNaoExiste) {
                modeloNaoExiste.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
