package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Agenda;
import com.pcs.autok.model.Horario;
import com.pcs.autok.model.Login;

public class AgendaDAO extends ConnectionDAO {
	
	private static final String COMMA = ",";

	public void criarAgenda(Agenda agenda) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.agenda");
			sql.append(" values " + "(" + agenda.getDataAgenda().toString() + ", " + agenda.getIdFuncionario()+ ");");
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

	public boolean buscarEmail(Agenda agenda) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.agenda where");
			//sql.append(" nomeagenda like '" + agenda.getEmail() + "';");
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

	public Login buscarRegistro(Login agenda) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Login u = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.agenda where");
			sql.append(
					" emailagenda like '" + agenda.getEmail() + "'" + "and senha like '" + agenda.getSenha() + "';");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			if (rs.next()) {
				u = new Login();
				u.setId(rs.getInt("idagenda"));
				u.setNome(rs.getString("nomeagenda"));
				u.setTelefone(rs.getInt("telefoneagenda"));
				u.setEndereco(rs.getString("enderecoagenda"));
				u.setEmail(rs.getString("emailagenda"));
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

	public void excluirAgenda(Agenda agenda) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.agenda");
			sql.append(" where dataagenda = " + agenda.toString() + "and idfuncionario = " + agenda.getIdFuncionario() + ");");
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

	public ArrayList<ArrayList<Horario>> buscarAgenda(int idFuncionario) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		ArrayList<ArrayList<Horario>> returnable = new ArrayList<>();

		try {
			
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.agenda where");
			sql.append(" idFuncionario = " + idFuncionario + ");");
			System.out.println(sql.toString());
			rs = stmt.executeQuery(sql.toString());
			
			ArrayList<Agenda> dias = new ArrayList<>();
			
			while (rs.next()) {
				
				Agenda dia = new Agenda();
				dia.setDataAgenda(rs.getDate("dataagenda"));
				dia.setIdFuncionario(idFuncionario);
				dias.add(dia);
			}
			
			for (Agenda dia: dias) {
				
				ArrayList<Horario> horarios = new ArrayList<>();
				
				sql.append("select * from dbAutOK.horario where");
				sql.append(" idFuncionario = " + idFuncionario + "and datahorario = " + dia.getDataAgenda().toString() + ");");
				System.out.println(sql.toString());
				rs = stmt.executeQuery(sql.toString());
				
				while (rs.next()) {
					
					Horario horario = new Horario();
					horario.setDate(dia.getDataAgenda());
					horario.setIdFuncionario(idFuncionario);
					horario.setHorarioLivre(rs.getInt("horario"));
					horarios.add(horario);
				}
				
				returnable.add(horarios);
				
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
		return returnable;
	}

	public List<Login> listarTodos() {
		List<Login> agendas = new ArrayList<Login>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select agenda.idagenda, agenda.nomeagenda, agenda.telagenda");
			sql.append(" from agenda agenda");
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
		return agendas;
	}

}
