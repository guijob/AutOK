package com.pcs.autok.model.base.abstracts;

import com.pcs.autok.model.base.interfaces.UsuarioInterface;

public abstract class Usuario implements UsuarioInterface{
	
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
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
}
