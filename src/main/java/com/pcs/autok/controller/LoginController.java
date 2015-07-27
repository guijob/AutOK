package com.pcs.autok.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.LogarUsuarioValidator;
import com.pcs.autok.dao.LoginDAO;
import com.pcs.autok.model.Login;
import com.pcs.autok.model.base.abstracts.Usuario;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class LoginController {

	@RequestMapping(value = "/formularioLogin", method = RequestMethod.GET)
	public ModelAndView getFormularioLogin() {
		System.out.println("getFormularioLogin: Passing through...");

		ModelAndView mv = new ModelAndView("formularioLogin");
		mv.addObject("loginEntidade", new Login());
		return mv;
	}

	@RequestMapping(value = "/logarUsuario", method = RequestMethod.POST)
	public String logarUsuario(Login login, HttpSession session) {
		System.out.println("logarUsuario: Passing through...");
		LogarUsuarioValidator validator = new LogarUsuarioValidator(login);
		LoginDAO dao = new LoginDAO();
		
		int result = validator.validar(login);
		Usuario u = dao.buscarRegistro(login);

		if (result == ResultParameters.OK.getResult() & !(u == null)) {
			session.setAttribute("usuarioLogado", u);
			return "home";
		} else {
			System.out.println("logarUsuario: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);

			mv2.addObject("erro", map.get(result));
			return "erro";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:";
	}
}
