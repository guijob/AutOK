package com.pcs.autok.controller.crud.atendente;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.cliente.ExcluirClienteValidator;
import com.pcs.autok.dao.ClienteDAO;
import com.pcs.autok.model.Cliente;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class ExcluirAtendenteController {

	@RequestMapping(value = "/confirmacaoExcluirAtendente", method = RequestMethod.GET)
	public ModelAndView getConfirmacaoExluirCliente() {
			System.out.println("getConfirmacaoExcluirCliente: Passing through...");

			ModelAndView mv = new ModelAndView("formularioExclusao");
			mv.addObject("clienteEntidade", new Cliente());
			return mv;
	}
	
	@RequestMapping(value = "/excluirAtendente", method = RequestMethod.POST)
	public ModelAndView excluirCliente(@ModelAttribute Cliente cliente) throws SQLException {
		System.out.println("excluirCliente: Passing through...");
		int result;
		ExcluirClienteValidator validator = new ExcluirClienteValidator(cliente);
		ClienteDAO dao = new ClienteDAO();
		ModelAndView mv = new ModelAndView("/cliente/exclusaoOk");

		result = validator.validar(cliente);

		if (result == ResultParameters.OK.getResult()) {
			dao.excluirCliente(cliente);
			return mv;
		} else {
			System.out.println("excluirCliente: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
