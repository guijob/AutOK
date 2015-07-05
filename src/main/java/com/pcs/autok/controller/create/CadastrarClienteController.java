package com.pcs.autok.controller.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.model.Cliente;

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
	public void cadastrarCliente(@ModelAttribute Cliente cliente) {
		System.out.println("cadastrarCliente: Passing through...");
		
		//chamar validators
		
		//se passar dos testes dos validators, tentar inserir no bd
		
		// se não passar dos testes, retorna com erro do validator
		
		// se tudo der certo, ir para sucesso
		
		// se der erro na inserção, trata o erro e manda pra pagina de formulario com detalhes do erro
		ModelAndView mv = new ModelAndView("view/sucesso");
		System.out.println(cliente.getNomeCliente());
	}
}
