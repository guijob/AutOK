package com.pcs.autok.model;

public class OrdemDeServico {
	
	private Integer id;
	
	private String status;
	
	private String justificativa;
	
	private Integer idAgendamento;
	
	private Integer idResponsavelUm;
	
	private Integer idResponsavelDois;
	
	private Integer precoTotal;

	public Integer getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Integer precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Integer getIdResponsavelUm() {
		return idResponsavelUm;
	}

	public void setIdResponsavelUm(Integer idResponsavelUm) {
		this.idResponsavelUm = idResponsavelUm;
	}

	public Integer getIdResponsavelDois() {
		return idResponsavelDois;
	}

	public void setIdResponsavelDois(Integer idResponsavelDois) {
		this.idResponsavelDois = idResponsavelDois;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	
}
