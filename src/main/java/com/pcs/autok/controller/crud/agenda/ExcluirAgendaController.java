package com.pcs.autok.controller.crud.agenda;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.agenda.ExcluirAgendaValidator;
import com.pcs.autok.dao.AgendaDAO;
import com.pcs.autok.model.Agenda;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class ExcluirAgendaController {

	@RequestMapping(value = "/confirmacaoExcluirAgenda", method = RequestMethod.GET)
	public ModelAndView getConfirmacaoExluirAgenda() {
			System.out.println("getConfirmacaoExcluirAgenda: Passing through...");

			ModelAndView mv = new ModelAndView("formularioExclusao");
			mv.addObject("agendaEntidade", new Agenda());
			return mv;
	}
	
	@RequestMapping(value = "/excluirAgenda", method = RequestMethod.POST)
	public ModelAndView excluirAgenda(@ModelAttribute Agenda agenda) throws SQLException {
		System.out.println("excluirAgenda: Passing through...");
		int result;
		ExcluirAgendaValidator validator = new ExcluirAgendaValidator(agenda);
		AgendaDAO dao = new AgendaDAO();
		ModelAndView mv = new ModelAndView("/agenda/exclusaoOk");

		result = validator.validar(agenda);

		if (result == ResultParameters.OK.getResult()) {
			dao.excluirAgenda(agenda);
			return mv;
		} else {
			System.out.println("excluirAgenda: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
