<%@include file="../header.jsp"%>
<div class="starter-template">

	<c:if test="${not empty msgSucesso}">
		<span class="label label-success" style="font-size: 14px;">${msgSucesso}</span>
	</c:if>

	<c:choose>
		<c:when test="${empty agendamentos}">
        Voc� n�o possui agendamentos!
    </c:when>
		<c:otherwise>
			<table class="table table-striped table-nonfluid">
				<thead>
					<tr>
						<th style="width: 20%;">ID Agendamento</th>
						<th style="width: 20%;">ID Cliente</th>
						<th style="width: 20%;">ID Horario</th>
						<th style="width: 35%;">Descricao</th>
						<th style="width: 5%;"></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${agendamentos}" var="agendamento">
						<tr>
							<td class="text-left">${agendamento.idAgendamento}</td>
							<td class="text-left">${agendamento.idCliente}</td>
							<td class="text-left">${agendamento.idHorario}</td>
							<td class="text-left">${agendamento.descricao}</td>
							<td class="text-left"><a
								href="${pageContext.request.contextPath}
					/excluirAgendamento?idAgendamento=${agendamento.idAgendamento}&idHorario=${agendamento.idHorario}">Cancelar</a></td>
							<%-- <td class="text-left"><a href="${pageContext.request.contextPath}/detalharUsuario?id=${usuario.id}">Editar</a>
		             <td class="text-left"><a href="${pageContext.request.contextPath}/removerUsuario?id=${usuario.id}">Remover</a></td> --%>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:otherwise>
	</c:choose>



	<form class="navbar-form navbar-center"
		action="/autok/agendamentoFormulario" method="get">
		<input type="submit" value="Criar Agendamento" class="btn btn-default">
	</form>


</div>
<%@include file="../footer.jsp"%>
