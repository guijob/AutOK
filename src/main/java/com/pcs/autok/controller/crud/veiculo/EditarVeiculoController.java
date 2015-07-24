package com.pcs.autok.controller.crud.veiculo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.veiculo.EditarVeiculoValidator;
import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class EditarVeiculoController {

	@RequestMapping(value = "/formularioVeiculoEditar", method = RequestMethod.GET)
	public ModelAndView getFormularioVeiculo() {
		System.out.println("getFormularioVeiculoEditarVeiculo: Passing through...");

		ModelAndView mv = new ModelAndView("formularioEditarVeiculo");
		mv.addObject("VeiculoEntidade", new Veiculo());
		return mv;
	}
	
	@RequestMapping(value = "/formularioEditarVeiculo", method = RequestMethod.POST)
	public ModelAndView editarVeiculo(@ModelAttribute Veiculo veiculo) {
		System.out.println("formularioEditarVeiculo: Passing through...");

		ModelAndView mv = new ModelAndView("veiculo/formularioEditarVeiculo");
		mv.addObject("veiculoEntidade", new Veiculo());
		return mv;
	}
	
	@RequestMapping(value ="/editarVeiculo", method = RequestMethod.POST)
	public ModelAndView cadastrarVeiculo(@ModelAttribute Veiculo veiculo) {
		System.out.println("editarVeiculo: Passing through...");
		int result;
		EditarVeiculoValidator validator = new EditarVeiculoValidator(veiculo);
		VeiculoDAO dao = new VeiculoDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(veiculo);

		if (result == ResultParameters.OK.getResult()) {
			dao.editarVeiculo(veiculo);
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
