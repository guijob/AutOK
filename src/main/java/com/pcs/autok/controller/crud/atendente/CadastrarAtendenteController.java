package com.pcs.autok.controller.crud.atendente;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.atendente.CadastrarAtendenteValidator;
import com.pcs.autok.dao.AtendenteDAO;
import com.pcs.autok.model.Atendente;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class CadastrarAtendenteController {

	@RequestMapping(value = "/formularioCadastrarAtendente", method = RequestMethod.GET)
	public ModelAndView getFormularioAtendente() {
		System.out.println("getFormularioAtendente: Passing through...");

		ModelAndView mv = new ModelAndView("atendente/formulario");
		mv.addObject("atendenteEntidade", new Atendente());
		return mv;
	}

	@RequestMapping(value = "/cadastrarAtendente", method = RequestMethod.POST)
	public ModelAndView cadastrarAtendente(@ModelAttribute Atendente atendente) throws SQLException {
		System.out.println("cadastrarAtendente: Passing through...");
		int result;
		CadastrarAtendenteValidator validator = new CadastrarAtendenteValidator(atendente);
		AtendenteDAO dao = new AtendenteDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(atendente);

		if (result == ResultParameters.OK.getResult()) {
			dao.cadastrarAtendente(atendente);
			return mv;
		} else {
			System.out.println("cadastrarAtendente: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
