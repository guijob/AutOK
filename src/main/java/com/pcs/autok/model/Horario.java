package com.pcs.autok.model;

import java.sql.Date;

public class Horario {
	
	private Integer idHorario;
	
	private Integer idFuncionario;
	
	private Date date;
	
	private Integer horarioLivre;
	
	private Integer ocupado;

	public void setOcupado(Integer ocupado) {
		this.ocupado = ocupado;
	}
	
	public Integer getOcupado() {
		
		return ocupado;
	}
	
	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getHorarioLivre() {
		return horarioLivre;
	}

	public void setHorarioLivre(Integer horarioLivre) {
		this.horarioLivre = horarioLivre;
	}
	
	

}
