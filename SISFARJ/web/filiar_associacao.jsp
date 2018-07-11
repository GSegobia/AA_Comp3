<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default_header.jsp"%>

<% if (session.getAttribute("usuario") != null) { %>
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
                <h4>Endereço da Associação</h4>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="cep">CEP</label>
                        <input type="text" class="form-control" id="cep" name="cep" placeholder="Digite o CEP">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="rua">Rua</label>
                        <input type="text" class="form-control" id="rua" name="rua" placeholder="Digite a Rua">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="numero">Número</label>
                        <input type="number" class="form-control" id="numero" name="numero" placeholder="Digite o Número">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="complemento">Complemento</label>
                        <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Digite o Complemento">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="rua">Cidade</label>
                        <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Digite a Cidade">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="estado">Estado</label>
                        <input type="text" readonly class="form-control" id="estado" name="estado" value="Rio de Janeiro" placeholder="Digite o Estado">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Filiar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<% } %>

</body>

</html>
