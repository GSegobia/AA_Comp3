package servlet.secretario;

import dominio.*;
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
                    Secretario secretario = new Secretario(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
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

                        Associacao associacao = Associacao.get(novaMatricula);

                        int idAssociacaoAlterar = associacao.getId();
                        atleta.setAssociacao_id(idAssociacaoAlterar);
                        atleta.setNumero_oficio(numeroOficio);
                        atleta.setData_oficio(sdf.parse(dataOficio));
                        atleta.setData_entrada_associacao(sdf.parse(dataEntrada));
                        atleta.setNum_comprovante_pgto(numComprovantePgto);

                        if(secretario.alterarAtleta(atleta)) informarSucessoTransferencia(req,resp);
                        else informarErroTransferencia(req, resp);

                    }

                }
            } catch (MatriculaAssociacaoNaoEncontrada e) {
                e.printStackTrace();
                informarErroMatriculaAssociacao(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

    private void informarErroTransferencia(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroTransferencia", true);
        doGet(req,resp);
    }

    public void informarErroMatriculaAssociacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroMatriculaAssociacao", true);
        doGet(req, resp);
    }

    private void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        doGet(req,resp);
    }

    public void informarSucessoTransferencia(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoTransferencia", true);
        doGet(req,resp);
    }
}
