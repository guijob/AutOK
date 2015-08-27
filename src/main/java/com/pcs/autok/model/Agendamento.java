package com.pcs.autok.model;

public class Agendamento {
	
	private Integer idCliente;
	
	private Integer idVeiculo;
	
	private boolean temOS;
	
	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public boolean isTemOS() {
		return temOS;
	}

	public void setTemOS(boolean temOS) {
		this.temOS = temOS;
	}

	private String descricao;
	
	private Integer idAgendamento;
		
	private Integer idHorario;
	
	private String date;
	
	private String horarioLivre;
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHorarioLivre() {
		return horarioLivre;
	}

	public void setHorarioLivre(String horarioLivre) {
		this.horarioLivre = horarioLivre;
	}

	public Integer getIdCliente() {
		return idCliente;
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
