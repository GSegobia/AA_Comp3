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
<% ArrayList<Atleta> atleta= (ArrayList<Atleta>) request.getAttribute("atletas"); %>

<%@include file="default_header.jsp"%>
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
                <th scope="col">Ações</th>
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
                    <td>
                        <div class="btn-group btn-group-sm" role="toolbar">
                            <a class="btn btn-info btn-sm" href="alterarCadastroAtleta?id=<%=a.getId()%>"> <i class="fa fa-edit"></i></a>
                            <a class="btn btn-success btn-sm" href="transferirAtleta?id=<%=a.getId()%>"> <i class="fa fa-exchange"></i></a>
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