<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="header.jsp"%>
        <div class="starter-template">
        	<h1>Que pena!<br>Gostariamos que você ficasse...</h1>
        	<p class="lead">Se ainda quiser excluir seus cadastro preencha os campos abaixo:</p>
        	<p class="">
        	
        	<form:form class="form-horizontal" style="margin: 0 auto; width:80%;" action="/autok/excluirCliente" method="POST" modelAttribute="clienteEntidade">
			  <fieldset>
			    <div class="control-group">
			      <!-- Email -->
			      <label class="control-label"  for="emailCliente">E-mail</label>
			      <div class="controls">
			        <form:input type="text" path="emailCliente" class="input-xlarge"></form:input>
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- Senha -->
			      <label class="control-label"  for="senhaCliente">Senha</label>
			      <div class="controls">
			        <form:input type="password" path="senhaCliente" class="input-xlarge"></form:input>
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- Confere Senha -->
			      <label class="control-label"  for="confereSenhaCliente">Senha novamente</label>
			      <div class="controls">
			        <form:input type="password" path="confereSenhaCliente" class="input-xlarge"></form:input>
			      </div>
			    </div>
			    	 
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success">Excluir minha conta</button>
			      </div>
			    </div>
			  </fieldset>
			</form:form>
        	
        	</p>
        </div>
<%@include file="footer.jsp"%>