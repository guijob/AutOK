package com.pcs.autok.model;

public class Cliente {

	/* id do cliente: chave primaria */
	private Integer idCliente;

	/* cpf do cliente */
	private Long cpfCliente;

	/* nome do cliente */
	private String nomeCliente;

	/* telefone do cliente */
	private Integer telCliente;

	/* email do cliente */
	private String emailCliente;

	/* getters e setters */

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
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

	/* toString da classe */
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cpfCliente=" + cpfCliente + ", nomeCliente=" + nomeCliente
				+ ", telCliente=" + telCliente + ", emailCliente=" + emailCliente + "]";
	}
}
