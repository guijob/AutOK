package com.pcs.autok.controller.create;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastrarVeiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/cadastrarCliente")
	public String execute() {
		return "formulario";
	}

}
