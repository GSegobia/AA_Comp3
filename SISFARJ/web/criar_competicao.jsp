<%@ page import="dominio.CentroAquatico" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: gsegobia
  Date: 12/07/18
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Criar Competição</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="criarCompeticao" method="post">
                <h4>Dados da Competição</h4>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o Nome do Atleta">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataCompeticao">Data da Competição</label>
                        <input type="date" class="form-control" id="dataCompeticao" name="dataCompeticao">
                    </div>
                </div>
                <div class="form-group">
                    <label for="localProva">Centro Aquático</label>
                    <br>
                    <select class="from-control" id="localProva" >
                        <%
                            for (CentroAquatico local : (ArrayList<CentroAquatico>)request.getAttribute("locaisProva")) {
                        %>
                        <option name="localProva" value="<%=local.getId()%>"><%=local.getNome()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <h5>Cadastrar Provas</h5>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
