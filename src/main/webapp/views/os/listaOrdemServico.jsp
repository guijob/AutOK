<%@include file="../header.jsp"%>
<div class="starter-template">

	<%@include file="../headers/agendamento-header.jsp"%>

	<c:if test="${not empty msgSucesso}">
		<span class="label label-success" style="font-size: 14px;">${msgSucesso}</span>
	</c:if>

	<c:choose>
		<c:when test="${empty ordensDeServico}">
        Você não possui Ordens de Serviço abertas.
    </c:when>
		<c:otherwise>
			<table class="table table-striped table-nonfluid">
				<thead>
					<tr>
						<th style="width: 14.28%;">ID OS</th>
						<th style="width: 14.28%;">Status</th>
						<th style="width: 14.28%;">Justificativa</th>
						<th style="width: 14.28%;">ID Agendamento</th>
						<th style="width: 14.28%;">ID Responsável 1</th>
						<th style="width: 14.28%;">ID Responsável 2</th>
						<th style="width: 14.28%;">Preço Total</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ordensDeServico}" var="os">
						<tr>
							<td class="text-left">${os.id}</td>
							<td class="text-left">${os.status}</td>
							<td class="text-left">${os.justificativa}</td>
							<td class="text-left">${os.idAgendamento}</td>
							<td class="text-left">${os.idResponsavelUm}</td>
							<td class="text-left">${os.idResponsavelDois}</td>
							<td class="text-left">${os.precoTotal}</td>
							<%-- <td class="text-left"><a
								href="${pageContext.request.contextPath}
					/excluirAgendamento?idAgendamento=${agendamento.idAgendamento}&idHorario=${agendamento.idHorario}">Cancelar</a></td> --%>

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:otherwise>
	</c:choose>


 	<c:choose>
		<c:when test="${tipoUsuario == 'cliente'}"></c:when>
		<c:when test="${tipoUsuario == 'tec_analista' }"></c:when>
		<c:otherwise>
			<form class="navbar-form navbar-center"
				action="/autok/agendamentoFormulario" method="get">
				<input type="submit" value="Criar OS" class="btn btn-default">
			</form>
		</c:otherwise>
	</c:choose>


</div>
<%@include file="../footer.jsp"%>
