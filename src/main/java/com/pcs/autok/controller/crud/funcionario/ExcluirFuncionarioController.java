package com.pcs.autok.controller.crud.funcionario;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.funcionario.ExcluirFuncionarioValidator;
import com.pcs.autok.dao.FuncionarioDAO;
import com.pcs.autok.model.base.abstracts.Funcionario;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class ExcluirFuncionarioController {

	@RequestMapping(value = "/confirmacaoExcluirFuncionario", method = RequestMethod.GET)
	public ModelAndView getConfirmacaoExluirCliente() {
			System.out.println("getConfirmacaoExcluirFuncionario: Passing through...");

			ModelAndView mv = new ModelAndView("formularioExclusao");
			mv.addObject("funcionarioEntidade", new Funcionario());
			return mv;
	}
	
	@RequestMapping(value = "/excluirFuncionario", method = RequestMethod.POST)
	public ModelAndView excluirCliente(@ModelAttribute Funcionario funcionario) throws SQLException {
		System.out.println("excluirFuncionario: Passing through...");
		int result;
		ExcluirFuncionarioValidator validator = new ExcluirFuncionarioValidator(funcionario);
		FuncionarioDAO dao = new FuncionarioDAO();
		ModelAndView mv = new ModelAndView("/funcionario/exclusaoOk");

		result = validator.validar(funcionario);

		if (result == ResultParameters.OK.getResult()) {
			dao.excluirFuncionario(funcionario);
			return mv;
		} else {
			System.out.println("excluirFuncionario: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
