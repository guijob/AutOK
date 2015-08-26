package com.pcs.autok.model;

public class Estatisticas {

	/* quantidades */
	private Integer qVeiculos;

	private Integer qClientes;
	
	private Integer qOS;
	
	private Integer qFuncionarios;
	
	private Integer qServicos;
	
	/*getters / setters*/
	public Integer getqVeiculos() {
		return qVeiculos;
	}

	public void setqVeiculos(Integer qVeiculos) {
		this.qVeiculos = qVeiculos;
	}

	public Integer getqClientes() {
		return qClientes;
	}

	public void setqClientes(Integer qClientes) {
		this.qClientes = qClientes;
	}

	public Integer getqOS() {
		return qOS;
	}

	public void setqOS(Integer qOS) {
		this.qOS = qOS;
	}

	public Integer getqFuncionarios() {
		return qFuncionarios;
	}

	public void setqFuncionarios(Integer qFuncionarios) {
		this.qFuncionarios = qFuncionarios;
	}

	public Integer getqServicos() {
		return qServicos;
	}

	public void setqServicos(Integer qServicos) {
		this.qServicos = qServicos;
	}
	
	/*to string*/
	@Override
	public String toString() {
		return "Estatisticas [qVeiculos=" + qVeiculos + ", qClientes="
				+ qClientes + ", qOS=" + qOS + ", qFuncionarios="
				+ qFuncionarios + ", qServicos=" + qServicos + "]";
	}
}
