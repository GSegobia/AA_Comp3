<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default_header.jsp"%>

<!-- Lista de Associações -->
<% if (session.getAttribute("nomeUsuario") != null) { %>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Associações</h2>
        <hr class="mb-5">
        <% {%>
        <table class="table">
            <thead>
            <tr>
                <th sc  ope="col">#</th>
                <th scope="col">Matrícula</th>
                <th scope="col">Nome</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${associacoes}" var="associacao">
                <tr>
                    <th scope="row">${associacao.id}</th>
                    <td>${associacao.matricula}</td>
                    <td>${associacao.nome}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <% } %>
    </div>
</section>
<% } %>

</body>

</html>
