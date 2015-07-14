package com.pcs.autok.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.base.SuperDAO;
import com.pcs.autok.model.TipoPeca;

public class TipoPecasDAO extends SuperDAO {

	public void editarTipoPecas(TipoPeca tipoPeca) {

		StringBuilder sql = new StringBuilder();

		sql.append("update dbAutOK.cliente");
		sql.append(" set desc_tipo_peca = '" + tipoPeca.getDescrPeca() + "';");
		System.out.println(sql.toString());

		executeQueryCRUD(sql.toString());
	}
	
	public void cadastrarTipoPecas(TipoPeca tipoPeca) {

		StringBuilder sql = new StringBuilder();

		sql.append("insert into dbAutOK.tipo_pecas");
		sql.append(" values " + "(0, " + "'" + tipoPeca.getDescrPeca() + "');");
		System.out.println(sql.toString());

		executeQueryCRUD(sql.toString());
	}
	
	public void excluirTipoPeca(TipoPeca tipoPeca) {

		StringBuilder sql = new StringBuilder();

		sql.append("delete from dbAutOK.cliente");
		sql.append(" where desc_tipo_peca = '" + tipoPeca.getDescrPeca() + "';");
		System.out.println(sql.toString());

		executeQueryCRUD(sql.toString());
	}
	
	public List<TipoPeca> listarTipoPecas() throws SQLException {
		ResultSet rs = null;
		List<TipoPeca> u = new ArrayList<TipoPeca>();
		StringBuilder sql = new StringBuilder();
			
		sql.append("select * from dbAutOK.tipo_pecas;");
		rs = executeQueryCRUD(sql.toString());
		TipoPeca o;
			
		while (rs.next()) {
			o = new TipoPeca();
			o.setDescrPeca(rs.getString("desctipo_pecas"));
			u.add(o);
		}
		
		return u;
	}
}