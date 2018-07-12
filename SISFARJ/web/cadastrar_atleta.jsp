<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Cadastrar Atleta</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="cadastrarAtleta" method="post">
                <h4>Dados do Atleta</h4>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o Nome do Atleta">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataNascimento">Data de Nascimento</label>
                        <input type="date" class="form-control" id="dataNascimento" name="dataNascimento">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="numeroOficio">Número de Ofício</label>
                        <input type="text" class="form-control" id="numeroOficio" name="numeroOficio" placeholder="Digite o Número de Ofício">
                    </div>
                    <div class="form-group col-md-6">
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
                        <label for="matriculaAssociacao">Matrícula da Associação</label>
                        <input type="text" class="form-control" id="matriculaAssociacao" name="matriculaAssociacao" placeholder="Digite a Matrícula da Associação">
                    </div>
                </div>
                <div class="form-group">
                    <label for="numComprovantePgto">Número do Comprovante de Pagamento</label>
                    <input type="text" class="form-control" id="numComprovantePgto" name="numComprovantePgto" placeholder="Digite o Número do Comprovante de Pagamento">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
