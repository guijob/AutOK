package com.pcs.autok.controller.validators.atendente;

import java.sql.SQLException;

import com.pcs.autok.model.Atendente;
import com.pcs.autok.utils.ResultParameters;

public class CadastrarAtendenteValidator {

	Atendente atendente;

	public CadastrarAtendenteValidator(Atendente atendente) {
		this.atendente = atendente;
	}

	public int validar(Atendente atendente) throws SQLException {
		return ResultParameters.OK.getResult();
	}
}
