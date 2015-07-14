package com.pcs.autok.controller.crud.tipopeca;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.TipoPecasDAO;
import com.pcs.autok.model.TipoPeca;

@Controller
public class AcessarTipoPecasController {

	@RequestMapping(value = "/listarTipoPecas", method = RequestMethod.GET)
	public ModelAndView listarTipoPecas() throws SQLException {
		System.out.println("listarTipoPecas: Passing through...");
		TipoPecasDAO dao = new TipoPecasDAO();
		ModelAndView mv = new ModelAndView("tipopecas/listar");
		
		List<TipoPeca> list = dao.listarTipoPecas();
		
		if ((list.size() > 0)) {
			mv.addObject("listaTipoPecas", list);
			return mv;
		}

		return null;
	}
}
