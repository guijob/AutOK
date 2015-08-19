package com.pcs.autok.model;

public class Servico {
	
	private int id;
	
	private int idTipoServico;
	
	private int idOrdemServico;
	
	private float preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipoServico() {
		return idTipoServico;
	}

	public void setIdTipoServico(int idTipoServico) {
		this.idTipoServico = idTipoServico;
	}

	public int getIdOrdemServico() {
		return idOrdemServico;
	}

	public void setIdOrdemServico(int idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}	

}
