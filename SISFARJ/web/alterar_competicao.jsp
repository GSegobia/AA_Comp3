<%@ page import="dominio.Competicao" %><%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 15/07/18
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%int id = (Integer) request.getAttribute("id");%>
<%Competicao c = (Competicao) request.getAttribute("competicao");%>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Alterar Competição</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="alterarCompeticao" method="post">
                <div class="form-row">
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="id" name="id" placeholder="Digite o Nome do Atleta" value="<%= id%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nomeCompeticao">Nome</label>
                        <input type="text" class="form-control" id="nomeCompeticao" name="nomeCompeticao" placeholder="Digite o Nome da Competição" value="<%=c.getNome()%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataCompeticao">Data da Competição</label>
                        <input type="date" class="form-control" id="dataCompeticao" name="dataCompeticao" value="<%=c.getDataCompeticao()%>">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Alterar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
