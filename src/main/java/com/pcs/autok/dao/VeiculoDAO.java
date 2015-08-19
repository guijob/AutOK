package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.TipoVeiculo;
import com.pcs.autok.model.Veiculo;
import com.pcs.autok.model.base.abstracts.Usuario;

public class VeiculoDAO extends ConnectionDAO {

	public void editarVeiculo(Veiculo veiculo) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.veiculo");
			sql.append(" set modeloveiculo = '" + veiculo.getModeloVeiculo()
					+ "', renavam = '" + veiculo.getRenavam() + "',fabricanteveiculo = '"
					+ veiculo.getFabVeiculo() + "', anoveiculo = '"
					+ veiculo.getFabAno() + "',quilometragem = "
					+ veiculo.getQuilometragem() + "idcliente = " 
					+ veiculo.getIdCliente() + ";");
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
	
	public void cadastrarVeiculo(Veiculo veiculo, TipoVeiculo tipoVeiculo) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.veiculo");
			sql.append(" values " + "(0, "
					+ veiculo.getFabAno() + ", "
					+ veiculo.getRenavam() + ", "
					+ tipoVeiculo.getIdTipoVeiculo() + ", "
					+ veiculo.getIdCliente() + ", '"
					+ veiculo.getPlacaVeiculo() + "', "
					+ veiculo.getQuilometragem() + ");");
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

	public boolean buscarRenavam(Veiculo veiculo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.veiculo where");
			sql.append(" renavam like '" + veiculo.getRenavam() + "';");
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
	
	public Veiculo buscarVeiculoPorIdVeiculo(Integer idVeiculo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Veiculo u = null;
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.veiculo where");
			sql.append(" idveiculo like " + idVeiculo + ";");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u = new Veiculo();
				u.setIdVeiculo(rs.getInt("idveiculo"));
				u.setIdCliente(rs.getInt("idcliente"));
				u.setModeloVeiculo(rs.getString("idtipo_veiculo"));
				u.setRenavam(rs.getString("renavam"));
				u.setFabAno(rs.getString("anofabricacao"));
				u.setQuilometragem(rs.getInt("quilometragem"));
				u.setPlacaVeiculo(rs.getString("placaveiculo"));
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
	
	public Veiculo buscarModelo(Veiculo veiculo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Veiculo u = null;
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.veiculo where");
			sql.append(" modeloveiculo like '" + veiculo.getModeloVeiculo() + "'"
					+ "and idcliente = " + veiculo.getIdCliente() + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u = new Veiculo();
				u.setIdVeiculo(rs.getInt("idveiculo"));
				u.setIdCliente(rs.getInt("idcliente"));
				u.setModeloVeiculo(rs.getString("modeloveiculo"));
				u.setRenavam(rs.getString("renavam"));
				u.setFabAno(rs.getString("anofabricacao"));
				u.setQuilometragem(rs.getInt("quilometragem"));
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
	
	public void excluirVeiculo(Veiculo veiculo) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.veiculo");
			sql.append(" where idveiculo like " + veiculo.getIdVeiculo() + ";");
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
	
	public boolean buscarVeiculos(Veiculo veiculo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
	
			sql.append("select * from dbAutOK.veiculo where");
			sql.append(" idcliente = " + veiculo.getIdCliente() + "';");
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
	
	public List<Veiculo> listarVeiculosPorIdUsuario(Usuario usuario) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dbAutOK.veiculo where");
			sql.append(" idcliente like " + usuario.getId() + ";");
			rs = stmt.executeQuery(sql.toString());

			Veiculo u = null;
			while (rs.next()) {
				u = new Veiculo();
				u.setIdVeiculo(rs.getInt("idveiculo"));
				u.setIdCliente(rs.getInt("idcliente"));
				u.setModeloVeiculo(rs.getString("idtipo_veiculo"));
				u.setRenavam(rs.getString("renavam"));
				u.setFabAno(rs.getString("anofabricacao"));
				u.setQuilometragem(rs.getInt("quilometragem"));
				u.setPlacaVeiculo(rs.getString("placaveiculo"));
				veiculos.add(u);
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
		return veiculos;
	}

	public List<Veiculo> listarTodos(Veiculo veiculo) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dbAutOK.veiculo where");
			sql.append(" idcliente like '" + veiculo.getIdCliente() + "';");
			rs = stmt.executeQuery(sql.toString());

			@SuppressWarnings("unused")
			Veiculo u = null;
			while (rs.next()) {
				u = new Veiculo();
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
		return veiculos;
	}

}
