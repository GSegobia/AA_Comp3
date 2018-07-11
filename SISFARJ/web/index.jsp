<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default_header.jsp"%>

    <!-- Header -->
    <% if (session.getAttribute("usuario") == null) { %>
    <header class="masthead bg-primary text-white text-center">
      <div class="container">
        <img class="img-fluid mb-5 d-block mx-auto" src="img/swimming-silhouette.svg" width="250px" height="250px" alt="">
        <h1 class="text-uppercase mb-0">SISFARJ</h1>
        <hr class="star-light">
        <h2 class="font-weight-light mb-0">
          O Sistema SISFARJ tem a finalidade gerenciar competições de natação no território do Rio de Janeiro entre
          Associações Filiadas, controlando as participações dos atletas nas competições, gerando relatórios das competições
          e dos resultados com os tempos dos atletas e a pontuação final das Associações.</h2>
      </div>
    </header>
    <% } %>

    <% if (session.getAttribute("usuario") == null) { %>
    <div class="copyright py-4 text-center text-white">
      <div class="container">
        <small>Trabalho realizado na disciplina de Computação III</small></br>
        <small>Fellipe Bravo, Gabriel Segobia, João Victor Araújo, Paulo Xavier e Vinícius Rigoni</small></br>
        <small>UFRRJ 2018.1</small>
      </div>
    </div>
    <% } %>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <!-- Sucesso: Identificação de Usuário -->
    <%@include file="sucesso_identificacao.jsp"%>

    <!-- Erro: Identificação de Usuário -->
    <%@include file="erro_identificacao.jsp"%>

    <!-- Erro: Sessão Expirada -->
    <%@include file="erro_sessao_expirada.jsp"%>

  </body>

</html>
