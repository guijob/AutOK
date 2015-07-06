package com.pcs.autok.model;

public class Cliente {

	/* id do cliente: chave primaria */
	private Integer idCliente;

	/* nome do cliente */
	private String nomeCliente;

	/* telefone do cliente */
	private Integer telCliente;

	/* endereço do cliente */
	private String endCliente;

	/* email do cliente */
	private String emailCliente;

	/* senha do cliente */
	private String senhaCliente;

	/* senha repetida do cliente */
	private String confereSenhaCliente;

	/* getters e setters */

	public String getEndCliente() {
		return endCliente;
	}

	public void setEndCliente(String endCliente) {
		this.endCliente = endCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getTelCliente() {
		return telCliente;
	}

	public void setTelCliente(Integer telCliente) {
		this.telCliente = telCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getConfereSenhaCliente() {
		return confereSenhaCliente;
	}

	public void setConfereSenhaCliente(String confereSenhaCliente) {
		this.confereSenhaCliente = confereSenhaCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente="
				+ nomeCliente + ", telCliente=" + telCliente + ", endCliente="
				+ endCliente + ", emailCliente=" + emailCliente
				+ ", senhaCliente=" + senhaCliente + ", confereSenhaCliente="
				+ confereSenhaCliente + "]";
	}
}
