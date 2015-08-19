package com.pcs.autok.model;

import com.pcs.autok.model.base.abstracts.Usuario;

public class Login extends Usuario{
/* senha repetida do cliente */
	private String confereSenha;

	private String TipoUsuario;

	/* getters e setters */
	
	public String getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.TipoUsuario = tipoUsuario;
	}

	public String getConfereSenha() {
		return confereSenha;
	}

	public void setConfereSenha(String confereSenha) {
		this.confereSenha = confereSenha;
	}
	
}
