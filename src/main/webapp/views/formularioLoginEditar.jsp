<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="header.jsp"%>
    <div class="container">

      <form:form style="width: 450px" action="/autok/formularioEditar" method="POST" modelAttribute="loginEntidade">
        <h2 >Please sign in</h2>
        <label for="inputEmail" class="sr-only">Endereço de email</label>
        <form:input id="inputEmail" class="form-control" path="emailCliente" placeholder="Endereço de e-mail"></form:input>
        <label for="inputPassword" class="sr-only">Senha</label>
        <form:input type="password" id="inputEmail" class="form-control" path="senhaCliente" placeholder="Senha"></form:input>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Guardar senha
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Logar</button>
      </form:form>

    </div> <!-- /container -->
    <%@include file="footer.jsp"%>