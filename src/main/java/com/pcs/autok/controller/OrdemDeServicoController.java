package com.pcs.autok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdemDeServicoController {

	@RequestMapping(value = "/MostrarOrdensDeServico")
	public String mostrarOrdensDeServico() {
		System.out.println("MostrarOrdensDeServico: Passing through...");
		return "erro";
	}

	
}
