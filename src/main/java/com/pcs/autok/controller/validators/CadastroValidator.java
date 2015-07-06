package com.pcs.autok.controller.validators;

import com.pcs.autok.model.Cliente;

public class CadastroValidator {
	
	Cliente cliente;
	
	public CadastroValidator(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int validarCliente(Cliente cliente) {
		return 01;
	}
}
