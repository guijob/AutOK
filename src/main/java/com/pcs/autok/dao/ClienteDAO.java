package com.pcs.autok.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.base.SuperDAO;
import com.pcs.autok.model.Cliente;

public class ClienteDAO extends SuperDAO {

	public void editarCliente(Cliente cliente) {

		StringBuilder sql = new StringBuilder();

		sql.append("update dbAutOK.cliente");
		sql.append(" set nomecliente = '" + cliente.getNomeCliente()
				+ "', telefonecliente = " + cliente.getTelCliente()
				+ ",enderecocliente = '" + cliente.getEndCliente()
				+ "', emailcliente = '" + cliente.getEmailCliente()
				+ "',senha = '" + cliente.getSenhaCliente()
				+ "' where emailcliente = '" + cliente.getEmailCliente() + "';");
		System.out.println(sql.toString());

		executeQueryCRUD(sql.toString());
	}

	public void cadastrarCliente(Cliente cliente) {

		StringBuilder sql = new StringBuilder();

		sql.append("insert into dbAutOK.cliente");
		sql.append(" values " + "(0, " + "'" + cliente.getNomeCliente() + "', "
				+ cliente.getTelCliente() + ", '" + cliente.getEndCliente()
				+ "', '" + cliente.getEmailCliente() + "', '"
				+ cliente.getSenhaCliente() + "');");
		System.out.println(sql.toString());

		executeQueryCRUD(sql.toString());
	}

	public boolean buscarEmail(Cliente cliente) throws SQLException {
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();

		sql.append("select * from dbAutOK.cliente where");
		sql.append(" nomecliente like '" + cliente.getEmailCliente() + "';");
		System.out.println(sql.toString());

		rs = executeQueryCRUD(sql.toString());

		return rs.next();
	}

	public Cliente buscarRegistro(Cliente cliente) throws SQLException{
		ResultSet rs = null;
		Cliente u = null;

		StringBuilder sql = new StringBuilder();

		sql.append("select * from dbAutOK.cliente where");
		sql.append(" emailcliente like '" + cliente.getEmailCliente() + "'"
				+ "and senha like '" + cliente.getSenhaCliente() + "';");
		System.out.println(sql.toString());

		rs = executeQueryCRUD(sql.toString());

		if (rs.next()) {
			u = new Cliente();
			u.setIdCliente(rs.getInt("idcliente"));
			u.setNomeCliente(rs.getString("nomecliente"));
			u.setTelCliente(rs.getInt("telefonecliente"));
			u.setEndCliente(rs.getString("enderecocliente"));
			u.setEmailCliente(rs.getString("emailcliente"));
			u.setSenhaCliente(rs.getString("senha"));
		}
		return u;
	}

	public void excluirCliente(Cliente cliente) {

		StringBuilder sql = new StringBuilder();

		sql.append("delete from dbAutOK.cliente");
		sql.append(" where emailcliente = '" + cliente.getEmailCliente()
				+ "' and senha = '" + cliente.getSenhaCliente() + "';");
		System.out.println(sql.toString());

		executeQueryCRUD(sql.toString());
	}

	public boolean buscarCliente(Cliente cliente) throws SQLException {
		
		ResultSet rs = null;		
		StringBuilder sql = new StringBuilder();

		sql.append("select * from dbAutOK.cliente where");
		sql.append(" emailcliente like '" + cliente.getEmailCliente()
				+ "' and senha like '" + cliente.getSenhaCliente() + "';");
		System.out.println(sql.toString());
		rs = executeQueryCRUD(sql.toString());
		
		return rs.next();
	}

	public List<Cliente> listarTodos() throws SQLException{
		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select cliente.idCliente, cliente.nomeCliente, cliente.telCliente");
		sql.append(" from cliente cliente");
		rs = executeQueryCRUD(sql.toString());

		Cliente u = null;
		while (rs.next()) {
			u = new Cliente();
			u.setIdCliente(rs.getInt("idcliente"));
			u.setNomeCliente(rs.getString("nomecliente"));
			u.setTelCliente(rs.getInt("telefonecliente"));
			u.setEndCliente(rs.getString("enderecocliente"));
			u.setEmailCliente(rs.getString("emailcliente"));
			u.setSenhaCliente(rs.getString("senha"));
		}
		return clientes;
	}

}
