package com.pcs.autok.model;

public class Atendente {

	/* id do cliente: chave primaria */
	private Integer idAtendente;

	/* nome do cliente */
	private String nomeAtendente;

	/* telefone do cliente */
	private Integer telAtendente;

	/* endereço do cliente */
	private String endAtendente;

	/* email do cliente */
	private String emailAtendente;

	/* senha do cliente */
	private String senhaAtendente;

	/* getters e setters */

	public Integer getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(Integer idAtendente) {
		this.idAtendente = idAtendente;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

	public Integer getTelAtendente() {
		return telAtendente;
	}

	public void setTelAtendente(Integer telAtendente) {
		this.telAtendente = telAtendente;
	}

	public String getEndAtendente() {
		return endAtendente;
	}

	public void setEndAtendente(String endAtendente) {
		this.endAtendente = endAtendente;
	}

	public String getEmailAtendente() {
		return emailAtendente;
	}

	public void setEmailAtendente(String emailAtendente) {
		this.emailAtendente = emailAtendente;
	}

	public String getSenhaAtendente() {
		return senhaAtendente;
	}

	public void setSenhaAtendente(String senhaAtendente) {
		this.senhaAtendente = senhaAtendente;
	}

	@Override
	public String toString() {
		return "Atendente [idAtendente=" + idAtendente + ", nomeAtendente="
				+ nomeAtendente + ", telAtendente=" + telAtendente
				+ ", endAtendente=" + endAtendente + ", emailAtendente="
				+ emailAtendente + ", senhaAtendente=" + senhaAtendente + "]";
	}

}
