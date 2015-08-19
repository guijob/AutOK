package com.pcs.autok.controller.paginascliente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfiguracoesContaController {

	@RequestMapping(value = "/configuracoesConta")
	public String configuracoesConta() {
		System.out.println("ConfiguracoesConta: Passing through...");
		return "cliente/configuracoes_conta";
	}
}
