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

	public List<Funcionario> buscarTodosFuncionariosPorTipo(String tipo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.funcionario where");
			sql.append(" tipofuncionario like '" + tipo + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			Funcionario u = null;
			
			while (rs.next()) {
					u = new TecnicoResponsavel();
				
				u.setId(rs.getInt("idfuncionario"));
				u.setNome(rs.getString("nomefuncionario"));
				u.setTelefone(rs.getInt("telefonefuncionario"));
				u.setCelular(rs.getInt("celularfuncionario"));
				u.setEndereco(rs.getString("enderecofuncionario"));
				u.setEmail(rs.getString("emailfuncionario"));
				u.setSenha(rs.getString("senhafuncionario"));
				u.setCtps(rs.getInt("ctpsfuncionario"));
				u.setCpf(rs.getInt("cpffuncionario"));
				u.setTipo(rs.getString("tipofuncionario"));
				funcionarios.add(u);
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
			sql.append(" from dbAutoK.funcionario");
			rs = stmt.executeQuery(sql.toString());
			
			Funcionario u = null;
			
			while(rs.next()) {	
				u = new Funcionario();
				u.setId(rs.getInt("idfuncionario"));
				u.setNome(rs.getString("nomefuncionario"));
				u.setTelefone(rs.getInt("telefonefuncionario"));
				u.setCelular(rs.getInt("celularfuncionario"));
				u.setEndereco(rs.getString("enderecofuncionario"));
				u.setEmail(rs.getString("emailfuncionario"));
				u.setSenha(rs.getString("senhafuncionario"));
				u.setTipo(rs.getString("tipofuncionario"));
				u.setCtps(rs.getInt("ctpsfuncionario"));
				u.setCpf(rs.getInt("cpffuncionario"));
				funcionarios.add(u);
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
	
	public List<Funcionario> listarEquipe(horario h) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select *");
			sql.append(" from dbAutoK.horarios");
			sql.append("  where data like '" + horario.data + "' and horario_"+ horario.hora +"is NULL;");
			rs = stmt.executeQuery(sql.toString());
			while(rs.next()) {
				StringBuilder sqlf = new StringBuilder();
				sqlf.append(" select TOP 2 *");
				sqlf.append(" from dbAutoK.funcionarios");
				sqlf.append(" where idfuncionario = " + rs.getInt("idfuncionario") + ";");
				ResultSet rs2 = stmt.executeQuery(sqlf.toString());
				
				Funcionario u = null;
				
				while(rs2.next()) {	
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
					funcionarios.add(u);
				}
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
