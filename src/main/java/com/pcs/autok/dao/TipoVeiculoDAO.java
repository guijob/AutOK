package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.TipoVeiculo;
import com.pcs.autok.model.Veiculo;

public class TipoVeiculoDAO extends ConnectionDAO {

	public List<TipoVeiculo> listarFabricantes() {
		List<TipoVeiculo> fabricantes = new ArrayList<TipoVeiculo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct marcatipo_veiculo from dbAutOK.tipo_veiculo;");
			rs = stmt.executeQuery(sql.toString());

			TipoVeiculo u = null;
			while (rs.next()) {
				u = new TipoVeiculo();
				u.setFabricante(rs.getString("marcatipo_veiculo"));
				fabricantes.add(u);
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
		return fabricantes;
	}
	
	public List<TipoVeiculo> listarModelos() {
		List<TipoVeiculo> modelos = new ArrayList<TipoVeiculo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dbAutOK.tipo_veiculo;");
			rs = stmt.executeQuery(sql.toString());

			TipoVeiculo u = null;
			
			while (rs.next()) {
				u = new TipoVeiculo();
				u.setModelo(rs.getString("modelotipo_veiculo"));
				u.setFabricante(rs.getString("marcatipo_veiculo"));
				u.setIdTipoVeiculo(rs.getInt("idtipo_veiculo"));
				modelos.add(u);
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
		return modelos;
	}
	
	public TipoVeiculo buscarTipoVeiculo(Veiculo veiculo) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		TipoVeiculo u = new TipoVeiculo();
		
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dbAutOK.tipo_veiculo where idtipo_veiculo like " + veiculo.getModeloVeiculo() + ";");
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u.setModelo(rs.getString("modelotipo_veiculo"));
				u.setFabricante(rs.getString("marcatipo_veiculo"));
				u.setIdTipoVeiculo(rs.getInt("idtipo_veiculo"));
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
}
