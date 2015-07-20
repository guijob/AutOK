package com.pcs.autok.controller.crud.funcionario;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.funcionario.LogarFuncionarioValidator;
import com.pcs.autok.dao.FuncionarioDAO;
import com.pcs.autok.model.Funcionario;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class AcessarFuncionarioController {

	@RequestMapping(value = "/formularioLoginAtendente", method = RequestMethod.GET)
	public ModelAndView getFormularioLogin() {
		System.out.println("getFormularioLoginAtendente: Passing through...");

		ModelAndView mv = new ModelAndView("atendente/formularioLogin");
		mv.addObject("atendenteEntidade", new Funcionario());
		return mv;
	}

	@RequestMapping(value = "/logarAtendente", method = RequestMethod.POST)
	public ModelAndView logarUsuario(@ModelAttribute Funcionario atendente) {
		System.out.println("logarAtendente: Passing through...");
		int result;
		LogarFuncionarioValidator validator = new LogarFuncionarioValidator(atendente);
		FuncionarioDAO dao = new FuncionarioDAO();
		ModelAndView mv = new ModelAndView("home");

		result = validator.validar(atendente);

		if (result == ResultParameters.OK.getResult() & !(dao.buscarRegistro(atendente) == null)) {
			mv.addObject("atendente", dao.buscarRegistro(atendente));
			return mv;
		} else {
			System.out.println("logarAtendente: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);

			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
