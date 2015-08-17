package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Administrador;
import com.pcs.autok.model.Atendente;
import com.pcs.autok.model.Caixa;
import com.pcs.autok.model.Login;
import com.pcs.autok.model.TecnicoAnalista;
import com.pcs.autok.model.TecnicoResponsavel;
import com.pcs.autok.model.base.abstracts.Funcionario;
import com.pcs.autok.model.base.abstracts.Usuario;

public class LoginDAO extends ConnectionDAO{
	public Usuario buscarRegistro(Login login) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Funcionario u = null;
		Login c = null;
		boolean isCliente = false;
		
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			
			if (login.getTipoUsuario().equals("cliente")){
				StringBuilder sql = new StringBuilder();
				
				sql.append("select * from dbAutOK.cliente where");
				sql.append(" emailcliente like '" + login.getEmail() + "'"
						+ " and senha like '" + login.getSenha() + "';");
				System.out.println(sql.toString());
				
				rs = stmt.executeQuery(sql.toString());
				
				if (rs.next()) {
					c = new Login();
					c.setId(rs.getInt("idcliente"));
					c.setNome(rs.getString("nomecliente"));
					c.setTelefone(rs.getInt("telefonecliente"));
					c.setEndereco(rs.getString("enderecocliente"));
					c.setEmail(rs.getString("emailcliente"));
					c.setSenha(rs.getString("senha"));
					c.setTipo("cliente");
					isCliente = true;
				} 
			}else {
					StringBuilder sql2 = new StringBuilder();
					sql2.append("select * from dbAutOK.funcionario where");
					sql2.append(" emailfuncionario like '" + login.getEmail() + "'"
							+ " and senhafuncionario like '" + login.getSenha() + "';");
					System.out.println(sql2.toString());
					
					rs2 = stmt.executeQuery(sql2.toString());
	
					if (rs2.next()) {
						switch (rs2.getString("tipofuncionario")) {
						case "administrador":
							u = new Administrador();
							break;
						case "tec_analista":
							u = new TecnicoAnalista();
							break;
						case "tec_responsavel":
							u = new TecnicoResponsavel();
							break;
						case "atendente":
							u = new Atendente();
							break;
						case "caixa":
							u = new Caixa();
							break;
						}
						
						u.setId(rs2.getInt("idfuncionario"));
						u.setNome(rs2.getString("nomefuncionario"));
						u.setTelefone(rs2.getInt("telefonefuncionario"));
						u.setCelular(rs2.getInt("celularfuncionario"));
						u.setEndereco(rs2.getString("enderecofuncionario"));
						u.setEmail(rs2.getString("emailfuncionario"));
						u.setSenha(rs2.getString("senhafuncionario"));
						u.setTipo(rs2.getString("tipofuncionario"));
						u.setCtps(rs2.getInt("ctpsfuncionario"));
						u.setCpf(rs2.getInt("cpffuncionario"));
					}
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				
				if(login.getTipoUsuario().equals("cliente"))
					rs.close();
				else
					rs2.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (login.getTipoUsuario().equals("cliente"))
			return c;
		else
			return u;
	}
}
