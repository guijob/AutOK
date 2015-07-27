package com.pcs.autok.controller.crud.agendamento;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.AgendamentoDAO;
import com.pcs.autok.model.Agendamento;
import com.pcs.autok.model.Cliente;

public class AcessarAgendamentosController {
	
	@RequestMapping(value = "/agendamentos", method = RequestMethod.GET)
	public ModelAndView getAgendamentosCliente(HttpSession session) {
		
		System.out.println("agendamentos: Passing through...");
		
		AgendamentoDAO dao = new AgendamentoDAO();
		
		ArrayList<Agendamento> lista = (ArrayList<Agendamento>) dao.buscarAgendamentosCliente((
				(Cliente) session.getAttribute("usuarioLogado")).getIdCliente());
		

		ModelAndView mv = new ModelAndView("agendamento/agendamentos");
		
		mv.addObject("agendamentos", lista);
		
		return mv;
	}

}
