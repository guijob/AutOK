package com.pcs.autok.utils;

/*
 * public enum ResulParameters
 * 
 * contem constantes dos erros dos validators
 */
public enum ResultParameters {
	
	OK(0), 
	NOME_GRANDE(1), 
	TELEFONE_COM_LETRAS(2),
	TELEFONE_GRANDE(3), 
	ENDERECO_GRANDE(4), 
	EMAIL_NAO_FORMATADO(5),
	EMAIL_JA_EXISTE(6),
	SENHA_PEQUENA(7),
	SENHAS_NAO_BATEM(8),
	CAMPO_VAZIO(9);
	
	public int result;
	
	public int getResult() {
		return result;
	}
	private ResultParameters (int valor) {
		result = valor;
	}
	
}
