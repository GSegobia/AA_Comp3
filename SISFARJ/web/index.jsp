<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<header class="masthead bg-primary text-white text-center">
    <div class="container">
        <img class="img-fluid mb-3 d-block mx-auto" src="img/swimming-silhouette.svg" width="150px" height="150px" alt="">
        <h4 class="text-uppercase mb-0">SISFARJ</h4>
    </div>
</header>
<div class="container">
    <div class="card-group mb-3">
        <!-- ECUs Abertos -->
        <div class="card p-3 col-md-4 text-center">
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="listarBalizamentoCompeticao">Listar balizamento competição</a></li>
            </ul>
        </div>
        <div class="card p-3 col-md-4 text-center">
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="listarPontuacaoCompeticao?id=0">Listar pontuação competição</a></li>
            </ul>
        </div>
        <div class="card p-3 col-md-4 text-center">
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="listarPontuacaoFinal">Listar pontuação final</a></li>
            </ul>
        </div>
    </div>
    <div class="card-group">
        <!-- Associações -->
        <div class="card p-3 col-md-4">
            <img class="card-img-top p-3" src="img/swimming-pool.svg" width="150px" height="150px" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title" style="text-align: center">Associações</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="filiarAssociacao">Filiar Associação</a></li>
                <li class="list-group-item"><a href="listarAssociacoes">Listar Associações (Transferir e Editar)</a></li>
            </ul>
        </div>
        <!-- Atletas -->
        <div class="card p-3 col-md-4">
            <img class="card-img-top p-3" src="img/swimmer.svg" width="150px" height="150px" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title" style="text-align: center">Atletas</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="cadastrarAtleta">Cadastrar Atleta</a></li>
                <li class="list-group-item"><a href="listarAtletas">Listar Atletas (Transferir e Editar)</a></li>
                <li class="list-group-item"><a href="inscreverAtletaCompeticao">Inscrever Atleta em Competição</a></li>
            </ul>
        </div>
        <!-- Competições -->
        <div class="card p-3 col-md-4">
            <img class="card-img-top p-3" src="img/ranking.svg" width="150px" height="150px" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title" style="text-align: center">Competições</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="criarCompeticao">Criar Competição</a></li>
                <li class="list-group-item"><a href="incluirLocaisCompeticao">Incluir Locais de Competições</a></li>
                <li class="list-group-item"><a href="listarLocaisCompeticao">Listar Locais de Competição</a></li>
                <li class="list-group-item"><a href="listarCompeticoes">Inserir Resultado do Atleta</a></li>
                <li class="list-group-item"><a href="listarCompeticoes">Listar Competições</a></li>
                <li class="list-group-item"><a href="incluirLocaisCompeticao">Incluir Locais de Competições</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container text-left text-white-50 p-5">
    <small>Trabalho realizado na disciplina de Computação III</small></br>
    <small>Fellipe Bravo, Gabriel Segobia, João Victor Araújo, Paulo Xavier e Vinícius Rigoni</small></br>
    <small>UFRRJ 2018.1</small>
</div>
<%@include file="default_footer.jsp"%>
