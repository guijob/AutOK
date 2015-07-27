package com.pcs.autok.controller.crud.agendamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.model.Cliente;

public class CriarAgendamentoController {
	
	
	@RequestMapping(value = "/formularioCriarAgendamento", method = RequestMethod.POST)
	public ModelAndView getFormularioCliente() {
		System.out.println("getFormularioCliente: Passing through...");

		ModelAndView mv = new ModelAndView("agendamento/formulario");
		//TODO - update the line below
		mv.addObject("clienteEntidade", new Cliente());
		return mv;
	}

}
