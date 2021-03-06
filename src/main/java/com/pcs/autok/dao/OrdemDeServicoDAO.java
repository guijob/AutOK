package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.OrdemDeServico;

public class OrdemDeServicoDAO extends ConnectionDAO {

	public OrdemDeServico buscarOS(Integer id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		OrdemDeServico os = null;
		try {	
			conn = startConnection();
			stmt = conn.createStatement();
			
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.ordem_servico where idordem_servico = " + id + ";");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());
			
			os = new OrdemDeServico();
			
			if (rs.next()) {
				os.setId(rs.getInt("idordem_servico"));
				os.setIdAgendamento(rs.getInt("idagendamento"));
				os.setDuracao(rs.getInt("duracao"));
				os.setIdResponsavelUm(rs.getInt("id_responsavel_1"));
				os.setIdResponsavelDois(rs.getInt("id_responsavel_2"));
				os.setPrecoTotal(rs.getFloat("preco_total"));
				os.setStatus(rs.getString("status"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return os;
	}
	
	public void alterarStatusDaOS(Integer id, String status) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			
			StringBuilder sql = new StringBuilder();
			
			if (status.equals("Em execucao"));
				aprovarOsESetarHoaririosTecResponsaveis(buscarOS(id));

			sql.append("update dbAutOK.ordem_servico");
			sql.append(" set status = '" + status + "' where idordem_servico = " + id + ";");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void aprovarOsESetarHoaririosTecResponsaveis(OrdemDeServico os) {

		HorarioDAO dao = new HorarioDAO();
		
		dao.setHorariosOcupados(dao.primeirosNHorariosLivresDeTecnico(os.getDuracao(), os.getIdResponsavelUm()), true);
		dao.setHorariosOcupados(dao.primeirosNHorariosLivresDeTecnico(os.getDuracao(), os.getIdResponsavelDois()), true);

	}
	

	public void criarOS(OrdemDeServico os, int duracao) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			
			HorarioDAO dao = new HorarioDAO();
			
			//dao.setHorariosOcupados(dao.primeirosNHorariosLivresDeTecnico(duracao, os.getIdResponsavelUm()), true);
			//dao.setHorariosOcupados(dao.primeirosNHorariosLivresDeTecnico(duracao, os.getIdResponsavelDois()), true);

			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.ordem_servico");
			sql.append(" values " + "(0, '" + os.getStatus() + "', '" + os.getJustificativa() + "', " + os.getIdAgendamento()
			+ ", "		+ os.getIdResponsavelUm() + ", " + os.getIdResponsavelDois() + ", "  + os.getPrecoTotal() + ", "
			+ os.getDuracao() + ");");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cancelarOS(OrdemDeServico os) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.ordem_servico");
			sql.append(" where idordem_servico = " + os.getId() + ");");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<OrdemDeServico> listarOrdensDeServico(Integer clienteId) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<OrdemDeServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.ordem_servico");
			sql.append(" where idagendamento in " + "(select idagendamento from dbAutOK.agendamento where idcliente = "
					+ clienteId + ");");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				OrdemDeServico os = new OrdemDeServico();
				os.setId(rs.getInt("idordem_servico"));
				os.setIdAgendamento(rs.getInt("idagendamento"));
				os.setStatus(rs.getString("status"));
				os.setJustificativa(rs.getString("justificativa"));
				os.setIdResponsavelUm(rs.getInt("id_responsavel_1"));
				os.setIdResponsavelDois(rs.getInt("id_responsavel_2"));
				os.setPrecoTotal(rs.getFloat("preco_total"));
				returnable.add(os);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return returnable;

	}

	public List<OrdemDeServico> listarOrdensDeServicoDeResponsavel(Integer id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<OrdemDeServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.ordem_servico");
			sql.append(" where id_responsavel_1 = " + id + " or " + "id_responsavel_2 = " + id);
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				OrdemDeServico os = new OrdemDeServico();
				os.setId(rs.getInt("idordem_servico"));
				os.setIdAgendamento(rs.getInt("idagendamento"));
				os.setStatus(rs.getString("status"));
				os.setJustificativa(rs.getString("justificativa"));
				os.setIdResponsavelUm(rs.getInt("id_responsavel_1"));
				os.setIdResponsavelDois(rs.getInt("id_responsavel_2"));
				os.setPrecoTotal(rs.getFloat("preco_total"));
				returnable.add(os);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return returnable;

	}
	
	public List<OrdemDeServico> listarOrdensDeServicoDeAnalista(Integer id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<OrdemDeServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.ordem_servico");
			sql.append(" where idagendamento in (select idagendamento from dbAutOK.agendamento where idHorario in "
					+ " (select id from dbAutOK.horario where idFuncionario = " + id + "));");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				OrdemDeServico os = new OrdemDeServico();
				os.setId(rs.getInt("idordem_servico"));
				os.setIdAgendamento(rs.getInt("idagendamento"));
				os.setStatus(rs.getString("status"));
				os.setJustificativa(rs.getString("justificativa"));
				os.setIdResponsavelUm(rs.getInt("id_responsavel_1"));
				os.setIdResponsavelDois(rs.getInt("id_responsavel_2"));
				os.setPrecoTotal(rs.getFloat("preco_total"));
				returnable.add(os);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return returnable;

	}
	
	public List<OrdemDeServico> listarOrdensDeServicoDeCaixa() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<OrdemDeServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.ordem_servico where status like 'Aguardando pagamento';");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				OrdemDeServico os = new OrdemDeServico();
				os.setId(rs.getInt("idordem_servico"));
				os.setIdAgendamento(rs.getInt("idagendamento"));
				os.setStatus(rs.getString("status"));
				os.setJustificativa(rs.getString("justificativa"));
				os.setIdResponsavelUm(rs.getInt("id_responsavel_1"));
				os.setIdResponsavelDois(rs.getInt("id_responsavel_2"));
				os.setPrecoTotal(rs.getFloat("preco_total"));
				returnable.add(os);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return returnable;

	}
	
	public List<OrdemDeServico> listarOrdensDeServicoDeAdministrador() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<OrdemDeServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.ordem_servico");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				OrdemDeServico os = new OrdemDeServico();
				os.setId(rs.getInt("idordem_servico"));
				os.setIdAgendamento(rs.getInt("idagendamento"));
				os.setStatus(rs.getString("status"));
				os.setJustificativa(rs.getString("justificativa"));
				os.setIdResponsavelUm(rs.getInt("id_responsavel_1"));
				os.setIdResponsavelDois(rs.getInt("id_responsavel_2"));
				os.setPrecoTotal(rs.getFloat("preco_total"));
				returnable.add(os);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return returnable;

	}

}
