package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Funcionario;

public class FuncionarioDAO extends ConnectionDAO {

	public void editarFuncionario(Funcionario funcionario) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.funcionario");
			sql.append(" set nomefuncionario = '" + funcionario.getNomeFuncionario()
					+ "', telefonefuncionario = " + funcionario.getTelFuncionario() 
					+ "', celularfuncionario = " + funcionario.getCelFuncionario() 
					+ ", enderecofuncionario = '" + funcionario.getEndFuncionario() 
					+ "', emailfuncionario = '" + funcionario.getEmailFuncionario() 
					+ "', senhafuncionario = '" + funcionario.getSenhaFuncionario() 
					+ "', tipofuncionario = " + funcionario.getTipoFuncionario() 
					+ "', ctpsfuncionario = " + funcionario.getCtpsFuncionario() 
					+ ", cpffuncionario = " + funcionario.getCpfFuncionario() 
					+ " where emailfuncionario = '" + funcionario.getEmailFuncionario() 
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
	
	public void cadastrarFuncionario(Funcionario funcionario) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.funcionario");
			sql.append(" values " 
					+ "(0, " + "'" 
					+ funcionario.getNomeFuncionario() + "', " 
					+ funcionario.getTelFuncionario() + ", "
					+ funcionario.getCelFuncionario() + ", '"
					+ funcionario.getEndFuncionario() + "', '"
					+ funcionario.getEmailFuncionario() + "', '"
					+ funcionario.getSenhaFuncionario() + "', '"
					+ funcionario.getTipoFuncionario() + "', "
					+ funcionario.getCtpsFuncionario() + ", "
					+ funcionario.getCpfFuncionario() + ");");
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

	public boolean buscarEmail(Funcionario funcionario) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.funcionario where");
			sql.append(" nomefuncionario like '" + funcionario.getEmailFuncionario() + "';");
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
	
	public Funcionario buscarRegistro(Funcionario funcionario) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Funcionario u = null;
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.funcionario where");
			sql.append(" emailfuncionario like '" + funcionario.getEmailFuncionario() + "'"
					+ "and senhafuncionario like '" + funcionario.getSenhaFuncionario() + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u = new Funcionario();
				u.setIdFuncionario(rs.getInt("idfuncionario"));
				u.setNomeFuncionario(rs.getString("nomefuncionario"));
				u.setTelFuncionario(rs.getInt("telefonefuncionario"));
				u.setCelFuncionario(rs.getInt("celularfuncionario"));
				u.setEndFuncionario(rs.getString("enderecofuncionario"));
				u.setEmailFuncionario(rs.getString("emailfuncionario"));
				u.setSenhaFuncionario(rs.getString("senhafuncionario"));
				u.setTipoFuncionario(rs.getString("tipofuncionario"));
				u.setCtpsFuncionario(rs.getInt("ctpsfuncionario"));
				u.setCpfFuncionario(rs.getInt("cpffuncionario"));
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
	
	public void excluirFuncionario(Funcionario funcionario) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.funcionario");
			sql.append(" where emailfuncionario = '" + funcionario.getEmailFuncionario()
					+ "' and senhafuncionario = '" + funcionario.getSenhaFuncionario()
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
	
	public boolean buscarFuncionario(Funcionario funcionario) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
	
			sql.append("select * from dbAutOK.funcionario where");
			sql.append(" emailfuncionario like '" + funcionario.getEmailFuncionario() 
						+ "' and senhafuncionario like '" + funcionario.getSenhaFuncionario() + "';");
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
		System.out.println(":::" + result);
		return result;
	}

	public List<Funcionario> listarTodos() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select *");
			sql.append(" from funcionario funcionario");
			rs = stmt.executeQuery(sql.toString());

			Funcionario u = null;
			while (rs.next()) {
				u = new Funcionario();
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
		return funcionarios;
	}

}
