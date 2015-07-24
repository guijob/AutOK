<%@include file="../header.jsp"%>
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
<%@include file="../footer.jsp"%>
