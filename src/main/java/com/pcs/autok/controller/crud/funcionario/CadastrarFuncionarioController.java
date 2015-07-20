package com.pcs.autok.controller.crud.funcionario;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.funcionario.CadastrarFuncionarioValidator;
import com.pcs.autok.dao.FuncionarioDAO;
import com.pcs.autok.model.Funcionario;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class CadastrarFuncionarioController {

	@RequestMapping(value = "/formularioCadastrarFuncionario", method = RequestMethod.GET)
	public ModelAndView getFormularioFuncionario() {
		System.out.println("getFormularioFuncionario: Passing through...");

		ModelAndView mv = new ModelAndView("funcionario/formulario");
		mv.addObject("funcionarioEntidade", new Funcionario());
		return mv;
	}

	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
	public ModelAndView cadastrarFuncionario(@ModelAttribute Funcionario funcionario) throws SQLException {
		System.out.println("cadastrarFuncionario: Passing through...");
		int result;
		CadastrarFuncionarioValidator validator = new CadastrarFuncionarioValidator(funcionario);
		FuncionarioDAO dao = new FuncionarioDAO();
		ModelAndView mv = new ModelAndView("sucesso");

		result = validator.validar(funcionario);

		if (result == ResultParameters.OK.getResult()) {
			dao.cadastrarFuncionario(funcionario);
			return mv;
		} else {
			System.out.println("cadastrarFuncionario: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}
