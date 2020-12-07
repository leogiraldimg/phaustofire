package basedados.dao.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import basedados.BaseDadosException;
import basedados.dao.ClienteDao;
import basedados.dao.FuncionarioDao;
import bean.Cliente;
import utilidades.Log;

public class ClienteDaoJdbc extends ConectorDaoJdbc implements ClienteDao{

	public ClienteDaoJdbc() throws BaseDadosException {
		super();
	}

	@Override
	public boolean insereCliente(Cliente cliente) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("INSERT INTO Cliente (codigoCliente, nome, endereco, complemento, cep, estado, cidade, cnpj) VALUES (?,?,?,?,?,?,?,?)");
		try{
			pstmt.setInt(1, cliente.getCodigopessoa());
			pstmt.setString(2, cliente.getNome());
			pstmt.setString(3, cliente.getEndereco());
			pstmt.setString(4, cliente.getComplemento());
			pstmt.setString(5, cliente.getCep());
			pstmt.setString(6, cliente.getEstado());
			pstmt.setString(7, cliente.getCidade());
			pstmt.setString(8, cliente.getCnpj());
			boolean result = pstmt.execute();
			fechaConexao();
			return true;
		} catch (SQLException e) {
			Log.gravaLog(e);
			throw new BaseDadosException("Erro ao setar os parâmetros da consulta.");
		}
	}

	@Override
	public List<Cliente> listaClientes() throws BaseDadosException {
		LinkedList<Cliente> clientes = new LinkedList<Cliente>();
		abreConexao();
		preparaComandoSQL("select codigoCliente, nome, cnpj from Cliente");
		try{
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					int codigoCliente = rs.getInt(1);
					String nome = rs.getString(2);
					String cnpj = rs.getString(3);
					Cliente cliente = new Cliente(codigoCliente, nome, cnpj);
					clientes.add(cliente);
				}
			}
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
		fechaConexao();
		return clientes;
	}

	@Override
	public Cliente consultaCliente(int codigoCliente) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select codigoCliente, nome, endereco, complemento, cep, estado, cidade, cnpj from Cliente where codigoCliente =\""
				+ codigoCliente + "\"");
		try{
			rs = pstmt.executeQuery();
			if(rs.next()){
				Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("endereco"), rs.getString("complemento"), rs.getString("cep"), 
						rs.getString("estado"), rs.getString("cidade"), rs.getInt("codigoCliente"), rs.getString("cnpj"));
				fechaConexao();
				return cliente;
			}
			fechaConexao();
			return null;
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
	}

	@Override
	public void updateCliente(String nome, String endereco, String complemento, String cep, String estado,
			String cidade, int codigoPessoa, String cnpj) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("UPDATE Cliente set nome=?, endereco=?, complemento=?, cep=?, estado=?, cidade=?, cnpj=? where codigoCliente=?");
		try{
			pstmt.setString(1, nome);
			pstmt.setString(2, endereco);
			pstmt.setString(3, complemento);
			pstmt.setString(4, cep);
			pstmt.setString(5, estado);
			pstmt.setString(6, cidade);
			pstmt.setString(7, cnpj);
			pstmt.setInt(8, codigoPessoa);
			boolean result = pstmt.execute();
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas as ler o resultado da consulta");
		}
		fechaConexao();
	}

	@Override
	public void deleteCliente(int codigo) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("DELETE FROM Cliente WHERE codigoCliente=?");
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
