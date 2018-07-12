<%@ page import="dominio.Atleta" %>
<%@ page import="dominio.Associacao" %><%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Atleta atleta = (Atleta) request.getAttribute("atleta"); %>
<% Associacao assocAtual = (Associacao) request.getAttribute("associacaoAtual");%>


<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Transferir Atleta</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="transferirAtleta?id=<%=atleta.getId()%>" method="post">
                <h4>Dados do Atleta</h4>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" readonly id="nome" name="nome" value="<%=atleta.getNome()%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="matriculaAtleta">Matrícula Atleta</label>
                        <input type="text" class="form-control" readonly id="matriculaAtleta" name="matriculaAtleta" value="<%=atleta.getMatricula()%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="matriculaAssociacao">Matrícula da Associação Atual</label>
                        <input type="text" class="form-control" readonly id="matriculaAssociacao" name="matriculaAssociacao" value="<%=assocAtual.getMatricula()%>" >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="nomeAssoc">Nome da Associação Atual</label>
                        <input type="text" class="form-control" readonly id="nomeAssoc" name="nomeAssoc" value="<%=assocAtual.getNome()%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="siglaAssoc">Sigla Associação Atual</label>
                        <input type="text" class="form-control" readonly id="siglaAssoc" name="siglaAssoc" value="<%=assocAtual.getSigla()%>">
                    </div>
                </div>
                <hr/>
                <h4>Dados para transferência do Atleta</h4>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="novaMatricula">Matrícula da Nova Associação </label>
                        <input type="text" class="form-control" id="novaMatricula" name="novaMatricula" placeholder="Digite a Matrícula da Nova Associação">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="numeroOficio">Número de Ofício</label>
                        <input type="text" class="form-control" id="numeroOficio" name="numeroOficio" placeholder="Digite o Número de Ofício">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="dataOficio">Data do Ofício</label>
                        <input type="date" class="form-control" id="dataOficio" name="dataOficio">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="dataEntrada">Data de Entrada</label>
                        <input type="date" class="form-control" id="dataEntrada" value="now()" name="dataEntrada">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="numComprovantePgto">Número do Comprovante de Pagamento</label>
                        <input type="text" class="form-control" id="numComprovantePgto" name="numComprovantePgto" placeholder="Digite o Número do Comprovante de Pagamento">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Transferir</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
