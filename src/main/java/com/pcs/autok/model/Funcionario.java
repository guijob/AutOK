package com.pcs.autok.model;

public class Funcionario {

	/* id do cliente: chave primaria */
	private Integer idFuncionario;

	/* nome do cliente */
	private String nomeFuncionario;

	/* telefone do cliente */
	private Integer telFuncionario;

	/* endereço do cliente */
	private Integer celFuncionario;

	/* endereço do cliente */
	private String endFuncionario;

	/* email do cliente */
	private String emailFuncionario;

	/* senha do cliente */
	private String senhaFuncionario;

	/* endereço do cliente */
	private String tipoFuncionario;

	/* endereço do cliente */
	private Integer ctpsFuncionario;

	/* endereço do cliente */
	private Integer cpfFuncionario;

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

	public Integer getCelFuncionario() {
		return celFuncionario;
	}

	public void setCelFuncionario(Integer celFuncionario) {
		this.celFuncionario = celFuncionario;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Integer getCtpsFuncionario() {
		return ctpsFuncionario;
	}

	public void setCtpsFuncionario(Integer ctpsFuncionario) {
		this.ctpsFuncionario = ctpsFuncionario;
	}

	public Integer getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(Integer cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario
				+ ", nomeFuncionario=" + nomeFuncionario + ", telFuncionario="
				+ telFuncionario + ", celFuncionario=" + celFuncionario
				+ ", endFuncionario=" + endFuncionario + ", emailFuncionario="
				+ emailFuncionario + ", senhaFuncionario=" + senhaFuncionario
				+ ", tipoFuncionario=" + tipoFuncionario + ", ctpsFuncionario="
				+ ctpsFuncionario + ", cpfFuncionario=" + cpfFuncionario + "]";
	}

}
