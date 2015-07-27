package com.pcs.autok.model;

import com.pcs.autok.model.base.abstracts.Funcionario;

public class Atendente extends Funcionario{

	/* id do usuario: chave primaria */
	private Integer id;

	/* nome do usuario */
	private String nome;

	/* telefone do usuario */
	private Integer telefone;

	/* endereço do usuario */
	private Integer celular;

	/* endereço do usuario */
	private String endereco;

	/* email do usuario */
	private String email;

	/* senha do usuario */
	private String senha;
	
	private String tipo = "atendente";

	/* endereço do cliente */
	private Integer ctps;

	/* endereço do cliente */
	private Integer cpf;


	/* getters e setters */

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
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getTelefone() {
		return telefone;
	}


	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}


	public Integer getCelular() {
		return celular;
	}


	public void setCelular(Integer celular) {
		this.celular = celular;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTipo() {
		return tipo;
	}
}
