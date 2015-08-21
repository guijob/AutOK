<%@include file="../header.jsp"%>
<div class="starter-template">

	<%@include file="../headers/os-header.jsp"%>

	<c:if test="${not empty msgSucesso}">
		<span class="label label-success" style="font-size: 14px;">${msgSucesso}</span>
	</c:if>

	<c:choose>
		<c:when test="${empty ordensDeServico}">
        Voc� n�o possui Ordens de Servi�o abertas.
    </c:when>
		<c:otherwise>
			<table class="table table-striped table-nonfluid">
				<thead>
					<tr>
						<th style="width: 14.28%;">ID OS</th>
						<th style="width: 14.28%;">Status</th>
						<th style="width: 14.28%;">Justificativa</th>
						<th style="width: 14.28%;">ID Agendamento</th>
						<th style="width: 14.28%;">ID Respons�vel 1</th>
						<th style="width: 14.28%;">ID Respons�vel 2</th>
						<th style="width: 14.28%;">Pre�o Total</th>

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


							<c:if
								test="${tipoUsuario == 'tec_analista' && os.status == 'Aguardando aprovacao'}">
								<td class="text-left"><a
									href="${pageContext.request.contextPath}
					/AprovarOS?id=${os.id}">Aprovar</a></td>
								<td class="text-left"><a
									href="${pageContext.request.contextPath}
					/SuspenderOS?id=${os.id}">Suspender</a></td>
							</c:if>
							
							<c:if
								test="${tipoUsuario == 'tec_responsavel' && os.status == 'Em execucao'}">
								<td class="text-left"><a
									href="${pageContext.request.contextPath}
					/FinalizarOS?id=${os.id}">Finalizar</a></td>
							</c:if>
							
							<c:if
								test="${tipoUsuario == 'caixa' && os.status == 'Aguardando pagamento'}">
								<td class="text-left"><a
									href="${pageContext.request.contextPath}
					/PagarOS?id=${os.id}">Confirmar pagamento</a></td>
							</c:if>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

</div>
<%@include file="../footer.jsp"%>
