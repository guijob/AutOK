package com.pcs.autok.controller.validators.funcionario;

import java.sql.SQLException;

import com.pcs.autok.model.Funcionario;
import com.pcs.autok.utils.ResultParameters;

public class ExcluirFuncionarioValidator {

	Funcionario atendente;

	public ExcluirFuncionarioValidator(Funcionario atendente) {
		this.atendente = atendente;
	}

	public int validar(Funcionario atendente) throws SQLException {
		return ResultParameters.OK.getResult();
	}
}
