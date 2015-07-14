package com.pcs.autok.controller.validators.cliente;

import com.pcs.autok.dao.ClienteDAO;
import com.pcs.autok.model.Cliente;
import com.pcs.autok.utils.ResultParameters;

public class EditarUsuarioValidator {

	Cliente cliente;

	public EditarUsuarioValidator(Cliente cliente) {
		this.cliente = cliente;
	}

	public int validar(Cliente cliente) {

		System.out.println(cliente.toString());
		
		/* validar campo vazio */
		if (cliente.getNomeCliente() == null
				|| cliente.getTelCliente() == null
				|| cliente.getEndCliente() == null
				|| cliente.getEmailCliente() == null
				|| cliente.getSenhaCliente() == null
				|| cliente.getConfereSenhaCliente() == null) {
			System.out.println("validarCliente: Não passou por ter campos vazios...");
			return ResultParameters.CAMPO_VAZIO.getResult();
		}

		/* nome estourando capacidade do banco de dados (45) */
		if (cliente.getNomeCliente().length() > 45) {
			System.out
					.println("validarCliente: Não passou por ter nome muito grande...");
			return ResultParameters.NOME_GRANDE.getResult();
		}

		/* telefone com letras ou telefone estourando banco de dados (11) */
		if (cliente.getTelCliente() == null) {
			System.out.println("Não passou por ter letras no telefone");
			return ResultParameters.TELEFONE_COM_LETRAS.getResult();
		} else if (cliente.getTelCliente() <= 11) {
			System.out
					.println("validarCliente: Não passou por ter telefone muito grande...");
			return ResultParameters.TELEFONE_GRANDE.getResult();
		}

		/* email não formatado */
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(cliente.getEmailCliente());
		if (m.matches() == false) {
			System.out.println("validarCliente: Não passou por ter email mal formatado...");
			return ResultParameters.EMAIL_NAO_FORMATADO.getResult();
		}

		/* senha pequena */
		if (cliente.getSenhaCliente().toString().length() < 4) {
			System.out.println("validarCliente: Não passou por ter senha pequena");
			return ResultParameters.SENHA_PEQUENA.getResult();
		}

		/* senhas nao conferem */
		if (!cliente.getSenhaCliente().equals(cliente.getConfereSenhaCliente().toString())) {
			System.out.println("validarCliente: Não passou porque as senhas nao bateram...");
			return ResultParameters.SENHAS_NAO_BATEM.getResult();
		}

		/* validação OK */
		return ResultParameters.OK.getResult();
	}
}