package com.pcs.autok.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.AgendamentoDAO;
import com.pcs.autok.dao.HorarioDAO;
import com.pcs.autok.model.Agendamento;
import com.pcs.autok.model.Horario;
import com.pcs.autok.model.base.abstracts.Usuario;
import com.pcs.autok.utils.HashDaysParameters;

@Controller
public class AgendamentoController {

	@RequestMapping(value = "/listarAgendamentos")
	public ModelAndView listarAgendamentos(HttpSession session) {
		System.out.println("AgendamentoController: Passing through...");

		Usuario u = (Usuario) session.getAttribute("usuarioLogado");

		AgendamentoDAO dao = new AgendamentoDAO();
		
		ArrayList<Agendamento> agendamentos;

		if (u != null && u.getTipo().equals("cliente")) {

			agendamentos = (ArrayList<Agendamento>) dao.buscarAgendamentosCliente(u.getId());

		} else if (u != null && u.getTipo().equals("tec_analista")) {
			
			agendamentos = (ArrayList<Agendamento>) dao.buscarAgendamentosAnalista(u.getId());
			
		} else {
		
			agendamentos = new ArrayList<>();

		}
		
		ModelAndView view = new ModelAndView("agendamento/listaAgendamentos");
		view.addObject("agendamentos", agendamentos);
		view.addObject("tipoUsuario", u.getTipo());
		
		return view;
	}

	@RequestMapping(value = "/agendamentoFormulario")
	public ModelAndView agendamentoFormulario(HttpSession session) throws ParseException {

		System.out.println("AgendamentoController: Passing through...");
		Agendamento agendamento = new Agendamento();

		HorarioDAO dao = new HorarioDAO();
		List<Date> datas = dao.buscarDiasDisponiveisDeTodosTecAnalistas();
		List<String> sDatas = new ArrayList<String>();
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> mapAllDays = new HashMap<Integer, String>();

		Map<Integer, String> map2 = new HashMap<Integer, String>();
		HashDaysParameters hashMap = new HashDaysParameters();
		map2 = hashMap.setDaysParametersHashMap(map2);

		// converte Date para String de maneira legivel
		for (Date data : datas) {

		}

		boolean repetido = false;

		// percorre o map de dias pra criar map de horarios
		for (Date data : datas) {
			System.out.println(data);

			Calendar cal = Calendar.getInstance();
			cal.setTime(data);

			List<Horario> horarios = dao.buscarHorariosDisponiveisDeUmaData(data);
			for (Horario horario : horarios) {

				Set<Integer> chaves = map.keySet();
				for (Integer chave : chaves) {
					if (map.get(chave).contains(horario.getHorarioLivre().toString() + ":00h")) {
						repetido = true;
					}
				}
				if (!repetido) {
					if (horario.getHorarioLivre() > 9)
						map.put(horario.getIdHorario(),
								cal.get(Calendar.DATE) + " de " + map2.get(cal.get(Calendar.MONTH) + 1) + " de "
										+ cal.get(Calendar.YEAR) + " - " + horario.getHorarioLivre() + ":00h");
					else
						map.put(horario.getIdHorario(),
								cal.get(Calendar.DATE) + " de " + map2.get(cal.get(Calendar.MONTH) + 1) + " de "
										+ cal.get(Calendar.YEAR) + " - 0" + horario.getHorarioLivre() + ":00h");

				}
				repetido = false;
			}

			mapAllDays.putAll(map);
			map.clear();

		}

		Map<Integer, String> sortedMapAllDays = sortByValue(mapAllDays);

		ModelAndView view = new ModelAndView("agendamento/formularioAgendamento");
		view.addObject("novoAgendamento", agendamento);
		view.addObject("horarios", sortedMapAllDays);
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

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
