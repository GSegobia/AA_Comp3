<%@ page import="dominio.ResultadoProva" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.Atleta" %>
<%@ page import="dominio.Associacao" %><%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 13/07/18
  Time: 00:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<ResultadoProva> rp = (ArrayList<ResultadoProva>) request.getAttribute("resultados"); %>
<% ArrayList<Atleta> at = (ArrayList<Atleta>) request.getAttribute("atletas"); %>
<% ArrayList<Associacao> aas = (ArrayList<Associacao>) request.getAttribute("associacao"); %>


<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Lista de Pontos por Provas</h2>
        <hr class="mb-5">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome do Atleta</th>
                <th scope="col">Sigla Associação</th>
                <th scope="col">Tempo</th>
                <th scope="col">Pontos</th>
            </tr>

            <% for(int i = 0; i < rp.size(); i++) {%>
            <tr>
                <th scope="col"><%=i+1%></th>
                <th scope="col"><%=at.get(i).getNome()%></th>
                <th scope="col"><%=aas.get(i).getSigla()%></th>
                <th scope="col"><%=rp.get(i).getTempo()%></th>
                <th scope="col"><%=rp.get(i).getPontuacao()%></th>
            </tr>
            <% }%>
            </thead>
        </table>
    </div>
</section>
<%@include file="default_footer.jsp"%>