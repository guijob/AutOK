package com.pcs.autok.controller.crud.veiculo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pcs.autok.controller.validators.veiculo.CadastrarVeiculoValidator;
import com.pcs.autok.dao.TipoVeiculoDAO;
import com.pcs.autok.dao.VeiculoDAO;
import com.pcs.autok.model.TipoVeiculo;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.model.base.abstracts.Usuario;
import com.pcs.autok.utils.HashResultParameters;
import com.pcs.autok.utils.ResultParameters;

@Controller
public class CadastrarVeiculoController {
	
	@RequestMapping(value = "/formularioCadastrarVeiculo", method = RequestMethod.GET)
	public ModelAndView getFormularioVeiculo() {
		System.out.println("getFormularioVeiculo: Passing through...");

		Map<String, String> hashFabricantes = new HashMap<String, String>();
		Map<Integer, String> hashModelos = new HashMap<Integer, String>();
		
		TipoVeiculoDAO dao = new TipoVeiculoDAO();
		List<TipoVeiculo> fabricantes = dao.listarFabricantes();
		
		for (TipoVeiculo fab: fabricantes) {
			hashFabricantes.put(fab.getFabricante(), fab.getFabricante());
		}
		
		List<TipoVeiculo> modelos = dao.listarModelos();
		
		for (TipoVeiculo mod: modelos) {
			hashModelos.put(mod.getIdTipoVeiculo(), mod.getModelo());
		}
		
		ModelAndView mv = new ModelAndView("veiculo/formulario");
		mv.addObject("veiculoEntidade", new Veiculo());
		mv.addObject("hashFabricantes", hashFabricantes);
		mv.addObject("hashModelos", hashModelos);
		return mv;
	}

	@RequestMapping(value = "/cadastrarVeiculo", method = RequestMethod.POST)
	public ModelAndView cadastrarVeiculo(@ModelAttribute Veiculo veiculo, HttpSession session) throws SQLException {
		System.out.println("cadastrarVeiculo: Passing through...");
		int result;
		CadastrarVeiculoValidator validator = new CadastrarVeiculoValidator(veiculo);
		VeiculoDAO dao = new VeiculoDAO();
		ModelAndView mv = new ModelAndView("veiculo/cadastrado");
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		veiculo.setIdCliente(usuario.getId());
		result = validator.validar(veiculo);

		if (result == ResultParameters.OK.getResult()) {
			
			TipoVeiculoDAO dao2 = new TipoVeiculoDAO();
			TipoVeiculo tipoVeiculo = dao2.buscarTipoVeiculo(veiculo);
			
			dao.cadastrarVeiculo(veiculo, tipoVeiculo);
			return mv;
		} else {
			System.out.println("cadastrarVeiculo: Error " + result);
			ModelAndView mv2 = new ModelAndView("erro");
			Map<Integer, String> map = new HashMap<Integer, String>();
			HashResultParameters hashMap = new HashResultParameters();
			map = hashMap.setResultParametersHashMap(map);
			
			mv2.addObject("erro", map.get(result));
			return mv2;
		}
	}
}