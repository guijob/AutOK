package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Login;

public class ClienteDAO extends ConnectionDAO {

	public void editarCliente(Login cliente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.cliente");
			sql.append(" set nomecliente = '" + cliente.getNome()
					+ "', telefonecliente = " + cliente.getTelefone() + ",enderecocliente = '"
					+ cliente.getEndereco() + "', emailcliente = '"
					+ cliente.getEmail() + "',senha = '"
					+ cliente.getSenha() + "' where emailcliente = '" + cliente.getEmail() + "';");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cadastrarCliente(Login cliente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.cliente");
			sql.append(" values " + "(0, " + "'" + cliente.getNome()
					+ "', " + cliente.getTelefone() + ", '"
					+ cliente.getEndereco() + "', '"
					+ cliente.getEmail() + "', '"
					+ cliente.getSenha() + "');");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean buscarEmail(Login cliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.cliente where");
			sql.append(" nomecliente like '" + cliente.getEmail() + "';");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			System.out.println(rs.next());
			result = rs.next();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Login buscarRegistro(Login cliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Login u = null;
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.cliente where");
			sql.append(" emailcliente like '" + cliente.getEmail() + "'"
					+ "and senha like '" + cliente.getSenha() + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u = new Login();
				u.setId(rs.getInt("idcliente"));
				u.setNome(rs.getString("nomecliente"));
				u.setTelefone(rs.getInt("telefonecliente"));
				u.setEndereco(rs.getString("enderecocliente"));
				u.setEmail(rs.getString("emailcliente"));
				u.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	
	public void excluirCliente(Login cliente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.cliente");
			sql.append(" where emailcliente = '" + cliente.getEmail()
					+ "' and senha = '" + cliente.getSenha()
					+ "';");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean buscarCliente(Login cliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
	
			sql.append("select * from dbAutOK.cliente where");
			sql.append(" emailcliente like '" + cliente.getEmail() 
						+ "' and senha like '" + cliente.getSenha() + "';");
			System.out.println(sql.toString());
			rs = stmt.executeQuery(sql.toString());
			result = rs.next();
		} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Login> listarTodos() {
		List<Login> clientes = new ArrayList<Login>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select cliente.idCliente, cliente.nomeCliente, cliente.telCliente");
			sql.append(" from cliente cliente");
			rs = stmt.executeQuery(sql.toString());

			@SuppressWarnings("unused")
			Login u = null;
			while (rs.next()) {
				u = new Login();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				 conn.close();
				 stmt.close();
				 rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clientes;
	}

}
