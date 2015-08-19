package com.pcs.autok.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.FuncionarioDAO;
import com.pcs.autok.dao.HorarioDAO;
import com.pcs.autok.dao.OrdemDeServicoDAO;
import com.pcs.autok.dao.TipoDeServicoDAO;
import com.pcs.autok.forms.FormularioOrdemServico;
import com.pcs.autok.model.Horario;
import com.pcs.autok.model.OrdemDeServico;
import com.pcs.autok.model.TipoServico;
import com.pcs.autok.model.base.abstracts.Funcionario;
import com.pcs.autok.model.base.abstracts.Usuario;

@Controller
public class OrdemDeServicoController {

	@RequestMapping(value = "/mostrarOrdensDeServico")
	public ModelAndView mostrarOrdensDeServico(HttpSession session) {
		System.out.println("MostrarOrdensDeServico: Passing through...");

		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();

		Usuario u = (Usuario) session.getAttribute("usuarioLogado");

		if (u != null && u.getTipo().equals("cliente")) {
			// cliente

			ArrayList<OrdemDeServico> lista = (ArrayList<OrdemDeServico>) dao.listarOrdensDeServico(u.getId());

			ModelAndView view = new ModelAndView("os/listaOrdemServico");
			view.addObject("ordensDeServico", lista);
			view.addObject("tipoUsuario", u.getTipo());

			return view;

		} else if (u != null && u.getTipo().equals("tec_responsavel")) {
			

			ArrayList<OrdemDeServico> lista = (ArrayList<OrdemDeServico>) dao.listarOrdensDeServicoDeResponsavel(u.getId());

			ModelAndView view = new ModelAndView("os/listaOrdemServico");
			view.addObject("ordensDeServico", lista);
			view.addObject("tipoUsuario", u.getTipo());

			return view;
			
		} else if (u != null && u.getTipo().equals("tec_analista")) {
			

			ArrayList<OrdemDeServico> lista = (ArrayList<OrdemDeServico>) dao.listarOrdensDeServicoDeAnalista(u.getId());

			ModelAndView view = new ModelAndView("os/listaOrdemServico");
			view.addObject("ordensDeServico", lista);
			view.addObject("tipoUsuario", u.getTipo());

			return view;
		}

		return null;
	}
	
	@RequestMapping(value="/formularioCriarOS")
	public ModelAndView formularioCriarOS(HttpSession session, @RequestParam("idAgendamento") Integer idAgendamento) {
		
		FormularioOrdemServico os = new FormularioOrdemServico();
		
		System.out.println("Id agendamento: " + idAgendamento);
		os.setIdAgendamento(idAgendamento);
		ModelAndView view = new ModelAndView("os/formularioOrdemServico");
		TipoDeServicoDAO dao = new TipoDeServicoDAO();
		List<TipoServico> servicos = dao.listarTodos();
		HashMap<Integer, String> hash = new HashMap<>();
		
		for (TipoServico servico: servicos) {
			hash.put(servico.getId(), servico.getNome());
		}
		
		hash.put(0, "Selecione");
		view.addObject("formulario", os);
		view.addObject("servicos", hash);
		
		return view;
	}
	
	@RequestMapping("/criarOrdemServico")
	public ModelAndView criarOS(HttpSession session, @ModelAttribute("formulario") FormularioOrdemServico formulario,
			 @RequestParam("idAgendamento") Integer idAgendamento) {
		
		ArrayList<Integer> servicos = new ArrayList<Integer>();
		
		if (formulario.getUm() != null && formulario.getUm() != 0) {
			servicos.add(formulario.getUm());
		}
		if (formulario.getDois() != null && formulario.getDois() != 0) {
			servicos.add(formulario.getDois());
		}
		if (formulario.getTres() != null && formulario.getTres() != 0) {
			servicos.add(formulario.getTres());
		}
		if (formulario.getQuatro() != null && formulario.getQuatro() != 0) {
			servicos.add(formulario.getQuatro());
		}
		if (formulario.getCinco() != null && formulario.getCinco() != 0) {
			servicos.add(formulario.getCinco());
		}
		
		System.out.println(formulario.toString());
		
		ArrayList<TipoServico> services = (ArrayList<TipoServico>) new TipoDeServicoDAO().listarAlguns(servicos);
		
		float precoTotal = 0;
		
		for (TipoServico s: services) {
			
			precoTotal = precoTotal + s.getPreco();
		}
		
		int duracaoTotal = 0;
		
		for (TipoServico s: services) {
			
			duracaoTotal = duracaoTotal + s.getDuracaoEmHoras();
		}
		
		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
		HorarioDAO daoHorario = new HorarioDAO();
		OrdemDeServico os = new OrdemDeServico();
		os.setIdAgendamento(idAgendamento);
		os.setPrecoTotal(precoTotal);
		os.setStatus("Em andamento");
		os.setJustificativa("");
				
		ArrayList<Horario> primeirosHorarios = (ArrayList<Horario>) daoHorario
				.primeiroHorarioLivreDeTecnicos("tec_responsavel", new Date());
		
		boolean shouldBreak = false;
				
		for (int i = 0; i < primeirosHorarios.size() - 1; i++) {
			
			int horarioLivre = primeirosHorarios.get(i).getHorarioLivre();

			for (int j = i + 1; j < primeirosHorarios.size(); j++) {
				
				if (primeirosHorarios.get(j).getHorarioLivre() == horarioLivre
					&& primeirosHorarios.get(j).getDate().equals(primeirosHorarios.get(i).getDate())) {
					
					os.setIdResponsavelUm(primeirosHorarios.get(i).getIdFuncionario());
					os.setIdResponsavelDois(primeirosHorarios.get(j).getIdFuncionario());
					shouldBreak = true;
					break;
				}
				
			}
			
			if (shouldBreak) break;
			
		}
		
		dao.criarOS(os, duracaoTotal);
		
		return mostrarOrdensDeServico(session);
	}

}
