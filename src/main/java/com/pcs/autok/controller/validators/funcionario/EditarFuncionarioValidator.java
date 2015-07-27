package com.pcs.autok.controller.validators.funcionario;

import java.sql.SQLException;

import com.pcs.autok.model.base.abstracts.Funcionario;
import com.pcs.autok.utils.ResultParameters;

public class EditarFuncionarioValidator {

	Funcionario funcionario;

	public EditarFuncionarioValidator(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int validar(Funcionario funcionario) throws SQLException {
		return ResultParameters.OK.getResult();
	}
}
