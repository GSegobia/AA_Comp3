<%@ page import="dominio.CentroAquatico" %><%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 12/07/18
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int lc_id = (int) request.getAttribute("lc_id");%>
<% CentroAquatico lc = (CentroAquatico) request.getAttribute("lc");%>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Editar Local de Competição</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="alterarLocaisCompeticao" method="post">
                <h4>Editar: <%= lc.getNome() %></h4>
                <div class="form-row">
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="id" name="id" placeholder="Id" value="<%= lc.getId()%>">
                    </div>
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="nome" name="nome" placeholder="Nome" value="<%= lc.getNome()%>">
                    </div>
                    <div class="form-group col-md-10">
                        <label for="endereco">Endereço</label>
                        <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Altere aqui o endereço" value="<%= lc.getEndereco()%>">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="piscina">Tamanho da Piscina</label>
                        <input type="text" class="form-control" id="piscina" name="piscina" placeholder="Altere aqui a piscina" value="<%= lc.getTamanho_piscina()%>">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
