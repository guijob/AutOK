<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>AutOK - Site</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/starter-template.css" rel="stylesheet">
</head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">AutOK</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" action="/autok/formularioLogin" method="GET">
	          <input type="submit" value="Logar" class="btn btn-success" >
          </form>
          <form class="navbar-form navbar-right" action="/autok/formularioCadastrarCliente" method="POST">
	          <input type="submit" value="Cadastrar" class="btn btn-danger" >
          </form>
          </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <div class="jumbotron">
      <div class="container">
        <h1>AutOK</h1>
        <p>Se você se procupa com o seu carro, agende um serviço conosco.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Saiba mais &raquo;</a></p>
      </div>
    </div>

      <hr>
	<div class="container">
      <footer>
        <p><a href = "${pageContext.request.contextPath}/paginaPecas">Pecas</a></p>
        <p><a href = "${pageContext.request.contextPath}/paginaVeiculos">Pecas</a></p>
      </footer>
    </div> <!-- /container -->
    <div class="container">
      <footer>
        <p>&copy; Grupo 04 - PCS2034 de 2015</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>