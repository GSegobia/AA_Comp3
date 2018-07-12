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
 * Created by Fellipe Bravo on 10/07/18.
 */
@WebServlet("/cadastrarAtleta")
public class CadastrarAtleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else { req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp); }
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
                if (!possuiPermissao) {
                    informarErroPermissao(req, resp);
                } else {
                    // Receber dados do Request
                    String nome = req.getParameter("nome").trim();
                    String dataNascimento = req.getParameter("dataNascimento").trim();
                    String numeroOficio = req.getParameter("numeroOficio").trim();
                    String dataOficio = req.getParameter("dataOficio").trim();
                    String dataEntrada = req.getParameter("dataEntrada").trim();
                    String matriculaAssociacao = req.getParameter("matriculaAssociacao").trim();
                    String numComprovantePgto = req.getParameter("numComprovantePgto").trim();
//                    String categoria = req.getParameter("categoria").trim();

                    if (nome.equals("") || dataNascimento.equals("") || numeroOficio.equals("") ||
                            dataOficio.equals("") || dataEntrada.equals("") || matriculaAssociacao.equals("") ||
                            numComprovantePgto.equals("")) {
                        informarErroPreenchimento(req, resp);
                    } else {
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                        Secretario secretario = new Secretario(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                        Associacao associacao = Associacao.get(matriculaAssociacao);
                        Atleta atleta = new Atleta(
                                associacao.getId(),
                                1,                     // TODO: Inserir combobox de categoria na .jsp e tratar valor
                                associacao.getMatricula(),
                                nome,
                                sdf.parse(dataNascimento),
                                sdf.parse(dataOficio),
                                numeroOficio,
                                sdf.parse(dataEntrada),
                                numComprovantePgto
                        );
                        secretario.cadastrarAtleta(atleta);
                        informarSucessoCadastro(req, resp);
                    }
                }
            } catch (MatriculaAssociacaoNaoEncontrada e) {
                e.printStackTrace();
                informarErroMatriculaAssociacao(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                informarErroCadastro(req, resp);
            }
        }
    }

    public void informarSucessoCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoCadastro", true);
        req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp);
    }

    public void informarErroCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroCadastro", true);
        req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp);
    }
    public void informarErroMatriculaAssociacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroMatriculaAssociacao", true);
        req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        req.getRequestDispatcher("cadastrar_atleta.jsp").forward(req, resp);
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

}
