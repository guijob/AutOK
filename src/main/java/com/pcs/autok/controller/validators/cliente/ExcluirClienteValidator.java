package com.pcs.autok.controller.validators.cliente;

import com.pcs.autok.dao.ClienteDAO;
import com.pcs.autok.model.Login;
import com.pcs.autok.utils.ResultParameters;

public class ExcluirClienteValidator {

	Login cliente;

	public ExcluirClienteValidator(Login cliente) {
		this.cliente = cliente;
	}

	public int validar(Login cliente) {

		/* validar campo vazio */
		if (cliente.getEmail() == null
				|| cliente.getSenha() == null
				|| cliente.getConfereSenha() == null) {
			System.out.println("validarCliente: Não passou por ter campos vazios...");
			return ResultParameters.CAMPO_VAZIO.getResult();
		}
		
		/* email não formatado */
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(cliente.getEmail());
		if (m.matches() == false) {
			System.out.println("validarCliente: Não passou por ter email mal formatado...");
			return ResultParameters.EMAIL_NAO_FORMATADO.getResult();
		}
		
		ClienteDAO dao = new ClienteDAO();
		boolean result = dao.buscarCliente(cliente);
		System.out.println(": " + result);
		if (!result) {
			System.out.println("Não passou porque não existe usuário no banco de dados");
			return ResultParameters.USUARIO_NAO_ENCONTRADO.getResult();
		}

		/* validacao ok */
		return ResultParameters.OK.getResult();
	}
}
