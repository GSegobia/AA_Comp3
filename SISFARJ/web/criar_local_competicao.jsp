<%--
  Created by IntelliJ IDEA.
  User: gsegobia
  Date: 12/07/18
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Criar Local de Competição</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="criarCompeticao" method="post">
                <h4>Dados Local de Competição</h4>
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o Nome do Local de Competição">
                </div>
                <div class="form-group">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Digite o Endereço">
                </div>
                <div class="form-group">
                    <label for="tamanho">Tamanho Piscina</label>
                    <br>
                    <select class="from-control" id="tamanho" >
                        <option name="tamanhoPisicna" value="25">25 metros</option>
                        <option name="tamanhoPisicna" value="50">50 metros</option>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>

