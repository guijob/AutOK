package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Administrador;
import com.pcs.autok.model.Atendente;
import com.pcs.autok.model.Caixa;
import com.pcs.autok.model.TecnicoAnalista;
import com.pcs.autok.model.TecnicoResponsavel;
import com.pcs.autok.model.base.abstracts.Funcionario;
import com.pcs.autok.model.base.abstracts.Usuario;

public class FuncionarioDAO extends ConnectionDAO {

	public void editarFuncionario(Funcionario funcionario) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.funcionario");
			sql.append(" set nomefuncionario = '" + funcionario.getNome()
					+ "', telefonefuncionario = " + funcionario.getTelefone() 
					+ "', celularfuncionario = " + funcionario.getCelular() 
					+ ", enderecofuncionario = '" + funcionario.getEndereco() 
					+ "', emailfuncionario = '" + funcionario.getEmail() 
					+ "', senhafuncionario = '" + funcionario.getSenha() 
					+ "', tipofuncionario = " + funcionario.getTipo() 
					+ "', ctpsfuncionario = " + funcionario.getCtps() 
					+ ", cpffuncionario = " + funcionario.getCpf() 
					+ " where emailfuncionario = '" + funcionario.getEmail() 
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
					+ funcionario.getNome() + "', " 
					+ funcionario.getTelefone() + ", "
					+ funcionario.getCelular() + ", '"
					+ funcionario.getEndereco() + "', '"
					+ funcionario.getEmail() + "', '"
					+ funcionario.getSenha() + "', '"
					+ funcionario.getTipo() + "', "
					+ funcionario.getCtps() + ", "
					+ funcionario.getCpf() + ");");
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
			sql.append(" nomefuncionario like '" + funcionario.getEmail() + "';");
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
			sql.append(" emailfuncionario like '" + funcionario.getEmail() + "'"
					+ "and senhafuncionario like '" + funcionario.getSenha() + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if(rs.getString("tipofuncionario").equals("administrador")) {
				};
			
			if (rs.next()) {
				switch (rs.getString("tipofuncionario")) {
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
				
				u.setId(rs.getInt("idfuncionario"));
				u.setNome(rs.getString("nomefuncionario"));
				u.setTelefone(rs.getInt("telefonefuncionario"));
				u.setCelular(rs.getInt("celularfuncionario"));
				u.setEndereco(rs.getString("enderecofuncionario"));
				u.setEmail(rs.getString("emailfuncionario"));
				u.setSenha(rs.getString("senhafuncionario"));
				u.setCtps(rs.getInt("ctpsfuncionario"));
				u.setCpf(rs.getInt("cpffuncionario"));
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
			sql.append(" where emailfuncionario = '" + funcionario.getEmail()
					+ "' and senhafuncionario = '" + funcionario.getSenha()
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
			sql.append(" emailfuncionario like '" + funcionario.getEmail() 
						+ "' and senhafuncionario like '" + funcionario.getSenha() + "';");
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
