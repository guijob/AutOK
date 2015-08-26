package com.pcs.autok.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.StatisticsDAO;
import com.pcs.autok.model.Estatisticas;
import com.pcs.autok.model.base.abstracts.Usuario;

@Controller
public class Statistics {
	
	@RequestMapping("/Statistics")
	public ModelAndView estatisticas(HttpSession session) {
		System.out.println("Estatisticas: Passing through...");
		
		ModelAndView mv = new ModelAndView("estatistica/lista");
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		StatisticsDAO dao = new StatisticsDAO();
		
		List<Estatisticas> estatistica = dao.listarTotais();

		System.out.println(estatistica);
		
		mv.addObject("estatisticas", estatistica);
		return mv;
	}
	

}
