package com.pcs.autok.controller.validators;

import com.pcs.autok.dao.LoginDAO;
import com.pcs.autok.model.Login;
import com.pcs.autok.model.base.abstracts.Usuario;
import com.pcs.autok.utils.ResultParameters;

public class LogarUsuarioValidator {

	Login login;

	public LogarUsuarioValidator(Login cliente) {
		this.login = cliente;
	}

	public int validar(Login cliente) {

		System.out.println(cliente.toString());
		
		/* validar campo vazio */
		if (cliente.getEmail() == null ||
			cliente.getSenha() == null) {
			System.out.println("validarLoginCliente: Não passou por ter campos vazios...");
			return ResultParameters.CAMPO_VAZIO.getResult();
		}

		/* email não formatado */
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(cliente.getEmail());
		if (m.matches() == false) {
			System.out.println("validarLoginCliente: Não passou por ter email mal formatado...");
			return ResultParameters.EMAIL_NAO_FORMATADO.getResult();
		}

		/* senha pequena */
		if (cliente.getSenha().toString().length() < 4) {
			System.out.println("validarLoginCliente: Não passou por ter senha pequena");
			return ResultParameters.SENHA_PEQUENA.getResult();
		}

		/* usuario nao encontrado */
		LoginDAO dao = new LoginDAO();
		Usuario result = dao.buscarRegistro(login);
		if (result == null) {
			System.out.println("validarLoginCliente: Não passou porque não existe usuário no banco de dados");
			return ResultParameters.USUARIO_NAO_ENCONTRADO.getResult();
		}
		
		/* validação OK */
		return ResultParameters.OK.getResult();
	}
}
