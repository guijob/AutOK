package com.pcs.autok.model;

import com.pcs.autok.model.base.abstracts.Usuario;

public class Login extends Usuario{
/* senha repetida do cliente */
	private String confereSenha;


	/* getters e setters */

	public String getConfereSenha() {
		return confereSenha;
	}

	public void setConfereSenha(String confereSenha) {
		this.confereSenha = confereSenha;
	}
	
}
