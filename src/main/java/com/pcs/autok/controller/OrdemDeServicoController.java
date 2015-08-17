package com.pcs.autok.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.OrdemDeServicoDAO;
import com.pcs.autok.model.OrdemDeServico;
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

		}

		return null;
	}

}
