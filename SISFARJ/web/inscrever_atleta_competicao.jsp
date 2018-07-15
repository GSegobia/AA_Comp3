<%@ page import="dominio.Atleta" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 15/07/18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int id = (int) request.getAttribute("id");%>
<% int idProva = (int) request.getAttribute("idProva");%>
<% int idCompeticao = (int) request.getAttribute("idCompeticao");%>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Inscrever Atleta na Competição</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="inscreverAtletaCompeticao" method="post">
                <h5>Selecionar Atletas</h5>
                <div class="form-group">
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="id" name="id" placeholder="ID Prova" value="<%= id%>">
                        <input style="display:none;" type="text" class="form-control" id="idProva" name="idProva" placeholder="ID Prova" value="<%= idProva%>">
                        <input style="display:none;" type="text" class="form-control" id="idCompeticao" name="idCompeticao" placeholder="ID Prova" value="<%= idCompeticao%>">
                    </div>
                    <div class="form-group col-md-6">
                        <%
                            for (Atleta a : (List<Atleta>)request.getAttribute("atletas")) {
                        %>
                        <div>
                            <input type="checkbox" class="form-control" id="atleta[]" name="atleta[]" value="<%=a.getId()%>">
                            <input type="text" class="form-control col-md-5" id="matricula" name="matricula" value="<%= a.getMatricula()%>" readonly>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Inscrever</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
