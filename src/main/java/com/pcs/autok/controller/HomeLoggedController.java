package com.pcs.autok.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcs.autok.model.base.abstracts.Usuario;

@Controller
public class HomeLoggedController {
	
	@RequestMapping("/homeLogged")
	public String home(HttpSession session) {
		
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		
		if (u.getTipo().equals("cliente"))
			return "cliente/home";
		
		return "funcionario/home";
	}
	

}
