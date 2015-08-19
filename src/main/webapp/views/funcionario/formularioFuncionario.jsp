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
      </div>
    </nav>

    <div class="container">

	<form:form class="form-horizontal" style="margin: 0 auto; width:80%;" action="/autok/cadastrarFuncionario" method="POST" modelAttribute="funcionarioEntidade">
	  <fieldset>
	    <div id="legend">
	      <legend>Preencha os campos abaixo</legend>
	    </div>
	    <div class="control-group">
	      <!-- Full name -->
	      <label class="control-label"  for="nome">Nome completo</label>
	      <div class="controls">
	        <form:input type="text" path="nome" class="input-xlarge-2"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Telephone -->
	      <label class="control-label"  for="telefone">Telefone</label>
	      <div class="controls">
	        <form:input type="text" path="telefone" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Address -->
	      <label class="control-label"  for="endereco">Endereço</label>
	      <div class="controls">
	        <form:input type="text" path="endereco" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	   	<div class="control-group">
	      <!-- Tipo -->
	      <label class="control-label"  for="tipo">Tipo de funcionario</label>
	      <div class="controls">
	        <form:input type="password" path="tipo" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Email -->
	      <label class="control-label"  for="email">E-mail</label>
	      <div class="controls">
	        <form:input type="text" path="email" class="input-xlarge"></form:input>
	      </div>
	    </div>
	    
	    <div class="control-group">
	      <!-- Senha -->
	      <label class="control-label"  for="senha">Senha</label>
	      <div class="controls">
	        <form:input type="password" path="senha" class="input-xlarge"></form:input>
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
