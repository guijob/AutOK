package com.pcs.autok.controller.validators.veiculo;

import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.utils.ResultParameters;

public class EditarVeiculoValidator {

	Veiculo veiculo;

	public EditarVeiculoValidator(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int validar(Veiculo veiculo) {

		System.out.println(veiculo.toString());
		
		/* validar campo vazio */
		if (veiculo.getRENAVAM() == null
				|| veiculo.getModeloVeiculo() == null
				//|| veiculo.getFabVeiculo() == null
				//|| veiculo.getFabAno() == null
				//|| veiculo.getQuilometragem() == null
				) {
			System.out.println("validarVeiculo: Não passou por ter campos vazios...");
			return ResultParameters.CAMPO_VAZIO.getResult();
		}

		/* modelo estourando capacidade do banco de dados (45) */
		if (veiculo.getModeloVeiculo().length() > 45) {
			System.out
					.println("validarVeiculo: Não passou por ter modelo muito grande...");
			return ResultParameters.NOME_GRANDE.getResult();
		}

		/* RENAVAM com letras ou telefone estourando banco de dados (11) */
		if (veiculo.getRENAVAM() == null) {
			System.out.println("Não passou por ter letras no telefone");
			return ResultParameters.TELEFONE_COM_LETRAS.getResult();
		} else if (veiculo.getRENAVAM().length() > 13) {
			System.out
					.println("validarVeiculo: Não passou por ter RENAVAM muito grande...");
			return ResultParameters.TELEFONE_GRANDE.getResult();
		}

		/* validação OK */
		return ResultParameters.OK.getResult();
	}
}
