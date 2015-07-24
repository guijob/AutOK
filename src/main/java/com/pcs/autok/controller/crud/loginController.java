package com.pcs.autok.controller.crud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.LogarUsuarioValidator;
import com.pcs.autok.dao.ClienteDAO;
import com.pcs.autok.model.Cliente;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class loginController {

	@RequestMapping(value = "/formularioLogin", method = RequestMethod.GET)
	public ModelAndView getFormularioLogin() {
		System.out.println("getFormularioLogin: Passing through...");

		ModelAndView mv = new ModelAndView("formularioLogin");
		mv.addObject("loginEntidade", new Cliente());
		return mv;
	}

	@RequestMapping(value = "/logarUsuario", method = RequestMethod.POST)
	public ModelAndView logarUsuario(@ModelAttribute Cliente cliente) {
		System.out.println("logarUsuario: Passing through...");
		int result;
		LogarUsuarioValidator validator = new LogarUsuarioValidator(cliente);
		ClienteDAO dao = new ClienteDAO();
		ModelAndView mv = new ModelAndView("home");

		result = validator.validar(cliente);

		if (result == ResultParameters.OK.getResult() & !(dao.buscarRegistro(cliente) == null)) {
			mv.addObject("cliente", dao.buscarRegistro(cliente));
			return mv;
		} else {
			System.out.println("logarUsuario: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);

			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
