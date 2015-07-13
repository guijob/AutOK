package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Cliente;

public class ClienteDAO extends ConnectionDAO {

	public void cadastrarCliente(Cliente cliente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.cliente");
			sql.append(" values " + "(0, " + "'" + cliente.getNomeCliente()
					+ "', " + cliente.getTelCliente() + ", '"
					+ cliente.getEndCliente() + "', '"
					+ cliente.getEmailCliente() + "', '"
					+ cliente.getSenhaCliente() + "');");
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

	public boolean buscarEmail(Cliente cliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.cliente where");
			sql.append(" nomecliente like '" + cliente.getEmailCliente() + "';");
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
	
	public Cliente buscarRegistro(Cliente cliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Cliente u = null;
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.cliente where");
			sql.append(" nomecliente like '" + cliente.getEmailCliente() + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u = new Cliente();
				u.setIdCliente(rs.getInt("idcliente"));
				u.setNomeCliente(rs.getString("nomecliente"));
				u.setTelCliente(rs.getInt("telcliente"));
				u.setEndCliente(rs.getString("endcliente"));
				u.setEmailCliente(rs.getString("emailcliente"));
				u.setSenhaCliente(rs.getString("senha"));
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
	
	public void excluirCliente(Cliente cliente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.cliente");
			sql.append(" where emailcliente = '" + cliente.getEmailCliente()
					+ "' and senha = '" + cliente.getSenhaCliente()
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
	
	public boolean buscarCliente(Cliente cliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
	
			sql.append("select * from dbAutOK.cliente where");
			sql.append(" nomecliente like '" + cliente.getEmailCliente() 
						+ "' and senha like '" + cliente.getSenhaCliente() + "';");
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

	public List<Cliente> listarTodos() {
		List<Cliente> clientes = new ArrayList<Cliente>();

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

			Cliente u = null;
			while (rs.next()) {
				u = new Cliente();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// conn.close();
				// stmt.close();
				// rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clientes;
	}

}
