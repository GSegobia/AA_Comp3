package servlet.secretario;

import dominio.Associacao;
import dominio.Atleta;
import dominio.PermissaoUsuario;
import dominio.Usuario;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import util.MiddlewareSessao;

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
@WebServlet("/transferirAtleta")
public class TransferirAtleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {

                    int idAtleta = Integer.valueOf(req.getParameter("id"));

                    Atleta a = Atleta.get(idAtleta);

                    Associacao assocAtual = Associacao.get(a.getAssociacao_id());

                    req.setAttribute("atleta", a);

                    req.setAttribute("associacaoAtual", assocAtual);

                    getServletContext().getRequestDispatcher("/transferir_atleta.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {

                    int idAtleta = Integer.valueOf(req.getParameter("id"));

                    Atleta atleta = Atleta.get(idAtleta);

                    String novaMatricula = req.getParameter("novaMatricula").trim();
                    String numeroOficio = req.getParameter("numeroOficio").trim();
                    String dataOficio = req.getParameter("dataOficio").trim();
                    String dataEntrada = req.getParameter("dataEntrada").trim();
                    String numComprovantePgto = req.getParameter("numComprovantePgto").trim();

                    if (novaMatricula.equals("") || numeroOficio.equals("") || dataOficio.equals("") ||
                            dataEntrada.equals("") || numComprovantePgto.equals("")) {
                        informarErroPreenchimento(req, resp);
                    } else {

                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

                        int idAssociacaoAlterar = Associacao.get(novaMatricula).getId();

                        atleta.setAssociacao_id(idAssociacaoAlterar);
                        atleta.setNumero_oficio(numeroOficio);
                        atleta.setData_oficio(sdf.parse(dataOficio));
                        atleta.setData_entrada_associacao(sdf.parse(dataEntrada));
                        atleta.setNum_comprovante_pgto(numComprovantePgto);

                        Atleta.update(atleta);
                    }

                }
            } catch (MatriculaAssociacaoNaoEncontrada e) {
                informarErroCadastro(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

    private void informarErroCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroTransferencia", true);
        req.getRequestDispatcher("transferir_atleta.jsp").forward(req, resp);
    }

    private void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        req.getRequestDispatcher("transferir_atleta.jsp").forward(req, resp);
    }
}
