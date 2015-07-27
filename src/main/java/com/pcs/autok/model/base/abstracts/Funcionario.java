package com.pcs.autok.model.base.abstracts;

public class Funcionario extends Usuario{
	
	/* tipo do cliente */
	private String tipo;

	/* endereço do cliente */
	private Integer ctps;

	/* endereço do cliente */
	private Integer cpf;


	/* getters e setters */

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCtps() {
		return ctps;
	}

	public void setCtps(Integer ctps) {
		this.ctps = ctps;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Funcionario [tipo=" + tipo + ", ctps=" + ctps + ", cpf=" + cpf
				+ "]";
	}

}
