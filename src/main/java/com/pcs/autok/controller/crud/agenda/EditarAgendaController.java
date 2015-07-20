package com.pcs.autok.controller.crud.agenda;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.agenda.EditarAgendaValidator;
import com.pcs.autok.dao.AgendaDAO;
import com.pcs.autok.model.Agenda;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class EditarAgendaController {
	
	@RequestMapping(value = "/formularioEditarAgenda", method = RequestMethod.GET)
	public ModelAndView editarUsuario(@ModelAttribute Agenda agenda) {
		System.out.println("formularioEditar: Passing through...");

		ModelAndView mv = new ModelAndView("agenda/formularioEditar");
		mv.addObject("agendaEntidade", new Agenda());
		return mv;
	}
	
	@RequestMapping(value ="/editarAgenda", method = RequestMethod.POST)
	public ModelAndView cadastrarAgenda(@ModelAttribute Agenda agenda) throws SQLException {
		System.out.println("editarAgenda: Passing through...");
		int result;
		EditarAgendaValidator validator = new EditarAgendaValidator(agenda);
		AgendaDAO dao = new AgendaDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(agenda);

		if (result == ResultParameters.OK.getResult()) {
			dao.editarAgenda(agenda);
			return mv;
		} else {
			System.out.println("cadastrarAgenda: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
	
}
