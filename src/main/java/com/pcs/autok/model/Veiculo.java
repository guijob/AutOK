package com.pcs.autok.model;

public class Veiculo {

	/* id do veiculo: chave primaria */
	private Integer idVeiculo;
	
	/* id do cliente proprietario */
	private Integer idCliente;

	/* nome do modelo */
	private String modeloVeiculo;

	/* RENAVAM do veiculo */
	private String renavam;

	/* fabricante do veiculo */
	private String fabVeiculo;

	/* ano de fabricacao */
	private String fabAno;

	/* quilometragem */
	private Integer quilometragem;
	
	private String placaVeiculo;

	/* getters e setters */

	

	@Override
	public String toString() {
		return "Veiculo [idVeiculo=" + idVeiculo + ", idCliente=" + idCliente
				+ ", modeloVeiculo=" + modeloVeiculo + ", RENAVAM=" + renavam
				+ ", fabVeiculo=" + fabVeiculo + ", fabAno=" + fabAno
				+ ", quilometragem=" + quilometragem + "]";
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getFabVeiculo() {
		return fabVeiculo;
	}

	public void setFabVeiculo(String fabVeiculo) {
		this.fabVeiculo = fabVeiculo;
	}

	public String getFabAno() {
		return fabAno;
	}

	public void setFabAno(String fabAno) {
		this.fabAno = fabAno;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
}
