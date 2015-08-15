package com.pcs.autok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VeiculosController {

	@RequestMapping(value = "/paginaVeiculos")
	public String PaginaVeiculos() {
		System.out.println("PaginaVeiculos: Passing through...");
		return "veiculo/lista";
	}
}
