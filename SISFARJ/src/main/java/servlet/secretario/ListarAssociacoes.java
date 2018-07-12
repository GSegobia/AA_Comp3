package servlet.secretario;

import dominio.Associacao;
import util.MiddlewareSessao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/listarAssociacoes")
public class ListarAssociacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                ArrayList<Associacao> associacoes = Associacao.getAssociacoes();
                req.setAttribute("associacoes", associacoes);
                req.getRequestDispatcher("listar_associacoes.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("associacoes", null);
            }
        }
    }
}
