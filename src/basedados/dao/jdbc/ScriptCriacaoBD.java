package basedados.dao.jdbc;

import java.sql.SQLException;

import basedados.BaseDadosException;
import basedados.dao.ClienteDao;
import basedados.dao.FuncionarioDao;
import basedados.dao.PedidoDao;
import basedados.dao.VeiculoDao;
import bean.Cliente;
import bean.Funcionario;
import bean.Motorista;
import bean.Veiculo;
import utilidades.Log;

public class ScriptCriacaoBD extends ConectorDaoJdbc{
	
	private PedidoDao pedidoDao;
	private FuncionarioDao funcionarioDao;
	private ClienteDao clienteDao;
	private VeiculoDao veiculoDao;
	
	public void criaTabelasBD() throws BaseDadosException {
		try {
			criaBancoDeDados();
			criaTabelaCliente();
			criaTabelaFuncionario();
			criaTabelaVeiculo();
			criaTabelaPedido();
			populaTabelas();
		} catch (SQLException e) {
			Log.gravaLog(e);
			throw new BaseDadosException(
					"Erro ao tentar criar o banco de dados.");
		}
	}

	public ScriptCriacaoBD(PedidoDao pedidoDao, FuncionarioDao funcionarioDao, ClienteDao clienteDao,
			VeiculoDao veiculoDao) throws BaseDadosException {
		super();
		this.pedidoDao = pedidoDao;
		this.funcionarioDao = funcionarioDao;
		this.clienteDao = clienteDao;
		this.veiculoDao = veiculoDao;
	}
	
	private void criaBancoDeDados() throws SQLException, BaseDadosException {
		abreConexao();
		jaCriouBD = true;
		preparaComandoSQL("create database if not exists PhaustoFire");
		pstmt.execute();
		fechaConexao();
	}
	
	private void criaTabelaCliente() throws SQLException, BaseDadosException {
		abreConexao();
		preparaComandoSQL("create table if not exists Cliente ("
				+ "codigoCliente int unsigned NOT NULL PRIMARY KEY,"
				+ "nome varchar(100) NOT NULL,"
				+ "endereco varchar(150) NOT NULL,"
				+ "complemento varchar(20),"
				+ "cep varchar(8) NOT NULL,"
				+ "estado varchar(2) NOT NULL,"
				+ "cidade varchar(50) NOT NULL,"
				+ "cnpj varchar(15) NOT NULL)");
		pstmt.execute();
		fechaConexao();
	}
	
	private void criaTabelaFuncionario() throws SQLException, BaseDadosException {
		abreConexao();
		preparaComandoSQL("create table if not exists Funcionario ("
				+ "codigoFuncionario int unsigned NOT NULL PRIMARY KEY,"
				+ "nome varchar(100) NOT NULL,"
				+ "login varchar(30) NOT NULL,"
				+ "senha varchar(20) NOT NULL,"
				+ "endereco varchar(150) NOT NULL,"
				+ "complemento varchar(20),"
				+ "cep varchar(8) NOT NULL,"
				+ "estado varchar(2) NOT NULL,"
				+ "cidade varchar(50) NOT NULL,"
				+ "cpf varchar(11) NOT NULL,"
				+ "cargo varchar(20) NOT NULL,"
				+ "carta varchar(1))");
		pstmt.execute();
		fechaConexao();
	}
	
	private void criaTabelaVeiculo() throws SQLException, BaseDadosException {
		abreConexao();
		preparaComandoSQL("create table if not exists Veiculo ("
				+ "codigoVeiculo int unsigned NOT NULL PRIMARY KEY,"
				+ "marca varchar(30) NOT NULL,"
				+ "modelo varchar(30) NOT NULL,"
				+ "pesoMax float unsigned NOT NULL,"
				+ "tipoVeiculo varchar(20) NOT NULL,"
				+ "placa varchar(7) NOT NULL)");
		pstmt.execute();
		fechaConexao();
	}
	
	private void criaTabelaPedido() throws SQLException, BaseDadosException {
		abreConexao();
		preparaComandoSQL("create table if not exists Pedido ("
				+ "codigoPedido int unsigned NOT NULL PRIMARY KEY,"
				+ "peso float NOT NULL,"
				+ "tipoCarga varchar(25) NOT NULL,"
				+ "riscoCarga varchar(25) NOT NULL,"
				+ "distancia float NOT NULL,"
				+ "finalizado boolean NOT NULL,"
				+ "codigoCliente int unsigned NOT NULL,"
				+ "codigoFuncionario int unsigned NOT NULL,"
				+ "codigoVeiculo int unsigned NOT NULL,"
				+ "dataEntrega varchar(8) NOT NULL,"
				+ "descricao varchar(100) NOT NULL,"
				+ "constraint fk_Pedido_Cliente FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigoCliente),"
				+ "constraint fk_Pedido_Funcionario FOREIGN KEY (codigoFuncionario) REFERENCES Funcionario(codigoFuncionario),"
				+ "constraint fk_Pedido_Veiculo FOREIGN KEY (codigoVeiculo) REFERENCES Veiculo(codigoVeiculo))");
		pstmt.execute();
		fechaConexao();
	}
	
	public boolean existeFuncionario(int codigo) throws BaseDadosException {//verifica se existe usuario
		abreConexao();
		preparaComandoSQL("select * from Funcionario where codigoFuncionario=" + codigo);
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fechaConexao();
				return true;
			}
			fechaConexao();
			return false;
		} catch (SQLException e) {
			Log.gravaLog(e);
			throw new BaseDadosException(
					"Problemas ao ler o resultado da consulta.");
		}
	}
	
	private void populaTabelas() throws BaseDadosException {
		if(existeFuncionario(1)) {//se não existir registro, vai popular o banco
			return;
		}
		
		funcionarioDao.insereMotorista(new Motorista("José de Alcantara", "Rua do Tiro ao Pombo, 18", "apto 32", "02566480", "SP", "São Paulo", "85195774072", "Motorista", 1, "jose", "123", "B"));
		funcionarioDao.insereMotorista(new Motorista("Pafuncio Figueredo", "Rua Serra do Cachimbo, 66", "", "52074123", "SP", "Sertãozinho", "60933580037", "Motorista", 2, "moto", "123", "C"));
		clienteDao.insereCliente(new Cliente("Empresa A ltda", "Rua Cravo e Rosa, 567", "", "48652154", "SP", "São Paulo", 1, "22615113000134"));
		clienteDao.insereCliente(new Cliente("Empresa B S/A", "Rua Emanoel Almeida, 65", "Bloco D", "05412746", "SP", "São Paulo", 2, "65368215000105"));
		veiculoDao.insereVeiculo(new Veiculo("Mercedes", "MB13", 600, "Van", 1, "CNS4563"));//arrumar pesos dos veiculos de acordo com regras de negocio
		veiculoDao.insereVeiculo(new Veiculo("Volkswagen", "VW560", 150, "Caminhão 2 Eixos", 2, "DDG5067"));
		funcionarioDao.insereFuncionario(new Funcionario("Alberto de Souza", "Rua Albion, 51", "apto 41", "36205078", "SP", "SãoPaulo", 5, "58806797050", "Gerente", "admin", "123"));//verificar nomes dos cargos, se estão corretos
		funcionarioDao.insereFuncionario(new Funcionario("Amélia Santos", "Rua Clélia, 45", "", "65047684", "SP", "São Paulo", 6, "37610715077", "Recursos Humanos", "rh", "123"));
		pedidoDao.cadastrarPedido(1,1,1,1,50,"Sólida - Grãos", 2,99,false,"10052019","soja");
		pedidoDao.cadastrarPedido(2,2,2,2,60,"Sólida - Frágil", 1,99,false,"10052020","bomba");
	}
	
}
