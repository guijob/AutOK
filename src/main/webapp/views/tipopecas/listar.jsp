<%@include file="../header.jsp"%>
<div class="starter-template">
	
	<c:if test="${not empty msgSucesso}">
		<span class="label label-success" style="font-size: 14px;">${msgSucesso}</span>
	</c:if>
	
	
	
	<table class="table table-striped table-nonfluid" >  
        <thead>  
          <tr>  
            <th  style="width: 100%;">descrição</th>  
          </tr>  
        </thead>  
        <tbody>  
			
			<c:forEach items="${listaTipoPecas}" var="tipo_pecas">
		          <tr>  
		            <td class="text-left">${tipo_pecas.descrPeca}</td>
		          </tr>				
			</c:forEach>
	
		</tbody>  
	</table>
</div>	
<%@include file="../footer.jsp"%>
