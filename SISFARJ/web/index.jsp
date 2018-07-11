<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<header class="masthead bg-primary text-white text-center">
    <div class="container">
        <img class="img-fluid mb-3 d-block mx-auto" src="img/swimming-silhouette.svg" width="150px" height="150px" alt="">
        <h4 class="text-uppercase mb-0">SISFARJ</h4>
    </div>
</header>
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
                    <li class="list-group-item"><a href="associacao">Filiar Associação</a></li>
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
                    <li class="list-group-item"><a href="atleta">Cadastrar Atleta</a></li>
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

<div class="container text-left text-white-50 p-5">
    <small>Trabalho realizado na disciplina de Computação III</small></br>
    <small>Fellipe Bravo, Gabriel Segobia, João Victor Araújo, Paulo Xavier e Vinícius Rigoni</small></br>
    <small>UFRRJ 2018.1</small>
</div>
<%@include file="default_footer.jsp"%>
