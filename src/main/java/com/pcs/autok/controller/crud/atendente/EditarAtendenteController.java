package com.pcs.autok.controller.crud.atendente;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.cliente.EditarUsuarioValidator;
import com.pcs.autok.dao.ClienteDAO;
import com.pcs.autok.model.Cliente;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class EditarAtendenteController {
	
	@RequestMapping(value = "/formularioEditarAtendente", method = RequestMethod.POST)
	public ModelAndView editarUsuario(@ModelAttribute Cliente cliente) {
		System.out.println("formularioEditar: Passing through...");

		ModelAndView mv = new ModelAndView("atendente/formularioEditar");
		mv.addObject("atendenteEntidade", new Cliente());
		return mv;
	}
	
	@RequestMapping(value ="/editarAtendente", method = RequestMethod.POST)
	public ModelAndView cadastrarCliente(@ModelAttribute Cliente cliente) {
		System.out.println("editarAtendente: Passing through...");
		int result;
		EditarUsuarioValidator validator = new EditarUsuarioValidator(cliente);
		ClienteDAO dao = new ClienteDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(cliente);

		if (result == ResultParameters.OK.getResult()) {
			dao.editarCliente(cliente);
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