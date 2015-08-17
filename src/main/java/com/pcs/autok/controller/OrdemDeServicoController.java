package com.pcs.autok.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.FuncionarioDAO;
import com.pcs.autok.dao.OrdemDeServicoDAO;
import com.pcs.autok.dao.TipoDeServicoDAO;
import com.pcs.autok.forms.FormularioOrdemServico;
import com.pcs.autok.model.OrdemDeServico;
import com.pcs.autok.model.Servico;
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
		ModelAndView view = new ModelAndView("os/formularioCriar");
		TipoDeServicoDAO dao = new TipoDeServicoDAO();
		List<TipoServico> servicos = dao.listarTodos();
		TipoServico placeholder = new TipoServico();
		placeholder.setNome("Selecione");
		servicos.add(0, placeholder);
		view.addObject("formulario", os);
		view.addObject("servicos", servicos);
		
		return view;
	}
	
	@RequestMapping(value = "/criarOrdemServico")
	public ModelAndView criarOS(HttpSession session, @ModelAttribute FormularioOrdemServico formulario) {
		
		ArrayList<TipoServico> servicos = (ArrayList<TipoServico>) new ArrayList<TipoServico>();
		
		if (formulario.getUm() != null && !(formulario.getUm().getNome().equals("Selecione"))) {
			servicos.add(formulario.getUm());
		}
		if (formulario.getDois() != null && !(formulario.getDois().getNome().equals("Selecione"))) {
			servicos.add(formulario.getDois());
		}
		if (formulario.getTres() != null && !(formulario.getTres().getNome().equals("Selecione"))) {
			servicos.add(formulario.getTres());
		}
		if (formulario.getQuatro() != null && !(formulario.getQuatro().getNome().equals("Selecione"))) {
			servicos.add(formulario.getQuatro());
		}
		if (formulario.getCinco() != null && !(formulario.getCinco().getNome().equals("Selecione"))) {
			servicos.add(formulario.getCinco());
		}
		
		System.out.println(formulario.toString());
		
		float precoTotal = 0;
		
		for (TipoServico s: servicos) {
			
			precoTotal = precoTotal + s.getPreco();
		}
		
		int duracaoTotal = 0;
		
		for (TipoServico s: servicos) {
			
			duracaoTotal = duracaoTotal + s.getDuracaoEmHoras();
		}
		
		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
		OrdemDeServico os = new OrdemDeServico();
		os.setIdAgendamento(formulario.getIdAgendamento());
		os.setPrecoTotal(precoTotal);
		os.setStatus("Em andamento");
		os.setJustificativa("qualquer");
				
		FuncionarioDAO dao2 = new FuncionarioDAO();
		
		List<Funcionario> funcionarios = dao2.buscarTodosFuncionariosPorTipo("tec_responsavel");
		
		os.setIdResponsavelUm(funcionarios.get(0).getId());
		os.setIdResponsavelDois(funcionarios.get(1).getId());
		
		dao.criarOS(os);
		
		return mostrarOrdensDeServico(session);
	}

}
