package com.pcs.autok.forms;

import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.model.TipoServico;

public class FormularioOrdemServico {
	
	private Integer um;
	
	private Integer dois;
	
	private Integer tres;

	private Integer quatro;

	private Integer cinco;
	
	private int idAgendamento;

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Integer getUm() {
		return um;
	}

	public void setUm(Integer um) {
		this.um = um;
	}

	public Integer getDois() {
		return dois;
	}

	public void setDois(Integer dois) {
		this.dois = dois;
	}

	public Integer getTres() {
		return tres;
	}

	public void setTres(Integer tres) {
		this.tres = tres;
	}

	public Integer getQuatro() {
		return quatro;
	}

	public void setQuatro(Integer quatro) {
		this.quatro = quatro;
	}

	public Integer getCinco() {
		return cinco;
	}

	public void setCinco(Integer cinco) {
		this.cinco = cinco;
	}

	@Override
	public String toString() {
		return um + ", " + dois + ", " + tres + ", "+ quatro + ", " + cinco;
	}

	

}
