<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default_header.jsp"%>

<% if (session.getAttribute("nomeUsuario") != null) { %>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container">
        <div class="row align-content-center">
            <div class="card-group">
                <!-- Associações -->
                <div class="card p-3">
                    <img class="card-img-top p-3" src="img/swimming-pool.svg" width="150px" height="150px" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">Associações</h5>
                        <p class="card-text" style="text-align: justify">{TODO: Escrever observação das associações}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><a href="associacoes">Listar Associações</a></li>
                    </ul>
                </div>
                <!-- Atletas -->
                <div class="card p-3">
                    <img class="card-img-top p-3" src="img/swimmer.svg" width="150px" height="150px" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">Atletas</h5>
                        <p class="card-text" style="text-align: justify">{TODO: Escrever observação das atletas}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><a href="atletas">Listar Atletas</a></li>
                    </ul>
                </div>
                <!-- Competições -->
                <div class="card p-3">
                    <img class="card-img-top p-3" src="img/ranking.svg" width="150px" height="150px" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">Competições</h5>
                        <p class="card-text" style="text-align: justify">{TODO: Escrever observação das competições}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><a href="competicoes">Listar Competições</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<% } %>

</body>

</html>
