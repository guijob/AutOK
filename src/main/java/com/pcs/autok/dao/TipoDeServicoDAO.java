package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.OrdemDeServico;
import com.pcs.autok.model.TipoServico;

public class TipoDeServicoDAO extends ConnectionDAO {

	public List<TipoServico> listarTodos() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<TipoServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.tipo_servico");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				TipoServico tipo = new TipoServico();
				tipo.setId(rs.getInt("idtipo_servico"));
				tipo.setNome(rs.getString("nometipo_servico"));
				tipo.setDuracaoEmHoras(rs.getInt("duracaoHoras"));
				tipo.setPreco(rs.getFloat("preco"));
				returnable.add(tipo);

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

	public List<TipoServico> listarAlguns(ArrayList<Integer> ids) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<TipoServico> returnable = new ArrayList<>();

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.tipo_servico");
			sql.append(" where idtipo_servico in (");
			for (Integer id : ids) {
				sql.append(id);
				if (ids.indexOf(id) < ids.size() - 1)
					sql.append(", ");
			}
			sql.append(");");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				TipoServico tipo = new TipoServico();
				tipo.setId(rs.getInt("idtipo_servico"));
				tipo.setNome(rs.getString("nometipo_servico"));
				tipo.setDuracaoEmHoras(rs.getInt("duracaoHoras"));
				tipo.setPreco(rs.getFloat("preco"));
				returnable.add(tipo);

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
