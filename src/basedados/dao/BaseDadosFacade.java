package basedados.dao;

import java.util.List;

import basedados.BaseDadosException;
import basedados.dao.jdbc.ClienteDaoJdbc;
import basedados.dao.jdbc.DaoJdbcFactory;
import basedados.dao.jdbc.FuncionarioDaoJdbc;
import basedados.dao.jdbc.PedidoDaoJdbc;
import basedados.dao.jdbc.ScriptCriacaoBD;
import basedados.dao.jdbc.VeiculoDaoJdbc;
import bean.Cliente;
import bean.Funcionario;
import bean.Motorista;
import bean.Pedido;
import bean.Veiculo;

public class BaseDadosFacade implements BaseDadosAbstractFacade{
	
	private FuncionarioDaoJdbc funcionarioDaoJdbc;
	private ClienteDaoJdbc clienteDaoJdbc;
	private VeiculoDaoJdbc veiculoDaoJdbc;
	private PedidoDaoJdbc pedidoDaoJdbc;
	
	public BaseDadosFacade() throws BaseDadosException{
		DaoAbstractFactory daoFactory = new DaoJdbcFactory();
		funcionarioDaoJdbc = daoFactory.createFuncionarioDao();
		pedidoDaoJdbc = daoFactory.createPedidoDao();
		clienteDaoJdbc = daoFactory.createClienteDao();
		veiculoDaoJdbc = daoFactory.createVeiculoDao();
		new ScriptCriacaoBD(pedidoDaoJdbc, funcionarioDaoJdbc, clienteDaoJdbc, veiculoDaoJdbc)
		.criaTabelasBD();
	}

	@Override
	public boolean existeUsuario(String login) throws BaseDadosException {
		return funcionarioDaoJdbc.existeUsuario(login);
	}

	@Override
	public boolean existeSenha(String senha, String login) throws BaseDadosException {
		return funcionarioDaoJdbc.existeSenha(senha, login);
	}

	@Override
	public boolean insereMotorista(Motorista motorista) throws BaseDadosException {
		return funcionarioDaoJdbc.insereMotorista(motorista);
	}

	@Override
	public boolean insereFuncionario(Funcionario funcionario) throws BaseDadosException {
		return funcionarioDaoJdbc.insereFuncionario(funcionario);
	}

	@Override
	public List<Funcionario> listaFuncionarios() throws BaseDadosException {
		return funcionarioDaoJdbc.listaFuncionarios();
	}

	@Override
	public Motorista consultaFuncionario(int codigoFuncionario) throws BaseDadosException {
		return funcionarioDaoJdbc.consultaFuncionario(codigoFuncionario);
	}

	@Override
	public void updateFuncionario(String nome, String endereco, String complemento, String cep, String estado,
			String cidade, String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta)
			throws BaseDadosException {
		funcionarioDaoJdbc.updateFuncionario(nome, endereco, complemento, cep, estado, cidade, cpf, 
				cargo, codigoPessoa, login, senha, tipoCarta);
	}

	@Override
	public void deleteMotorista(int codigo) throws BaseDadosException {
		funcionarioDaoJdbc.deleteMotorista(codigo);
	}

	@Override
	public boolean cadastrarPedido(int codigoCliente, int codigoMotorista, int codigoPedido, int codigoVeiculo,
			double peso, String tipoCarga, int riscoCarga, double distancia, boolean finalizado, String dataEntrega,
			String descricao) throws BaseDadosException {
		return pedidoDaoJdbc.cadastrarPedido(codigoCliente, codigoMotorista, codigoPedido, codigoVeiculo, peso, 
				tipoCarga, riscoCarga, distancia, finalizado, dataEntrega, descricao);
	}

	@Override
	public List<Pedido> listaPedidos(int codigoMotorista) throws BaseDadosException {
		return pedidoDaoJdbc.listaPedidos(codigoMotorista);
	}

	@Override
	public Pedido consultaPedido(int codigoPedido) throws BaseDadosException {
		return pedidoDaoJdbc.consultaPedido(codigoPedido);
	}

	@Override
	public void updatePedido(boolean status, int codigoPedido) throws BaseDadosException {
		pedidoDaoJdbc.updatePedido(status, codigoPedido);
	}

	@Override
	public Pedido deletePedido(Pedido pedido) throws BaseDadosException {
		return pedidoDaoJdbc.deletePedido(pedido);
	}

	@Override
	public double distanciaPedido(String data, int codigoFuncionario) throws BaseDadosException {
		return pedidoDaoJdbc.distanciaPedido(data, codigoFuncionario);
	}

	@Override
	public boolean verificaUnicidadePedido(int codigoPedido) throws BaseDadosException {
		return pedidoDaoJdbc.verificaUnicidadePedido(codigoPedido);
	}

	@Override
	public boolean insereVeiculo(Veiculo veiculo) throws BaseDadosException {
		return veiculoDaoJdbc.insereVeiculo(veiculo);
	}

	@Override
	public List<Veiculo> listaVeiculos() throws BaseDadosException {
		return veiculoDaoJdbc.listaVeiculos();
	}

	@Override
	public Veiculo consultaVeiculo(int codigoVeiculo) throws BaseDadosException {
		return veiculoDaoJdbc.consultaVeiculo(codigoVeiculo);
	}

	@Override
	public void updateVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo,
			String placa) throws BaseDadosException {
		veiculoDaoJdbc.updateVeiculo(marca, modelo, pesoMax, tipoVeiculo, codigoVeiculo, placa);
	}

	@Override
	public void deleteVeiculo(int codigo) throws BaseDadosException {
		veiculoDaoJdbc.deleteVeiculo(codigo);
	}

	@Override
	public boolean insereCliente(Cliente cliente) throws BaseDadosException {
		return clienteDaoJdbc.insereCliente(cliente);
	}

	@Override
	public List<Cliente> listaClientes() throws BaseDadosException {
		return clienteDaoJdbc.listaClientes();
	}

	@Override
	public Cliente consultaCliente(int codigoCliente) throws BaseDadosException {
		return clienteDaoJdbc.consultaCliente(codigoCliente);
	}

	@Override
	public void updateCliente(String nome, String endereco, String complemento, String cep, String estado,
			String cidade, int codigoPessoa, String cnpj) throws BaseDadosException {
		clienteDaoJdbc.updateCliente(nome, endereco, complemento, cep, estado, cidade, codigoPessoa, cnpj);
	}

	@Override
	public void deleteCliente(int codigo) throws BaseDadosException {
		clienteDaoJdbc.deleteCliente(codigo);
	}
	
}
