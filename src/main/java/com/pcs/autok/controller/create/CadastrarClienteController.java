package com.pcs.autok.controller.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CadastrarClienteController {
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String cadastrarCliente() {
		System.out.println("CadastrarClienteController: Passing through...");
		return "cliente/formulario";
	}
}
