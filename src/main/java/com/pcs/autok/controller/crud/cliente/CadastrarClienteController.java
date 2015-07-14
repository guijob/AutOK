package com.pcs.autok.controller.crud.cliente;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.cliente.CadastrarClienteValidator;
import com.pcs.autok.dao.ClienteDAO;
import com.pcs.autok.model.Cliente;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class CadastrarClienteController {

	@RequestMapping(value = "/formularioCadastrarCliente", method = RequestMethod.POST)
	public ModelAndView getFormularioCliente() {
		System.out.println("getFormularioCliente: Passing through...");

		ModelAndView mv = new ModelAndView("cliente/formulario");
		mv.addObject("clienteEntidade", new Cliente());
		return mv;
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public ModelAndView cadastrarCliente(@ModelAttribute Cliente cliente) throws SQLException {
		System.out.println("cadastrarCliente: Passing through...");
		int result;
		CadastrarClienteValidator validator = new CadastrarClienteValidator(cliente);
		ClienteDAO dao = new ClienteDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(cliente);

		if (result == ResultParameters.OK.getResult()) {
			dao.cadastrarCliente(cliente);
			return mv;
		} else {
			System.out.println("cadastrarCliente: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
