package com.pcs.autok.forms;

import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.model.TipoServico;

public class FormularioOrdemServico {
	
	private TipoServico um;
	
	private TipoServico dois;
	
	private TipoServico tres;

	private TipoServico quatro;

	private TipoServico cinco;
	
	private int idAgendamento;

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public TipoServico getUm() {
		return um;
	}

	public void setUm(TipoServico um) {
		this.um = um;
	}

	public TipoServico getDois() {
		return dois;
	}

	public void setDois(TipoServico dois) {
		this.dois = dois;
	}

	public TipoServico getTres() {
		return tres;
	}

	public void setTres(TipoServico tres) {
		this.tres = tres;
	}

	public TipoServico getQuatro() {
		return quatro;
	}

	public void setQuatro(TipoServico quatro) {
		this.quatro = quatro;
	}

	public TipoServico getCinco() {
		return cinco;
	}

	public void setCinco(TipoServico cinco) {
		this.cinco = cinco;
	}
	
	/*public List<TipoServico> getServicosNaoNulos() {
		
		List<TipoServico> returnable = new ArrayList<TipoServico>();
		
		List<TipoServico> lista = new ArrayList<TipoServico>();
		lista.add(um);
		lista.add(dois);
		lista.add(tres);
		lista.add(quatro);
		lista.add(cinco);

		for (TipoServico servico: lista) {
			
			if (servico != null && ! (servico.getNome().equals("Selecione")))
				returnable.add(servico);
			
		}
		
		return returnable;
		
	}*/
	
	/*public float getPrecoTotal() {
		
		
		float preco = 0;
		
		for (TipoServico servico: getServicosNaoNulos()) {
			
			preco = preco + servico.getPreco();
		
		}
		
		return preco;
	}
	
	public int getDuracaoTotal() {
		
		int duracao = 0;
		
		for (TipoServico servico: getServicosNaoNulos()) {
			
			duracao = duracao + servico.getDuracaoEmHoras();
		}
		
		return duracao;
	}*/

}
