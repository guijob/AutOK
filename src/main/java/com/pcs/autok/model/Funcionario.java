package com.pcs.autok.model;

public class Funcionario {

	/* id do funcionario: chave primaria */
	private Integer idFuncionario;

	/* nome do funcionario */
	private String nomeFuncionario;

	/* telefone do funcionario */
	private Integer telFuncionario;

	/* endereço do funcionario */
	private String endFuncionario;

	/* email do funcionario */
	private String emailFuncionario;

	/* senha do funcionario */
	private String senhaFuncionario;
	
	/* senha do funcionario */
	private String confereSenhaFuncionario;
	
	/* tipo de funcionario */
	private String tipoFuncionario;

	/* getters e setters */

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Integer getTelFuncionario() {
		return telFuncionario;
	}

	public void setTelFuncionario(Integer telFuncionario) {
		this.telFuncionario = telFuncionario;
	}

	public String getEndFuncionario() {
		return endFuncionario;
	}

	public void setEndFuncionario(String endFuncionario) {
		this.endFuncionario = endFuncionario;
	}

	public String getEmailFuncionario() {
		return emailFuncionario;
	}

	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}

	public String getSenhaFuncionario() {
		return senhaFuncionario;
	}

	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}

	public String getConfereSenhaFuncionario() {
		return confereSenhaFuncionario;
	}

	public void setConfereSenhaFuncionario(String confereSenhaFuncionario) {
		this.confereSenhaFuncionario = confereSenhaFuncionario;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario
				+ ", nomeFuncionario=" + nomeFuncionario + ", telFuncionario="
				+ telFuncionario + ", endFuncionario=" + endFuncionario
				+ ", emailFuncionario=" + emailFuncionario
				+ ", senhaFuncionario=" + senhaFuncionario
				+ ", confereSenhaFuncionario=" + confereSenhaFuncionario
				+ ", tipoFuncionario=" + tipoFuncionario + "]";
	}

}
