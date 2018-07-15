<%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 12/07/18
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="dominio.CentroAquatico" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<CentroAquatico> lcompeticao = (ArrayList<CentroAquatico>) request.getAttribute("lcompeticoes"); %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Locais de Competicão</h2>
        <hr class="mb-5">
        <table class="table" style="margin-left: 20%">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>

            </tr>
            </thead>
            <tbody style="margin-left: 8%">
            <% for(CentroAquatico c : lcompeticao) {%>
            <tr>
                <th scope="row"><%=c.getId() %></th>
                <td><%=c.getNome() %></td>
                <td style="border:none;">
                    <div class="btn-group btn-group-sm" role="toolbar">
                        <button type="button" class="btn btn-info btn-sm" onclick="window.location = 'alterarLocaisCompeticao?id=<%=c.getId() %>';"> <i class="fa fa-edit"></i></button>
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
