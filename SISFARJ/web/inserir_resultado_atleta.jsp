<%@ page import="dominio.Atleta" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 12/07/18
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Atleta> atletas = (ArrayList<Atleta>) request.getAttribute("atletas"); %>
<% int id_prova = (int) request.getAttribute("id_prova");%>
<% int idProva = (int) request.getAttribute("idProva");%>
<% int idCompeticao = (int) request.getAttribute("idCompeticao");%>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Inserir Tempo dos Atletas</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="inserirResultadoAtleta" method="post">
                <h4>Forneça os Tempos por Atleta</h4>
                <% for(Atleta a : atletas) {%>
                <div class="form-row">
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="id" name="prova_id" placeholder="ID Prova" value="<%= id_prova%>">
                        <input style="display:none;" type="text" class="form-control" id="idProva" name="idProva" placeholder="ID Prova" value="<%= idProva%>">
                        <input style="display:none;" type="text" class="form-control" id="idCompeticao" name="idCompeticao" placeholder="ID Prova" value="<%= idCompeticao%>">
                    </div>
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="id" name="id[]" placeholder="ID Atleta" value="<%= a.getId()%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o Nome do Atleta" value="<%= a.getNome()%>" readonly>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="tempo">Tempo</label>
                        <input type="text" class="form-control" id="tempo" name="tempo[]" placeholder="Informe o tempo aqui">
                    </div>
                </div>
                <% } %>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
