package com.pcs.autok.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.dao.TipoVeiculoDAO;
import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.TipoVeiculo;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.model.base.abstracts.Usuario;

@Controller
public class VeiculosController {

	@RequestMapping(value = "/listarVeiculos")
	public ModelAndView PaginaVeiculos(HttpSession session) {
		System.out.println("PaginaVeiculos: Passing through...");
		
		ModelAndView mv = new ModelAndView("veiculo/lista");
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		VeiculoDAO dao = new VeiculoDAO();
		TipoVeiculoDAO dao2 = new TipoVeiculoDAO();
		
		List<Veiculo> veiculos = dao.listarVeiculosPorIdUsuario(usuario);

		for (Veiculo veiculo: veiculos) {
			TipoVeiculo tipoVeiculo = dao2.buscarTipoVeiculo(veiculo);
			veiculo.setFabVeiculo(tipoVeiculo.getFabricante());
			veiculo.setModeloVeiculo(tipoVeiculo.getModelo());
		}
		System.out.println(veiculos);
		
		mv.addObject("veiculos", veiculos);
		return mv;
	}
}
