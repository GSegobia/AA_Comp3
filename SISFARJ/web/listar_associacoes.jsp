<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="dominio.Associacao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Associacao> associacoes = (ArrayList<Associacao>) request.getAttribute("associacoes"); %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Associações</h2>
        <hr class="mb-5">
        <% { // TODO: Adicionar mensagem de "Não foram encontradas associações"%>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Matrícula</th>
                <th scope="col">Nome</th>
                <th scope="col">Ações</th>
            </tr>
            </thead>
            <tbody>
            <% for(Associacao a : associacoes) {%>
                <tr>
                    <th scope="row"><%=a.getId() %></th>
                    <td><%=a.getMatricula() %></td>
                    <td><%=a.getNome() %></td>
                    <td>
                        <div class="btn-group btn-group-sm" role="toolbar">
                            <a class="btn btn-info btn-sm" href="alterarFiliacaoAssociacao?id=<%=a.getId()%>"> <i class="fa fa-edit"></i></a>
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

