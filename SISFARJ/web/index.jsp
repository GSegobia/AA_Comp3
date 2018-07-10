<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SISFARJ</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/freelancer.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">
          <% if (session.getAttribute("nomeUsuario") != null) { %>
          Olá, ${sessionScope.nomeUsuario}!
          <% } else { %>
          SISFARJ
          <% } %>
        </a>
        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <% if (session.getAttribute("nomeUsuario") == null) { %>
            <li class="nav-item mx-0 mx-lg-1" >
              <a class="nav-link py-3 px-0 px-lg-3 rounded" data-toggle="modal" href="#" data-target="#login-modal">Acessar</a >
            </li >
            <% } else { %>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Menu</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <form name="submitForm" method="post" action="invalidarsessao">
                <button class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" type="submit" href="#">Sair</button>
              </form>
            </li>
            <% } %>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Login Modal -->
    <div class="modal fade" tabindex="-1" role="dialog" id="login-modal">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Acessar</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form" action="identificar" method="post">
              <div class="form-group mx-sm-3 mb-2">
                <label for="matricula" class="sr-only">Email</label>
                <input type="text" class="form-control" id="matricula" name="matricula" placeholder="Digite a sua matrícula">
              </div>
              <div class="form-group mx-sm-3 mb-2">
                <label for="senha" class="sr-only">Password</label>
                <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite a sua senha">
              </div>
              <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Header -->
    <header class="masthead bg-primary text-white text-center">
      <div class="container">
        <img class="img-fluid mb-5 d-block mx-auto" src="img/swimming.svg" width="250px" height="250px" alt="">
        <h1 class="text-uppercase mb-0">SISFARJ</h1>
        <hr class="star-light">
        <h2 class="font-weight-light mb-0">
          O Sistema SISFARJ tem a finalidade gerenciar competições de natação no território do Rio de Janeiro entre
          Associações Filiadas, controlando as participações dos atletas nas competições, gerando relatórios das competições
          e dos resultados com os tempos dos atletas e a pontuação final das Associações.</h2>
      </div>
    </header>

    <!-- Menu Section -->
    <% if (session.getAttribute("nomeUsuario") != null) { %>
    <section class="portfolio" id="portfolio">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">Menu</h2>
        <hr class="mb-5">
        <div class="row">
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/cabin.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-2">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/cake.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-3">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/circus.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-4">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/game.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-5">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/safe.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-6">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/submarine.png" alt="">
            </a>
          </div>
        </div>
      </div>
    </section>
    <% } %>

    <div class="copyright py-4 text-center text-white">
      <div class="container">
        <small>Trabalho realizado na disciplina de Computação III</small></br>
        <small>Fellipe Bravo, Gabriel Segobia, João Victor Araújo, Paulo Xavier e Vinícius Rigoni</small></br>
        <small>UFRRJ 2018.1</small>
      </div>
    </div>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <!-- Menu Modals -->

    <!-- Menu Modal 1 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/cabin.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Menu Modal 2 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/cake.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Menu Modal 3 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/circus.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Menu Modal 4 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-4">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/game.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Menu Modal 5 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-5">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/safe.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Menu Modal 6 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-6">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/submarine.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/freelancer.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="src/js/sweetalert.min.js"></script>

    <!-- Sucesso: Identificação de Usuário -->
    <%
      Boolean sucesso = (Boolean) session.getAttribute("sucessoIdentificacao");
      if(sucesso != null && sucesso) {
        session.setAttribute("sucessoIdentificacao", false);
    %>
    <script>
        swal({
            title: "Sucesso",
            text: "Você agora está logado no sistema!",
            icon: "success"
        }).show()
    </script>
    <% } %>

    <!-- Erro: Identificação de Usuário -->
    <%
      Boolean erroIdentificacao = (Boolean) session.getAttribute("erroIdentificacao");
      if(erroIdentificacao != null && erroIdentificacao) {
          session.setAttribute("erroIdentificacao", true);
    %>
    <script>
        swal({
            title: "Erro",
            text: "Não foi possível identificar o usuário.",
            icon: "error"
        }).show()
    </script>
    <% } %>
  </body>

</html>
