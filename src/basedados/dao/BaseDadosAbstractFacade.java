package basedados.dao;

import java.util.List;

import basedados.BaseDadosException;
import bean.Cliente;
import bean.Funcionario;
import bean.Motorista;
import bean.Pedido;
import bean.Veiculo;

public interface BaseDadosAbstractFacade {
	// funcionario
	public boolean existeUsuario(String login) throws BaseDadosException;
	public boolean existeSenha(String senha, String login) throws BaseDadosException;
	public boolean insereMotorista(Motorista motorista) throws BaseDadosException;
	public boolean insereFuncionario(Funcionario funcionario) throws BaseDadosException;
	public List<Funcionario> listaFuncionarios() throws BaseDadosException;
	public Motorista consultaFuncionario(int codigoFuncionario) throws BaseDadosException;
	public void updateFuncionario(String nome, String endereco, String complemento, String cep, String estado,
			String cidade, String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta)
			throws BaseDadosException;
	public void deleteMotorista(int codigo) throws BaseDadosException;
	
	// pedido
	public boolean cadastrarPedido(int codigoCliente, int codigoMotorista, int codigoPedido, int codigoVeiculo,
			double peso, String tipoCarga, int riscoCarga, double distancia, boolean finalizado, String dataEntrega,
			String descricao) throws BaseDadosException;
	public List<Pedido> listaPedidos(int codigoMotorista) throws BaseDadosException;
	public Pedido consultaPedido(int codigoPedido) throws BaseDadosException;
	public void updatePedido(boolean status, int codigoPedido) throws BaseDadosException;
	public Pedido deletePedido(Pedido pedido) throws BaseDadosException;
	public double distanciaPedido(String data, int codigoFuncionario) throws BaseDadosException;
	public boolean verificaUnicidadePedido(int codigoPedido) throws BaseDadosException;
	
	// veiculo
	public boolean insereVeiculo(Veiculo veiculo) throws BaseDadosException;
	public List<Veiculo> listaVeiculos() throws BaseDadosException;
	public Veiculo consultaVeiculo(int codigoVeiculo) throws BaseDadosException;
	public void updateVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo,
			String placa) throws BaseDadosException;
	public void deleteVeiculo(int codigo) throws BaseDadosException;
	
	//cliente
	public boolean insereCliente(Cliente cliente) throws BaseDadosException;
	public List<Cliente> listaClientes() throws BaseDadosException;
	public Cliente consultaCliente(int codigoCliente) throws BaseDadosException;
	public void updateCliente(String nome, String endereco, String complemento, String cep, String estado,
			String cidade, int codigoPessoa, String cnpj) throws BaseDadosException;
	public void deleteCliente(int codigo) throws BaseDadosException;
}
