package basedados.dao.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import basedados.BaseDadosException;
import basedados.dao.PedidoDao;
import bean.Pedido;
import utilidades.Log;

public class PedidoDaoJdbc extends ConectorDaoJdbc implements PedidoDao{

	public PedidoDaoJdbc() throws BaseDadosException {
		super();
	}

	@Override
	public boolean cadastrarPedido(int codigoCliente, int codigoMotorista, int codigoPedido, int codigoVeiculo,
			double peso, String tipoCarga, int riscoCarga, double distancia, boolean finalizado, String dataEntrega,
			String descricao) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("INSERT INTO Pedido (codigoCliente, codigoFuncionario, codigoPedido, codigoVeiculo, peso, tipoCarga, riscoCarga, distancia, finalizado, dataEntrega, descricao) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		try{
			pstmt.setInt(1, codigoCliente);
			pstmt.setInt(2, codigoMotorista);			
			pstmt.setInt(3, codigoPedido);
			pstmt.setInt(4, codigoVeiculo);
			pstmt.setDouble(5, peso);
			pstmt.setString(6, tipoCarga);			
			pstmt.setString(7, riscoCarga+"");
			pstmt.setDouble(8, distancia);
			pstmt.setBoolean(9, finalizado);
			pstmt.setString(10, dataEntrega);
			pstmt.setString(11, descricao);	
			pstmt.execute();
			fechaConexao();
			return true;
		} catch (SQLException e) {
			Log.gravaLog(e);
			throw new BaseDadosException("Erro ao setar os parâmetros da consulta.");
		}
	}

	@Override
	public List<Pedido> listaPedidos(int codigoMotorista) throws BaseDadosException {
		LinkedList<Pedido> pedidos = new LinkedList<Pedido>();
		abreConexao();
		preparaComandoSQL("select codigoPedido, finalizado, codigoCliente, codigoVeiculo from Pedido where codigoFuncionario=\""
				+ codigoMotorista + "\"");
		try{
			rs = pstmt.executeQuery();
			while(rs.next()){
				int codigoPedido = rs.getInt(1);
				boolean finalizado = rs.getBoolean(2);
				int codigoCliente = rs.getInt(3);
				int codigoVeiculo = rs.getInt(4);
				Pedido pedido = new Pedido(codigoPedido, finalizado, codigoCliente, codigoVeiculo);
				pedidos.add(pedido);
			}
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
		fechaConexao();
		return pedidos;
	}

	@Override
	public Pedido consultaPedido(int codigoPedido) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select peso,tipoCarga,riscoCarga,distancia,finalizado,dataEntrega from Pedido where codigoPedido =\""
				+ codigoPedido + "\"");
		try{
			rs = pstmt.executeQuery();
			if(rs.next()){
				Pedido pedido = new Pedido(rs.getBoolean("finalizado"), codigoPedido, rs.getDouble("peso"), 
						rs.getString("tipoCarga"), rs.getInt("riscoCarga"), rs.getDouble("distancia"), rs.getString("dataEntrega"));
				fechaConexao();
				return pedido;
			}
			fechaConexao();
			return null;
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
	}

	@Override
	public void updatePedido(boolean status, int codigoPedido) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("UPDATE Pedido set finalizado=? where codigoPedido=?");
		try{
			pstmt.setBoolean(1, status);
			pstmt.setInt(2, codigoPedido);
			boolean result = pstmt.execute();
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		} 

	}

	@Override
	public Pedido deletePedido(Pedido pedido) throws BaseDadosException {
    	abreConexao();
    	preparaComandoSQL("DELETE FROM Pedido WHERE codigoPedido=?");
    	try{
    		pstmt.setInt(1,pedido.getCodigoPedido());
    		pstmt.execute();
    	}catch(SQLException e){
    		Log.gravaLog(e);
    		throw new BaseDadosException("Erro ao setar os parâmetros da deleção");
    	}
    	fechaConexao();
    	return pedido;

	}

	@Override
	public double distanciaPedido(String data, int codigoFuncionario) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select sum(distancia) as total from Pedido where dataEntrega =\"" + data+ "\"  and codigoFuncionario = \"" + codigoFuncionario+ "\"");
		try{
			rs = pstmt.executeQuery();
			double distanciaTotal = 0;
			if(rs.next()){
				distanciaTotal = rs.getDouble(1);
			}
			fechaConexao();
			return distanciaTotal;
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}

	}

	@Override
	public boolean verificaUnicidadePedido(int codigoPedido) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select codigoPedido from Pedido where codigoPedido=?");
		try{
			pstmt.setInt(1, codigoPedido);
			rs = pstmt.executeQuery();
			rs.last();
			int countRow = rs.getRow();
			if(countRow == 1){
				fechaConexao();
				return false;
			}
			else{
				fechaConexao();
				return true;
			}		
		} catch(SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}

	}
	
}
