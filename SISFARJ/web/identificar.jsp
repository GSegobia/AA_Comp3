<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 14/07/18
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Identificar</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="identificar" method="post">
                <div class="form-group">
                    <label for="matricula">Matrícula</label>
                    <input type="text" class="form-control" id="matricula" name="matricula" placeholder="Digite a sua matrícula">
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite a sua senha">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Identificar</button>
                </div>
                <input id="referencia" name="referencia" value="<%= request.getAttribute("referencia")%>" hidden>
            </form>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>