package basedados.dao.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import basedados.BaseDadosException;
import basedados.dao.FuncionarioDao;
import bean.Funcionario;
import bean.Motorista;
import bean.Usuario;
import utilidades.Log;

public class FuncionarioDaoJdbc extends ConectorDaoJdbc implements FuncionarioDao{

	public FuncionarioDaoJdbc() throws BaseDadosException {
		super();
	}

	@Override
	public boolean existeUsuario(String login) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select codigoFuncionario, login, cargo from Funcionario where login=\""
				+ login + "\"");
		try {
			rs = pstmt.executeQuery();
			rs.last();
			int countRow = rs.getRow();
			if(countRow == 1) {
				Usuario.setCargo(rs.getString(3));
				fechaConexao();
				return true;
			}
			else{
				fechaConexao();
				return false;
			}
		} catch (SQLException e) {
			Log.gravaLog(e);
			throw new BaseDadosException(
					"Problemas ao ler o resultado da consulta.");
		}
	
	}

	@Override
	public boolean existeSenha(String senha, String login) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select codigoFuncionario, login from Funcionario where senha=\""
				+ senha + "\" AND login=\"" + login + "\"");
		try{
			rs = pstmt.executeQuery();
			rs.last();
			int countRow = rs.getRow();
			if(countRow == 1){
				fechaConexao();
				return true;
			}
			else{
				fechaConexao();
				return false;
			}			
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
	}

	@Override
	public boolean insereMotorista(Motorista motorista) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("INSERT INTO Funcionario (codigoFuncionario, nome, login, senha, endereco, complemento, cep, estado, cidade, cpf, "
				+ "cargo, carta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		try{
			pstmt.setInt(1, motorista.getCodigopessoa());
			pstmt.setString(2, motorista.getNome());
			pstmt.setString(3, motorista.getLogin());
			pstmt.setString(4, motorista.getSenha());
			pstmt.setString(5, motorista.getEndereco());
			pstmt.setString(6, motorista.getComplemento());
			pstmt.setString(7, motorista.getCep());
			pstmt.setString(8, motorista.getEstado());
			pstmt.setString(9, motorista.getCidade());
			pstmt.setString(10, motorista.getCpf());
			pstmt.setString(11, motorista.getCargo());
			pstmt.setString(12, motorista.getTipoCarta());
			boolean result = pstmt.execute();
			fechaConexao();
			return true;
		} catch(SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Erro ao setar os parâmetros da consulta.");
		}

	}

	@Override
	public boolean insereFuncionario(Funcionario funcionario) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("INSERT INTO Funcionario (codigoFuncionario, nome, login, senha, endereco, complemento, cep, estado, cidade, cpf, "
				+ "cargo) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		try{
			pstmt.setInt(1, funcionario.getCodigopessoa());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setString(3, funcionario.getLogin());
			pstmt.setString(4, funcionario.getSenha());
			pstmt.setString(5, funcionario.getEndereco());
			pstmt.setString(6, funcionario.getComplemento());
			pstmt.setString(7, funcionario.getCep());
			pstmt.setString(8, funcionario.getEstado());
			pstmt.setString(9, funcionario.getCidade());
			pstmt.setString(10, funcionario.getCpf());
			pstmt.setString(11, funcionario.getCargo());
			boolean result = pstmt.execute();
			fechaConexao();
			return true;
		} catch(SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Erro ao setar os parâmetros da consulta.");
		}

	}

	@Override
	public List<Funcionario> listaFuncionarios() throws BaseDadosException {
		LinkedList<Funcionario> funcionarios = new LinkedList<Funcionario>();
		abreConexao();
		preparaComandoSQL("select codigoFuncionario, nome, cargo from Funcionario");
		try{
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					int codigoFuncionario = rs.getInt(1);
					String nome = rs.getString(2);
					String cargo = rs.getString(3);
					Funcionario funcionario = new Funcionario(codigoFuncionario, nome, cargo);
					funcionarios.add(funcionario);
				}
			}
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}
		fechaConexao();
		return funcionarios;

	}

	@Override
	public Motorista consultaFuncionario(int codigoFuncionario) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("select nome, endereco, complemento, cep, estado, cidade, cpf, cargo, login, senha, carta from Funcionario where codigoFuncionario =\""
				+ codigoFuncionario + "\"");
		try{
			rs = pstmt.executeQuery();
			if(rs.next()){
				Motorista motorista = new Motorista(rs.getString("nome"), rs.getString("endereco"), rs.getString("complemento"), rs.getString("cep"), 
						rs.getString("estado"), rs.getString("cidade"), rs.getString("cpf"), rs.getString("cargo"), codigoFuncionario, 
						rs.getString("login"), rs.getString("senha"), rs.getString("carta"));
				fechaConexao();
				return motorista;
			}
			fechaConexao();
			return null;
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas ao ler o resultado da consulta.");
		}

	}

	@Override
	public void updateFuncionario(String nome, String endereco, String complemento, String cep, String estado,
			String cidade, String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta)
			throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("UPDATE Funcionario set nome=?, login=?, senha=? , endereco=?,complemento=?, cep=?, estado=?, cidade=?, cpf=?, cargo=?, carta=? where codigoFuncionario=?");
		try{
			pstmt.setString(1, nome);
			pstmt.setString(2, login);
			pstmt.setString(3, senha);
			pstmt.setString(4, endereco);
			pstmt.setString(5, complemento);
			pstmt.setString(6, cep);
			pstmt.setString(7, estado);
			pstmt.setString(8, cidade);
			pstmt.setString(9, cpf);
			pstmt.setString(10, cargo);
			pstmt.setString(11, tipoCarta);
			pstmt.setInt(12, codigoPessoa);			
			boolean result = pstmt.execute();
		} catch (SQLException e){
			Log.gravaLog(e);
			throw new BaseDadosException("Problemas as ler o resultado da consulta");
		}
		fechaConexao();

		
	}

	@Override
	public void deleteMotorista(int codigo) throws BaseDadosException {
		abreConexao();
		preparaComandoSQL("DELETE FROM Funcionario WHERE codigoFuncionario=?");
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
