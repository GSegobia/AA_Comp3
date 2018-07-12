package servlet.secretario;

import clojure.lang.Obj;
import dominio.*;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import org.omg.CORBA.INTERNAL;
import util.MiddlewareSessao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 11/07/18.
 * Edited by João V. Araújo on 12/07/18.
 */
@WebServlet("/alterarCadastroAtleta")
public class AlterarCadastroAtleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    String query = req.getQueryString();
                    Atleta atleta = Atleta.get(this.recuperarId(query));
                    Associacao associacao = Associacao.get(atleta.getAssociacao_id());
                    req.setAttribute("atleta", atleta);
                    req.setAttribute("associacao", associacao);
                    req.getRequestDispatcher("alterar_cadastro_atleta.jsp").forward(req, resp);
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
                Boolean possuiPermissaoSecretario = Usuario.checaPermissao(PermissaoUsuario.SECRETARIO.id, u.getId());
                Boolean possuiPermissaoDiretor = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId());
                if(!possuiPermissaoSecretario && !possuiPermissaoDiretor) { informarErroPermissao(req, resp); }
                else{
                    int id = Integer.valueOf(req.getParameter("id").trim());
                    String nome = req.getParameter("nome").trim();
                    String dataNascimento = req.getParameter("dataNascimento").trim();
                    String numeroOficio = req.getParameter("numeroOficio").trim();
                    String dataOficio = req.getParameter("dataOficio").trim();
                    String dataEntrada = req.getParameter("dataEntrada").trim();
                    String matriculaAssociacao = req.getParameter("matriculaAssociacao").trim();
                    String numComprovantePgto = req.getParameter("numComprovantePgto").trim();
//  Fellipe -                  String categoria = req.getParameter("categoria").trim();

                    if(nome.equals("") || dataNascimento.equals("") || numeroOficio.equals("") ||
                            dataOficio.equals("") || dataEntrada.equals("") || matriculaAssociacao.equals("") ||
                            numComprovantePgto.equals("")) {
                        informarErroPreenchimento(req, resp);
                    }else {
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

                        Associacao associacao = Associacao.get(matriculaAssociacao);
                        Atleta atleta = new Atleta(
                                id,
                                associacao.getId(),
                                1,                     // Fellipe - TODO: Inserir combobox de categoria na .jsp e tratar valor
                                associacao.getMatricula(),
                                nome,
                                sdf.parse(dataNascimento),
                                sdf.parse(dataOficio),
                                numeroOficio,
                                sdf.parse(dataEntrada),
                                numComprovantePgto
                        );

                        if(possuiPermissaoSecretario) {
                            Secretario secretario = new Secretario(u.getId(), u.getNome(), u.getMatricula(),
                                    u.getSenha(), u.getPermissaoId());

                            secretario.alterarAtleta(atleta);
                            informarSucessoAlteracao(req, resp);
                        } else if(possuiPermissaoDiretor){

                            DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(),
                                    u.getSenha(), u.getPermissaoId());

                            diretor.alterarAtleta(atleta);
                            informarSucessoAlteracao(req, resp);
                        }
                    }
                }
            }catch (MatriculaAssociacaoNaoEncontrada e) {
                e.printStackTrace();
                informarErroMatriculaAssociacao(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                informarErroAlteracao(req, resp);
            }
        }
    }

    private int recuperarId(String query){
        return Integer.valueOf(query.substring(query.lastIndexOf("=") + 1));
    }

    public void informarSucessoAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterar", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroAlteracao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterar", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    public void informarErroMatriculaAssociacao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroMatriculaAssociacao", true);
        req.getRequestDispatcher("alterar_cadastro_atleta.jsp").forward(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        req.getRequestDispatcher("alterar_cadastro_atleta.jsp").forward(req, resp);
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }
}
