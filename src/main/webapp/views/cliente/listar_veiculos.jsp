<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AutOK</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/starter-template.css" rel="stylesheet">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <div class="container">

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
	            <li class="active"><a href="/">Home</a></li>
        		<li><a href = "${pageContext.request.contextPath}/paginaVeiculos">Veiculos</a></li>
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

        <div class="starter-template">
	<c:if test="${not empty msgSucesso}">
		<span class="label label-success" style="font-size: 14px;">${msgSucesso}</span>
	</c:if>
	
	
	
	<table class="table table-striped table-nonfluid" >  
        <thead>  
          <tr>  
            <th  style="width: 5%;">ID</th>  
            <th  style="width: 60%;">Modelo</th>  
            <th  style="width: 30%;">Ano</th> 
            <th  style="width: 30%;">Quilometragem</th>  
            <th  style="width: 10%;">RENAVAM</th> 
            <th  style="width: 5%;">Ação</th> 
          </tr>  
        </thead>  
        <tbody>  
			<c:forEach items="${veiculos}" var="veiculo">
		          <tr>  
		            <td class="text-left">${veiculo.id}</td>  
		            <td class="text-left">${veiculo.Modelo}</td>
		            <td class="text-left">${veiculo.Ano}</td>
		            <td class="text-left">${veiculo.Quilometragem}</td>
		            <td class="text-left">${veiculo.RENAVAM}</td>  
		            <td class="text-left"><a href="${pageContext.request.contextPath}/detalharVeiculo?id=${veiculo.id}">Editar</a>
		             <td class="text-left"><a href="${pageContext.request.contextPath}/removerVeiculo?id=${veiculo.id}">Remover</a></td>  
		          </tr>				
			</c:forEach>
	
		</tbody>  
	</table>
	
	<a class="btn btn-primary btn-lg pull-right" href="${pageContext.request.contextPath}/novoVeiculo" role="button">Novo Veiculo</a>

        </div>
	
    <footer class="footer">
    	<div class="container">
        	<p>&copy; Grupo 04 - PCS2034 de 2015</p>
    	</div> <!-- /container -->
    </footer>
    
    </div><!-- /.container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>