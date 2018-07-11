<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Filiar Associação</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="associacao" method="post">
                <h4>Dados da Associação</h4>
                <div class="form-row">
                    <div class="form-group col-md-9">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o Nome da Associação">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="sigla">Sigla</label>
                        <input type="text" class="form-control" id="sigla" name="sigla" placeholder="Digite a Sigla da Associação">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="numeroOficio">Número de Ofício</label>
                        <input type="text" class="form-control" id="numeroOficio" name="numeroOficio" placeholder="Digite o Número de Ofício">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="telefone">Telefone</label>
                        <input type="text" class="form-control" id="telefone" name="telefone" placeholder="Digite o Telefone da Associação">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="data">Data</label>
                        <input type="date" class="form-control" id="data" name="data">
                    </div>
                </div>
                <div class="form-group">
                    <label for="numComprovantePgto">Número do Comprovante de Pagamento</label>
                    <input type="text" class="form-control" id="numComprovantePgto" name="numComprovantePgto" placeholder="Digite o Número do Comprovante de Pagamento">
                </div>
                <hr>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Filiar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>