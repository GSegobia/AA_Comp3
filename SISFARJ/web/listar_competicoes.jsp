<%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 12/07/18
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="dominio.Competicao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Competicao> competicao = (ArrayList<Competicao>) request.getAttribute("competicoes"); %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Competicões</h2>
        <hr class="mb-5">
        <% { // TODO: Adicionar mensagem de "Não foram encontrados atletas"%>
        <table class="table" style="margin-left: 8%">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Data da Competição</th>

            </tr>
            </thead>
            <tbody style="margin-left: 8%">
            <% for(Competicao c : competicao) {%>
            <tr>
                <th scope="row"><%=c.getId() %></th>
                <td><%=c.getNome() %></td>
                <td><%=c.getDataCompeticao() %></td>
                <td style="border:none;">
                    <div class="btn-group btn-group-sm" role="toolbar">
                        <button type="button" class="btn btn-info btn-sm"> <i class="fa fa-edit"></i></button>
                        <button type="button" class="btn btn-success btn-sm" onclick="window.location = 'inserirResultados?id=<%=c.getId() %>';"> <i class="fa fa-exchange"></i></button>
                    </div>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        <% } %>
    </div>
</section>
<%@include file="default_footer.jsp"%>
