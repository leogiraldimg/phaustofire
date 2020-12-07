package basedados.dao.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import basedados.BaseDadosException;
import basedados.dao.VeiculoDao;
import bean.Veiculo;
import utilidades.Log;

public class VeiculoDaoJdbc extends ConectorDaoJdbc implements VeiculoDao{

	public VeiculoDaoJdbc() throws BaseDadosException {
		super();
	}

	@Override
	public boolean insereVeiculo(Veiculo veiculo) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("INSERT INTO Veiculo(codigoVeiculo, marca, modelo, pesoMax, tipoVeiculo, placa) VALUES (?,?,?,?,?,?)");
		try{
			pstmt.setInt(1, veiculo.getCodigoVeiculo());
			pstmt.setString(2, veiculo.getMarca());
			pstmt.setString(3, veiculo.getModelo());
			pstmt.setDouble(4, veiculo.getPesoMax());
			pstmt.setString(5, veiculo.getTipoVeiculo());
			pstmt.setString(6, veiculo.getPlaca());
			boolean result = pstmt.execute();
			fechaConexao();
			return true;
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Erro ao setar os parâmetros da consulta.");
		}
	}

	@Override
	public List<Veiculo> listaVeiculos() throws BaseDadosException {
		LinkedList<Veiculo> veiculos = new LinkedList<Veiculo>();
		abreConexao();
		preparaComandoSQL("select placa, tipoVeiculo, modelo from Veiculo");
		try{
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					String placa  = rs.getString(1);
					String tipoVeiculo = rs.getString(2);
					String modelo = rs.getString(3);
					Veiculo veiculo = new Veiculo(placa, tipoVeiculo, modelo);
					veiculos.add(veiculo);
				}
			}
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
		fechaConexao();
		return veiculos;
	}

	@Override
	public Veiculo consultaVeiculo(int codigoVeiculo) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select codigoVeiculo, marca, modelo, pesoMax, tipoVeiculo, placa from Veiculo where codigoVeiculo =\""
				+ codigoVeiculo + "\"");
		try{
			rs = pstmt.executeQuery();
			if(rs.next()){
				Veiculo veiculo = new Veiculo(rs.getString("marca"), rs.getString("modelo"), rs.getDouble("pesoMax"), rs.getString("tipoVeiculo"),
						rs.getInt("codigoVeiculo"),rs.getString("placa"));
				fechaConexao();
				return veiculo;
			}
			fechaConexao();
			return null;
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
	}

	@Override
	public void updateVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo,
			String placa) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("UPDATE Veiculo set marca=?, modelo=?, pesoMax=?, tipoVeiculo=?, placa=? where codigoVeiculo=?");
		try{
			pstmt.setString(1, marca);
			pstmt.setString(2, modelo);
			pstmt.setDouble(3, pesoMax);
			pstmt.setString(4, tipoVeiculo);
			pstmt.setString(5, placa);
			pstmt.setInt(6, codigoVeiculo);
			boolean result = pstmt.execute();
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas as ler o resultado da consulta");
		}
		fechaConexao();
	}

	@Override
	public void deleteVeiculo(int codigo) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("DELETE FROM Veiculo WHERE codigoVeiculo=?");
		try{
			pstmt.setInt(1, codigo);
			boolean result = pstmt.execute();
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas as ler o resultado da consulta");
		}
		fechaConexao();	
	}
}
