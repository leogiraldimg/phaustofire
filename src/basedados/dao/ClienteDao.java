package basedados.dao;

import java.util.List;

import basedados.BaseDadosException;
import bean.Cliente;

public interface ClienteDao {
	boolean insereCliente(Cliente cliente) throws BaseDadosException;
	List<Cliente> listaClientes() throws BaseDadosException;
	Cliente consultaCliente(int codigoCliente) throws BaseDadosException;
	void updateCliente(String nome, String endereco, String complemento, String cep, String estado, String cidade,
			int codigoPessoa, String cnpj) throws BaseDadosException;
	void deleteCliente(int codigo) throws BaseDadosException;
}
