package com.pcs.autok.utils;

import java.util.Map;

public class HashResultParameters {

	public Map<Integer, String> setResultParametersHashMap(Map<Integer, String> map) {
		map.put(0, "Ok");
		map.put(1, "O seu nome está excedendo o nosso limite de dados\nPor favor, abrevie-o");
		map.put(2, "O telefone só deve conter números");
		map.put(4, "O seu telefone não está um formato padrão\nPor favor, não use o cód.país ou DDD");
		map.put(4, "O seu endereço está excedendo o nosso limite de dados\nPor favor, abrevie-o");
		map.put(5, "O seu email está em um formato incorreto");
		map.put(6, "Este email já está cadastrado em nosso sistema.");
		map.put(7, "A senha deve conter pelo menos 4 caracteres");
		map.put(8, "As senhas digitadas não conferem");
		map.put(9, "Por favor, preencha todos os campos");
		map.put(10, "Usuário não encontrado em nosso sistema");
		
		return map;
	}
	
	
}
