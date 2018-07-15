<%@ page import="dominio.Associacao" %>
<%@ page import="dominio.Atleta" %>
<%--
  Created by IntelliJ IDEA.
  User: joaovaraujo
  Date: 12/07/18
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Atleta atleta = (Atleta) request.getAttribute("atleta"); %>
<% Associacao associacao = (Associacao) request.getAttribute("associacao"); %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Alterar Cadastro do Atleta</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="alterarCadastroAtleta" method="post">
                <h4>Dados do Atleta</h4>
                <div class="form-row">
                    <div style="display:none;" class="form-group col-md-6">
                        <input style="display:none;" type="text" class="form-control" id="id" name="id" placeholder="Digite o Nome do Atleta" value="<%= atleta.getId()%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o Nome do Atleta" value="<%= atleta.getNome()%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataNascimento">Data de Nascimento</label>
                        <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" value="<%= atleta.getData_nascimento()%>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="numeroOficio">Número de Ofício</label>
                        <input type="text" class="form-control" id="numeroOficio" name="numeroOficio" placeholder="Digite o Número de Ofício" value="<%= atleta.getNumero_oficio()%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataOficio">Data do Ofício</label>
                        <input type="date" class="form-control" id="dataOficio" name="dataOficio" value="<%= atleta.getData_oficio()%>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="dataEntrada">Data de Entrada</label>
                        <input type="date" class="form-control" id="dataEntrada" name="dataEntrada" value="<%= atleta.getData_entrada_associacao()%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="numComprovantePgto">Número do Comprovante de Pagamento</label>
                        <input type="text" class="form-control" id="numComprovantePgto" name="numComprovantePgto" placeholder="Digite o Número do Comprovante de Pagamento" value="<%= atleta.getNum_comprovante_pgto()%>">
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
