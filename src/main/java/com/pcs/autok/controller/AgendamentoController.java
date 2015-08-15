package com.pcs.autok.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.AgendamentoDAO;
import com.pcs.autok.model.Agendamento;
import com.pcs.autok.model.base.abstracts.Usuario;

@Controller
public class AgendamentoController {
	
	@RequestMapping(value = "/listarAgendamentos")
	public ModelAndView listarAgendamentos(HttpSession session) {
		System.out.println("AgendamentoController: Passing through...");
		
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		
		AgendamentoDAO dao = new AgendamentoDAO();
		
		ArrayList<Agendamento> agendamentos = (ArrayList<Agendamento>) dao.buscarAgendamentosCliente(u.getId());
		
		
		ModelAndView view = new ModelAndView("agendamento/agendamentos");
		view.addObject("agendamentos", agendamentos);
		
		return view;
	}
	
	@RequestMapping(value = "/agendamentoFormulario")
	public ModelAndView agendamentoFormulario(HttpSession session) {
		
		System.out.println("AgendamentoController: Passing through...");
		Agendamento agendamento = new Agendamento();
		
		ModelAndView view = new ModelAndView("agendamento/formulario");
		view.addObject("novoAgendamento", agendamento);
		return view;
	}
	
	@RequestMapping(value = "/criarAgendamento")
	public ModelAndView criarAgendamento(HttpSession session, @ModelAttribute Agendamento novoAgendamento) {
		
		System.out.println("AgendamentoController: Passing through...");
		
		AgendamentoDAO dao = new AgendamentoDAO();
		novoAgendamento.setIdCliente(((Usuario) session.getAttribute("usuarioLogado")).getId());
		dao.criarAgendamento(novoAgendamento, novoAgendamento.getIdHorario());
		return listarAgendamentos(session);
	}
	
	@RequestMapping(value = "/excluirAgendamento")
	public ModelAndView excluirAgendamento(HttpSession session, @RequestParam("idAgendamento") Integer idAgendamento,
			@RequestParam("idHorario") Integer idHorario) {
		
		System.out.println("AgendamentoController: Passing through...");
		
		AgendamentoDAO dao = new AgendamentoDAO();
		dao.excluirAgendamento(idAgendamento, idHorario);
		return listarAgendamentos(session);
	}

}
