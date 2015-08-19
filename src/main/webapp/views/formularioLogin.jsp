<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="header.jsp"%>
<div class="container">

		<style type="text/css">
			/* Adjust feedback icon position */
			#productForm .selectContainer .form-control-feedback, #productForm .inputGroupContainer .form-control-feedback
				{
				right: -15px;
			}
		</style>


		<form:form action="/autok/logarUsuario" method="post" class="form-horizontal" modelAttribute="loginEntidade">

			<div class="form-group">
				<label class="col-xs-3 control-label"></label>
				<div class="col-xs-5">
					<label><h3>Formulário de Autenticação</h3></label>
			        
			        </div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">E-mail</label>
				<div class="col-xs-5">
					<form:input type="text" class="form-control" name="email" path="email" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Senha</label>
				<div class="col-xs-5">
					<form:input type="password" class="form-control" name="email" path="senha" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Entrar como</label>
				<div class="col-xs-5 selectContainer">
					<form:select class="form-control" path="tipoUsuario" items="${hashTipoUsuario}" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-5 col-xs-offset-3">
					<button type="submit" class="btn btn-default">Autenticar</button>
				</div>
			</div>
		</form:form>
</div>
<!-- /container -->
<%@include file="footer.jsp"%>