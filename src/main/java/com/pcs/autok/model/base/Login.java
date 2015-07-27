package com.pcs.autok.model.base;

public class Login {
	
	/* email de login */
	private String emailLogin;
	
	/* senha de login */
	private String senhaLogin;

	/* getters and setters */
	
	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getSenhaLogin() {
		return senhaLogin;
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

	@Override
	public String toString() {
		return "Login [emailLogin=" + emailLogin + ", senhaLogin=" + senhaLogin
				+ "]";
	}
	
}
