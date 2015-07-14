package com.pcs.autok.model;

public class TipoPeca {

	/* descricao do tipo de peca */
	public String descrPeca;

	public String getDescrPeca() {
		return descrPeca;
	}

	public void setDescrPeca(String descrPeca) {
		this.descrPeca = descrPeca;
	}

	@Override
	public String toString() {
		return "TipoPeca [descrPeca=" + descrPeca + "]";
	}
	
}
