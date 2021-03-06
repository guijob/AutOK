	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 
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
	            <li><a href="${pageContext.request.contextPath}/homeLogged">Home</a></li>
        		<c:choose>
					<c:when test="${usuarioLogado.tipo == 'cliente'}">
						<li><a
							href="${pageContext.request.contextPath}/listarVeiculos">Ve�culos</a></li>
					</c:when>
				</c:choose>
	            <li class="active"><a href="${pageContext.request.contextPath}/listarAgendamentos">Agendamentos</a></li>
	            <li><a href="${pageContext.request.contextPath}/mostrarOrdensDeServico">Ordens de Servi�o</a></li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	          	<p class="navbar-text">${usuarioLogado.nome}</p> 
	            <li class="dropdown">
	              <a href="${pageContext.request.contextPath}/acessarConta" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/configuracoesConta">Configura��es da conta </a></li>
	                <li><a href="#"></a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="logout">Sair do sistema</a></li>
	              </ul>
	            </li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </div>