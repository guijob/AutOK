package com.pcs.autok.controller.validators.veiculo;

import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.utils.ResultParameters;

public class ExcluirVeiculoValidator {

	Veiculo veiculo;

	public ExcluirVeiculoValidator(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int validar(Veiculo veiculo) {

		/* validar campo vazio */
		if (veiculo.getRenavam() == null) {
			System.out.println("validarVeiculo: Não passou por ter renavam vazio...");
			return ResultParameters.CAMPO_VAZIO.getResult();
		}
		
		VeiculoDAO dao = new VeiculoDAO();
		boolean result = dao.buscarRenavam(veiculo);
		if (!result) {
			System.out.println("Não passou porque não existe usuário no banco de dados");
			return ResultParameters.USUARIO_NAO_ENCONTRADO.getResult();
		}

		/* validacao ok */
		return ResultParameters.OK.getResult();
	}
}
