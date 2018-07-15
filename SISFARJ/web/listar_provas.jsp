<%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 12/07/18
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="dominio.CategoriaMap" %>
<%@ page import="dominio.ClasseMap" %>
<%@ page import="dominio.Competicao" %>
<%@ page import="dominio.Prova" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Competicao c = (Competicao) request.getAttribute("competicao"); %>
<% ArrayList<Prova> prova = (ArrayList<Prova>) request.getAttribute("provas"); %>


<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Provas</h2>
        <hr class="mb-5">
        <table class="table" style="margin-left: 8%">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Competição</th>
                <th scope="col">Tipo da Piscina</th>
                <th scope="col">Nome da Prova</th>
                <th scope="col">Categoria</th>
                <th scope="col">Classe</th>
            </tr>
            </thead>
            <tbody style="margin-left: 8%">
            <% for(Prova p : prova) {%>
            <tr>
                <th scope="row"><%=c.getId() %></th>
                <td><%=c.getNome() %></td>
                <td><%=c.getTamanhoPiscina() %></td>
                <td><%=p.getNome() %></td>
                <td><%=(CategoriaMap.getValue(p.getCategoria_id())).replace("_"," ") %></td>
                <td><%=(ClasseMap.getValue(p.getClasse_id())).replace("_"," ")%></td>
                <td style="border:none;">
                    <div class="btn-group btn-group-sm" role="toolbar">
                        <button type="button" class="btn btn-success btn-sm" onclick="window.location = 'inserirResultadoAtleta?idProva=<%=p.getId() %>&idCompeticao=<%=c.getId()%>';"> <i class="fa fa-edit"></i></button>
                        <button type="button" class="btn btn-warning btn-sm" onclick="window.location = 'inscreverAtletaCompeticao?idProva=<%=p.getId() %>&idCompeticao=<%=c.getId()%>'" > <i class="fa fa-exchange"></i></button>
                        <button type="button" class="btn btn-info btn-sm" onclick="window.location = 'listarBalizamentoCompeticao?idProva=<%=p.getId() %>&idCompeticao=<%=c.getId()%>';"> <i class="fa fa-eye"></i></button>
                        <button type="button" class="btn btn-link btn-sm" onclick="window.location = 'listarPontuacaoCompeticao?idProva=<%=p.getId() %>&idCompeticao=<%=c.getId()%>'" > <i class="fa fa-bar-chart"></i></button>
                    </div>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</section>
<%@include file="default_footer.jsp"%>
