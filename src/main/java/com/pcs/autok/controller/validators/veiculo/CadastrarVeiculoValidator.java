package com.pcs.autok.controller.validators.veiculo;

import java.sql.SQLException;

import com.pcs.autok.model.Veiculo;
import com.pcs.autok.utils.ResultParameters;

public class CadastrarVeiculoValidator {

	Veiculo veiculo;

	public CadastrarVeiculoValidator(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int validar(Veiculo veiculo) throws SQLException {
		return ResultParameters.OK.getResult();
	}
}
