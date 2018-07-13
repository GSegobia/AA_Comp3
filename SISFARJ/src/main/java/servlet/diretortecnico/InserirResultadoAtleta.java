package servlet.diretortecnico;

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
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
@WebServlet("/inserirResultadoAtleta")
public class InserirResultadoAtleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiddlewareSessao.validar(req,resp);
        if(!resp.isCommitted()) {
            try {
                Usuario u = (Usuario) req.getSession().getAttribute("usuario");
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId()) || Usuario.checaPermissao(PermissaoUsuario.TECNICO_ASSOCIACAO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {
                    String query = req.getQueryString();
                    int prova_id = this.recuperarProvaId(query);
                    DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(), u.getSenha(), u.getPermissaoId());
                    ArrayList<Atleta> atletas = diretor.listarAtletaInProva(prova_id);
                    req.setAttribute("atletas", atletas);
                    req.setAttribute("id_prova", prova_id);
                    getServletContext().getRequestDispatcher("/inserir_resultado_atleta.jsp").forward(req, resp);
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
                Boolean possuiPermissao = Usuario.checaPermissao(PermissaoUsuario.DIRETOR_TECNICO.id, u.getId()) || Usuario.checaPermissao(PermissaoUsuario.TECNICO_ASSOCIACAO.id, u.getId());
                if(!possuiPermissao) { informarErroPermissao(req, resp); }
                else {

                    int prova_id = Integer.valueOf(req.getParameter("prova_id").trim());
                    String[] id =  req.getParameterValues("id[]");
                    String[] tempo = req.getParameterValues("tempo[]");

                    System.out.println();

                    if(tempo.equals("")) {
                        informarErroPreenchimento(req, resp);
                    }else {

                        if(possuiPermissao){
                            DiretorTecnico diretor = new DiretorTecnico(u.getId(), u.getNome(), u.getMatricula(),
                                    u.getSenha(), u.getPermissaoId());
                            for(int i=0; i< id.length; i++){
                                ResultadoProva rp = new ResultadoProva(tempo[i], prova_id, Integer.valueOf(id[i]));
                                diretor.inserirTempoAtleta(rp);
                            }
                            informarSucessoInserirTempo(req, resp);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                informarErroInserirTempo(req, resp);
            }
        }
    }


    private int recuperarProvaId(String query){
        return Integer.valueOf(query.substring(query.lastIndexOf("=") + 1));
    }


    public void informarSucessoInserirTempo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sucessoAlterar", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroInserirTempo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroAlterar", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroPreenchimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("erroPreenchimento", true);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void informarErroPermissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sem_permissao.jsp");
    }

}
