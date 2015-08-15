<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>AutOK - Formulário</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/starter-template.css" rel="stylesheet">
</head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">AutOK</a>
	        </div>
	        <div class="collapse navbar-collapse">
		   		<ul class="nav navbar-nav">
	            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
        		<li class="active"><a href = "${pageContext.request.contextPath}/paginaVeiculos">Veiculos</a></li>
	            <li><a href="${pageContext.request.contextPath}/mostrarAgendamentos">Agendamentos</a></li>
	            <li><a href="${pageContext.request.contextPath}/mostrarOrdensDeServico">Ordens de Serviço</a></li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	          	<p class="navbar-text">${usuarioLogado.nome}</p> 
	          	<li><a href="./"><span class="glyphicon glyphicon-user"></span><span class="sr-only">(current)</span></a></li>
	            <li class="dropdown">
	              <a href="${pageContext.request.contextPath}/acessarConta" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/configuracoesConta">Configurações da conta </a></li>
	                <li><a href="#"></a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="logout">Sair do sistema</a></li>
	              </ul>
	            </li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </div>

    <div class="container">

	<form:form class="form-horizontal" style="margin: 10 auto;" action="/autok/cadastrarVeiculo" method="POST" modelAttribute="veiculoEntidade">
	  <fieldset>
	    <div id="legend">
	      <legend>Preencha os campos abaixo</legend>
	    </div>
	    <div class="control-group">
	      <!-- Model name -->
	      <label class="control-label"  for="modeloVeiculo">Modelo Veiculo</label>
	      <div class="controls">
	        <form:input type="text" path="modeloVeiculo" class="input-xlarge-2"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Renvam -->
	      <label class="control-label"  for="RENAVAM">RENAVAM</label>
	      <div class="controls">
	        <form:input type="text" path="RENAVAM" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Mark name -->
	      <label class="control-label"  for="fabVeiculo">Fabricante Veiculo</label>
	      <div class="controls">
	        <form:input type="text" path="fabVeiculo" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Model year -->
	      <label class="control-label"  for="fabAno">Ano</label>
	      <div class="controls">
	        <form:input type="text" path="fabAno" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Quilometragem -->
	      <label class="control-label"  for="quilometragem">Quilometragem</label>
	      <div class="controls">
	        <form:input type="text" path="quilometragem" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    	 
	    <div class="control-group">
	      <!-- Button -->
	      <div class="controls">
	        <button class="btn btn-success">Cadastrar</button>
	      </div>
	    </div>
	  </fieldset>
	</form:form>

    </div> <!-- /container -->

      <hr>
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
