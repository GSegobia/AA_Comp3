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
<%@include file="default_header.jsp"%>
<% ArrayList<Associacao> associacoes = (ArrayList<Associacao>) request.getAttribute("associacoes"); %>

<!-- Lista de Associações -->
<% if (session.getAttribute("nomeUsuario") != null) { %>
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
            </tr>
            </thead>
            <tbody>
            <% for(Associacao a : associacoes) {%>
                <tr>
                    <th scope="row"><%=a.getId() %></th>
                    <td><%=a.getMatricula() %></td>
                    <td><%=a.getNome() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
        <% } %>
    </div>
</section>
<% } %>

</body>

</html>
