<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="dominio.Atleta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default_header.jsp"%>
<% ArrayList<Atleta> atleta= (ArrayList<Atleta>) request.getAttribute("atletas"); %>

<!-- Lista de Associações -->
<% if (session.getAttribute("usuario") != null) { %>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Atletas</h2>
        <hr class="mb-5">
        <% { // TODO: Adicionar mensagem de "Não foram encontrados atletas"%>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Matrícula</th>
                <th scope="col">Nome</th>
                <% // TODO: Fazer Join e exibir?"%>
                <th scope="col"># Associacao</th>
                <th scope="col">Data Nascimento</th>
                <th scope="col">Data Entrada Associacao</th>
                <th scope="col">Data Ofício</th>
                <th scope="col">Categoria</th>
            </tr>
            </thead>
            <tbody>
            <% for(Atleta a : atleta) {%>
                <tr>
                    <th scope="row"><%=a.getId() %></th>
                    <td><%=a.getMatricula() %></td>
                    <td><%=a.getNome() %></td>
                    <td><%=a.getAssociacao_id() %></td>
                    <td><%=a.getData_nascimento() %></td>
                    <td><%=a.getData_entrada_associacao() %></td>
                    <td><%=a.getData_oficio() %></td>
                    <td><%=a.getNumero_oficio() %></td>
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
