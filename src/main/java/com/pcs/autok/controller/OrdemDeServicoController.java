package com.pcs.autok.controller;

import java.util.ArrayList;
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
		} else if (u != null && u.getTipo().equals("caixa")) {
			

			ArrayList<OrdemDeServico> lista = (ArrayList<OrdemDeServico>) dao.listarOrdensDeServicoDeCaixa();

			ModelAndView view = new ModelAndView("os/listaOrdemServico");
			view.addObject("ordensDeServico", lista);
			view.addObject("tipoUsuario", u.getTipo());

			return view;
		}else if (u != null && u.getTipo().equals("tec_analista")) {
			

			ArrayList<OrdemDeServico> lista = (ArrayList<OrdemDeServico>) dao.listarOrdensDeServicoDeAnalista(u.getId());

			ModelAndView view = new ModelAndView("os/listaOrdemServico");
			view.addObject("ordensDeServico", lista);
			view.addObject("tipoUsuario", u.getTipo());

			return view;
		} else if (u != null && u.getTipo().equals("administrador")) {
			

			ArrayList<OrdemDeServico> lista = (ArrayList<OrdemDeServico>) dao.listarOrdensDeServicoDeAdministrador();

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

		FuncionarioDAO dao2 = new FuncionarioDAO();
		List<TipoServico> servicos = dao.listarTodos();
		HashMap<Integer, String> hash = new HashMap<>();
		HashMap<Integer, String> hashResponsaveis= new HashMap<>();
		HashMap<Integer, String> hashResponsaveis2= new HashMap<>();
		
		for (TipoServico servico: servicos) {
			hash.put(servico.getId(), servico.getNome());
		}
		
		List<Funcionario> tecResp = dao2.buscarTodosFuncionariosPorTipo("tec_responsavel");

		/*HorarioDAO daoHorario = new HorarioDAO();
		
		ArrayList<Horario> primeirosHorarios = (ArrayList<Horario>) daoHorario
				.primeiroHorarioLivreDeTecnicos("tec_responsavel", new Date());
		
		boolean shouldBreak = false;
		
		int idResp1 = 0, idResp2 = 0;
				
		for (int i = 0; i < primeirosHorarios.size() - 1; i++) {
			
			int horarioLivre = primeirosHorarios.get(i).getHorarioLivre();

			for (int j = i + 1; j < primeirosHorarios.size(); j++) {
				
				if (primeirosHorarios.get(j).getHorarioLivre() == horarioLivre
					&& primeirosHorarios.get(j).getDate().equals(primeirosHorarios.get(i).getDate())) {
					
					idResp1 = primeirosHorarios.get(i).getIdFuncionario();
					idResp2 = (primeirosHorarios.get(j).getIdFuncionario());
					shouldBreak = true;
					break;
				}
				
			}
			
			if (shouldBreak) break;
			
		}
		int idx1 = 0, idx2 = 0;
		
		for (Funcionario f: tecResp)
		{
			if (f.getId() == idResp1) {
				idx1 = tecResp.indexOf(f);
			}
		}
		for (Funcionario f: tecResp)
		{
			if (f.getId() == idResp2) {
				idx2 = tecResp.indexOf(f);
			}
		}
		hashResponsaveis.put(idResp1, tecResp.get(idx1).getNome());
		hashResponsaveis2.put(idResp2, tecResp.get(idx2).getNome());
		*/
		
		boolean amor = false;
		for (Funcionario funcionario: tecResp) {
			if (amor) {
				hashResponsaveis.put(funcionario.getId(), funcionario.getNome());
			}
			amor = true;

				hashResponsaveis2.put(funcionario.getId(), funcionario.getNome());
			
		}

		
		hash.put(0, "Selecione");
		view.addObject("formulario", os);
		view.addObject("servicos", hash);

		view.addObject("responsaveis", hashResponsaveis);
		view.addObject("responsaveis2", hashResponsaveis2);
		
		return view;
	}
	
	@RequestMapping("/AprovarOS")
	public ModelAndView aprovarOS(HttpSession session, 
			 @RequestParam("id") Integer id) {
		
		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
				
		dao.alterarStatusDaOS(id, "Em execucao");
		
		return mostrarOrdensDeServico(session);
	}
	
	@RequestMapping("/SuspenderOS")
	public ModelAndView suspenderOS(HttpSession session, 
			 @RequestParam("id") Integer id) {
		
		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
		
		dao.alterarStatusDaOS(id, "Suspensa");
		
		return mostrarOrdensDeServico(session);
	}
	
	@RequestMapping("/FinalizarOS")
	public ModelAndView finalizarOS(HttpSession session, 
			 @RequestParam("id") Integer id) {
		
		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
		
		dao.alterarStatusDaOS(id, "Aguardando pagamento");
		
		return mostrarOrdensDeServico(session);
	}
	
	@RequestMapping("/PagarOS")
	public ModelAndView pagarOS(HttpSession session, 
			 @RequestParam("id") Integer id) {
		
		OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
		
		dao.alterarStatusDaOS(id, "Paga");
		
		return mostrarOrdensDeServico(session);
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
		OrdemDeServico os = new OrdemDeServico();
		os.setIdAgendamento(idAgendamento);
		os.setPrecoTotal(precoTotal);
		os.setDuracao(duracaoTotal);
		os.setIdResponsavelUm(formulario.getTecResponsavel1());
		os.setIdResponsavelDois(formulario.getTecResponsavel2());
		os.setStatus("Aguardando aprovacao");
		os.setJustificativa("");
				
		dao.criarOS(os, duracaoTotal);
		
		return mostrarOrdensDeServico(session);
	}

}
