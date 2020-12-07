package basedados.dao;

import java.util.List;

import basedados.BaseDadosException;
import bean.Pedido;

public interface PedidoDao {
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