package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Horario;

public class HorarioDAO extends ConnectionDAO {

	public List<Horario> buscarHorariosDisponiveisDeUmaDataDeTecnicosAnalistas(Date data) throws ParseException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Horario> horarios = new ArrayList<Horario>();
		
		String sData= new SimpleDateFormat("yyyy-MM-dd").format(data);
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.horario");
			sql.append(" where dataHorario like '" + sData + "' and ocupado like 0 and idFuncionario in (");
			sql.append("select idfuncionario from dbAutOK.funcionario where tipofuncionario like 'tec_analista')");
			
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			Horario horario = null;
			
			while (rs.next()) {
				horario = new Horario();
				horario.setDate(rs.getDate("dataHorario"));
				horario.setHorarioLivre(rs.getInt("horario"));
				horario.setIdFuncionario(rs.getInt("idfuncionario"));
				horario.setIdHorario(rs.getInt("id"));
				horario.setOcupado(rs.getInt("ocupado"));
				
				horarios.add(horario);
			}
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
		
		return horarios;
	}
	
	public List<Horario> buscarHorariosDisponiveisDeUmaData(Date data) throws ParseException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Horario> horarios = new ArrayList<Horario>();
		
		String sData= new SimpleDateFormat("yyyy-MM-dd").format(data);
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.horario");
			sql.append(" where dataHorario like '" + sData + "' and ocupado like 0");
			sql.append(" order by horario;");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			Horario horario = null;
			
			while (rs.next()) {
				horario = new Horario();
				horario.setDate(rs.getDate("dataHorario"));
				horario.setHorarioLivre(rs.getInt("horario"));
				horario.setIdFuncionario(rs.getInt("idfuncionario"));
				horario.setIdHorario(rs.getInt("id"));
				horario.setOcupado(rs.getInt("ocupado"));
				
				horarios.add(horario);
			}
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
		
		return horarios;
	}
	
	public List<Date> buscarDiasDisponiveisDeTodosTecAnalistas() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Date> datas = new ArrayList<Date>();
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select distinct dataHorario from dbAutOK.horario where dataHorario >= '" + 
					   new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "' "
					   		+ "and idfuncionario in (select idfuncionario from dbAutOK.funcionario where tipofuncionario like 'tec_analista') order by dataHorario");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			Date data = null;
			SimpleDateFormat sdf = null;
			
			while (rs.next()) {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				data = sdf.parse(rs.getString("dataHorario").toString());
				datas.add(data);
			}
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
		
		return datas;
	}

	
	public void setHorarioOcupado(Integer idHorario, boolean ocupado) {

		Connection conn = null;
		Statement stmt = null;
		
		int oc = ocupado? 1:0;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.horario ");
			sql.append("set ocupado = " + oc + " where id = " + idHorario
					+ ";");
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
	
	public List<Horario> primeiroHorarioLivreDeTecnicos(String tipoDeTecnico, Date date) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Horario> returnable = new ArrayList<Horario>();
		String data= new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.horario where dataHorario >= '" + data + "'"
					+ " and idfuncionario in (select idfuncionario from"
					+ " dbAutOK.funcionario where tipofuncionario like '" + tipoDeTecnico + "')"
					+ " and ocupado = 0 order by dataHorario, horario "
					+ ";");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());
			
			HashSet<Integer> ids = new HashSet<Integer>();
			
			while(rs.next()) {
				
				if (ids.contains(rs.getInt("idfuncionario"))) continue;
				
				ids.add(rs.getInt("idfuncionario"));
				Horario horario = new Horario();
				horario.setIdFuncionario(rs.getInt("idfuncionario"));
				horario.setDate(rs.getDate("dataHorario"));
				horario.setHorarioLivre(rs.getInt("horario"));
				horario.setIdHorario(rs.getInt("id"));
				horario.setOcupado(rs.getInt("ocupado"));
				
				returnable.add(horario);
			}
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
		
		return returnable;
	}
	
	public void setHorariosOcupados(ArrayList<Integer> idsHorarios, boolean ocupado) {

		Connection conn = null;
		Statement stmt = null;
		
		int oc = ocupado? 1:0;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.horario ");
			sql.append("set ocupado = " + oc + " where id in (");
			for (Integer id: idsHorarios) {
				
				sql.append(id);
				if (idsHorarios.indexOf(id) < idsHorarios.size() - 1)
					sql.append(", ");
			}
			sql.append(");");
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
	
	public ArrayList<Integer> primeirosNHorariosLivresDeTecnico(int n, int idfuncionario) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> returnable = new ArrayList<Integer>();
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			String data= new SimpleDateFormat("yyyy-MM-dd").format(new Date());

			sql.append("select id from dbAutOK.horario ");
			sql.append("where idfuncionario = " + idfuncionario + " and ocupado = 0 and dataHorario >= '" + data + "'");
			sql.append(" order by dataHorario, horario ");
			sql.append("limit " + n + ";");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());
			
			while (rs.next()) {
				returnable.add(rs.getInt("id"));
			}
			
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
		
		return returnable;
	}

}
