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
			sql.append(" values " + "(0, " + "'" + cliente.getNomeCliente() + "', "
					+ cliente.getTelCliente() + ", '" + cliente.getEndCliente()
					+ "', '" + cliente.getEmailCliente() + "', '"
					+ cliente.getSenhaCliente() + "');");
			System.out.println(sql.toString());
			
			stmt.executeUpdate(sql.toString());
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
