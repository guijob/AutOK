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

	    <%@include file="../headers/veiculo-header.jsp"%>

        <div class="starter-template">
	<c:if test="${not empty msgSucesso}">
		<span class="label label-success" style="font-size: 14px;">${msgSucesso}</span>
	</c:if>
	
	
	
	<table class="table table-striped table-nonfluid" >  
        <thead>  
          <tr>  
            <th  style="width: 40%;">Modelo</th>  
            <th  style="width: 20%;">Fabricante</th>  
            <th  style="width: 40%;">PlacaVeiculo</th>  
            <th  style="width: 30%;">Ano</th> 
            <th  style="width: 30%;">Quilometragem</th>  
            <th  style="width: 10%;">RENAVAM</th> 
            <th  style="width: 5%;">Ação</th> 
          </tr>  
        </thead>  
        <tbody>  
			<c:forEach items="${veiculos}" var="veiculo">
		          <tr>  
   		            <td class="text-left">${veiculo.modeloVeiculo}</td>
		            <td class="text-left">${veiculo.fabVeiculo}</td>  
		            <td class="text-left">${veiculo.placaVeiculo}</td>
		            <td class="text-left">${veiculo.fabAno}</td>
		            <td class="text-left">${veiculo.quilometragem}</td>
		            <td class="text-left">${veiculo.renavam}</td>  
		            <td class="text-left"><a href="${pageContext.request.contextPath}/excluirVeiculo?id=${veiculo.idVeiculo}">Remover</a></td>  
		          </tr>				
			</c:forEach>
	
		</tbody>  
	</table>
	
	<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/formularioCadastrarVeiculo" role="button">Novo Veículo</a>

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