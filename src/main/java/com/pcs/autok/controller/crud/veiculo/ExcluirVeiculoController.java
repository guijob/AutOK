package com.pcs.autok.controller.crud.veiculo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.veiculo.ExcluirVeiculoValidator;
import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class ExcluirVeiculoController {

	@RequestMapping(value = "/confirmacaoExcluirVeiculo", method = RequestMethod.GET)
	public ModelAndView getConfirmacaoExluirVeiculo() {
			System.out.println("getConfirmacaoExcluirVeiculo: Passing through...");

			ModelAndView mv = new ModelAndView("formularioExclusao");
			mv.addObject("veiculoEntidade", new Veiculo());
			return mv;
	}
	
	@RequestMapping(value = "/excluirVeiculo", method = RequestMethod.GET)
	public ModelAndView excluirVeiculo(@RequestParam("id") Integer idVeiculo) {
		System.out.println("excluirVeiculo: Passing through...");
		int result;
		
		VeiculoDAO dao = new VeiculoDAO();
		
		Veiculo veiculo = dao.buscarVeiculoPorIdVeiculo(idVeiculo);
		
		ExcluirVeiculoValidator validator = new ExcluirVeiculoValidator(veiculo);
		ModelAndView mv = new ModelAndView("/veiculo/exclusaoOk");

		result = validator.validar(veiculo);

		if (result == ResultParameters.OK.getResult()) {
			dao.excluirVeiculo(veiculo);
			return mv;
		} else {
			System.out.println("excluirVeiculo: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("veiculo/erro", map.get(result));
			return mv2;
		}
	}
}
