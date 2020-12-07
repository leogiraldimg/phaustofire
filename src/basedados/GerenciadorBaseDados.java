package basedados;
import java.util.LinkedList;
import java.util.List;

import bean.Cliente;
import bean.Funcionario;
import bean.Motorista;
import bean.Pedido;
import bean.Pessoa;
import bean.Veiculo;
import negocio.NegocioException;

public interface GerenciadorBaseDados {

	boolean existeUsuario(String login) throws BaseDadosException;
	
	boolean existeSenha(String senha, String login) throws BaseDadosException;
	
	boolean insereCliente(Cliente cliente) throws BaseDadosException;
	
	boolean insereMotorista(Motorista motorista) throws BaseDadosException;
	
	boolean insereVeiculo(Veiculo veiculo) throws BaseDadosException;
	
	boolean insereFuncionario(Funcionario funcionario) throws BaseDadosException;
	
	List<Funcionario> listaFuncionarios() throws BaseDadosException;
	
	List<Cliente> listaClientes() throws BaseDadosException;
	
	List<Veiculo> listaVeiculos() throws BaseDadosException;
	
	Motorista consultaFuncionario(int codigoFuncionario) throws BaseDadosException;
	
	Cliente consultaCliente(int codigoCliente) throws BaseDadosException;
	
	Veiculo consultaVeiculo(int codigoVeiculo) throws BaseDadosException;
	
	void updateFuncionario(String nome, String endereco, String complemento, String cep, String estado, String cidade,
			String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta) throws BaseDadosException;
	
	void updateCliente(String nome, String endereco, String complemento, String cep, String estado, String cidade,
			int codigoPessoa, String cnpj) throws BaseDadosException;

	void updateVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo,
			String placa) throws BaseDadosException;

	void deleteMotorista(int codigo)  throws BaseDadosException;

	void deleteCliente(int codigo) throws BaseDadosException;

	void deleteVeiculo(int codigo) throws BaseDadosException;

	boolean cadastrarPedido(int codigoCliente, int codigoMotorista, int codigoPedido, int codigoVeiculo, double peso,
			String tipoCarga, int riscoCarga, double distancia, boolean finalizado, String dataEntrega,
			String descricao) throws BaseDadosException;

	List<Pedido> listaPedidos(int codigoMotorista) throws BaseDadosException;

	Pedido consultaPedido(int codigoPedido) throws BaseDadosException;

	void updatePedido(boolean status, int codigoPedido) throws BaseDadosException;

	Pedido deletePedido(Pedido pedido) throws BaseDadosException;

	double distanciaPedido(String data, int codigoFuncionario) throws BaseDadosException;

	boolean verificaUnicidadePedido(int codigoPedido) throws BaseDadosException;
}
