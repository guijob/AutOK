package com.pcs.autok.controller.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListarCrudsController {

	@RequestMapping(value = "/listarCrudCliente", method = RequestMethod.GET)
	public String listarCrudCliente() {
		System.out.println("listarCrudCliente: Passing through...");
		return "cruds/crud_cliente";
	}
}
