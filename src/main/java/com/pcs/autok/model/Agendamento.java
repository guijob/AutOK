package com.pcs.autok.model;

public class Agendamento {
	
	private Integer idCliente;
	
	private String descricao;
	
	private Integer idTecnico;

	private Integer idAgendamento;
		
	private Integer idHorario;

	public Integer getIdCliente() {
		return idCliente;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}
	
	

}
