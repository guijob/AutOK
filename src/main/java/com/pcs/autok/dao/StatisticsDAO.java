package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Estatisticas;

public class StatisticsDAO extends ConnectionDAO {


	public List<Estatisticas>  listarTotais() {
		List<Estatisticas> estatistica = new ArrayList<Estatisticas>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select sum(idveiculo) as 'veiculos' from dbAutOK.veiculo;");
			rs = stmt.executeQuery(sql.toString());

			Estatisticas s = null;
			s = new Estatisticas();
			if (rs.next()) {
				s.setqVeiculos(rs.getInt("veiculos"));
			}

			sql = new StringBuilder();
			sql.append("select sum(idcliente) as 'clientes' from dbAutOK.cliente;");
			rs = stmt.executeQuery(sql.toString());

			if (rs.next()) {
				s.setqClientes(rs.getInt("clientes"));
			}
			
			sql = new StringBuilder();
			sql.append("select sum(idordem_servico) as 'OSs' from dbAutOK.ordem_servico;");
			rs = stmt.executeQuery(sql.toString());

			if (rs.next()) {
				s.setqOS(rs.getInt("OSs"));
			}
			
			sql = new StringBuilder();
			sql.append("select sum(idfuncionario) as 'funcionarios' from dbAutOK.funcionario;");
			rs = stmt.executeQuery(sql.toString());

			if (rs.next()) {
				s.setqFuncionarios(rs.getInt("funcionarios"));
				estatistica.add(s);
			}

			sql = new StringBuilder();
			sql.append("select sum(idtipo_servico) as 'servicos' from dbAutOK.tipo_servico;");
			rs = stmt.executeQuery(sql.toString());

			if (rs.next()) {
				s.setqServicos(rs.getInt("servicos"));
			}

			estatistica.add(s);
			
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
		return estatistica;
	}

}
