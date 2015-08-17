package com.pcs.autok.model;

public class TipoServico {

	private int id;
	
	private String nome;
	
	private int duracaoEmHoras;
	
	private float preco;

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getDuracaoEmHoras() {
		return duracaoEmHoras;
	}

	public void setDuracaoEmHoras(int duracaoEmHoras) {
		this.duracaoEmHoras = duracaoEmHoras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	
}
