<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--  TODO - UPDATE THIS FILE TO MATCH THE AGENDAMENTO FORM -->

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

    <%@include file="../headers/os-header.jsp"%>

    <div class="container">

	<form:form action="/autok/criarOrdemServico" method="post" class="form-horizontal" modelAttribute="formulario">

			<div class="form-group">
				<label class="col-xs-3 control-label"></label>
				<div class="col-xs-5">
					<label><h3>Formulário para Criar OS</h3></label>
			        
			        </div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Escolha um serviço</label>
				<div class="col-xs-5 selectContainer">
					<form:select class="form-control" path="um" items="${servicos}" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 control-label">Escolha um serviço</label>
				<div class="col-xs-5 selectContainer">
					<form:select class="form-control" path="dois" items="${servicos}" />
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="col-xs-3 control-label">Escolha um serviço</label>
				<div class="col-xs-5 selectContainer">
					<form:select class="form-control" path="tres" items="${servicos}" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 control-label">Escolha um serviço</label>
				<div class="col-xs-5 selectContainer">
					<form:select class="form-control" path="quatro" items="${servicos}" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 control-label">Escolha um serviço</label>
				<div class="col-xs-5 selectContainer">
					<form:select class="form-control" path="cinco" items="${servicos}" />
				</div>
			</div>


			<div class="form-group">
				<div class="col-xs-5 col-xs-offset-3">
					<button type="submit" class="btn btn-default">Criar</button>
				</div>
			</div>
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
