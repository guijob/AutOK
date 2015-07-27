package com.pcs.autok.controller.crud.veiculo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.veiculo.CadastrarVeiculoValidator;
import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class CadastrarVeiculoController {
	
	@RequestMapping(value = "/formularioCadastrarVeiculo", method = RequestMethod.GET)
	public ModelAndView getFormularioVeiculo() {
		System.out.println("getFormularioVeiculo: Passing through...");

		ModelAndView mv = new ModelAndView("veiculo/formulario");
		mv.addObject("veiculoEntidade", new Veiculo());
		return mv;
	}

	@RequestMapping(value = "/cadastrarVeiculo", method = RequestMethod.POST)
	public ModelAndView cadastrarVeiculo(@ModelAttribute Veiculo veiculo) throws SQLException {
		System.out.println("cadastrarVeiculo: Passing through...");
		int result;
		CadastrarVeiculoValidator validator = new CadastrarVeiculoValidator(veiculo);
		VeiculoDAO dao = new VeiculoDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(veiculo);

		if (result == ResultParameters.OK.getResult()) {
			dao.cadastrarVeiculo(veiculo);
			return mv;
		} else {
			System.out.println("cadastrarVeiculo: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}