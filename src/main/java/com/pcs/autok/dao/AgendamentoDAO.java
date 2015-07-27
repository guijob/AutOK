package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Agendamento;

public class AgendamentoDAO extends ConnectionDAO {
	
	
	public void criarAgendamento(Agendamento agendamento) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.agendamento");
			sql.append(" values " + "(0, "  + agendamento.getIdCliente()
					+ ", " + agendamento.getIdTecnico() + ", '"
					+ agendamento.getDescricao() + "', "
					+ agendamento.getIdHorario() + ");");
			System.out.println(sql.toString());
			
			//TODO - we should update the TécnicoAnalista's agenda here

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

	public List<Agendamento> buscarAgendamentosCliente(Integer idCliente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Agendamento> list = new ArrayList<Agendamento>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.agendamento where");
			sql.append(" idcliente = " + idCliente + ";");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			System.out.println(rs.next());
						
			while (rs.next()) {
				
				Agendamento a = new Agendamento();
				a.setIdCliente(idCliente);
				a.setIdAgendamento(rs.getInt("idagendamento"));
				a.setIdTecnico(rs.getInt("idtecnico"));
				a.setIdHorario(rs.getInt("idHorario"));
				a.setDescricao(rs.getString("descricao"));
				
				list.add(a);
				
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
		
		return list;
		
	}
	
	
	public void excluirAgendamento(Agendamento agendamento) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.Agendamento");
			sql.append(" where idagendamento = '" + agendamento.getIdAgendamento() + ";");
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
	

}
