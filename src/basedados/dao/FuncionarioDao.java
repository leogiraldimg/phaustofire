package basedados.dao;

import java.util.List;

import basedados.BaseDadosException;
import bean.Funcionario;
import bean.Motorista;

public interface FuncionarioDao {
	
	public boolean existeUsuario(String login) throws BaseDadosException;	
	public boolean existeSenha(String senha, String login) throws BaseDadosException;	
	boolean insereMotorista(Motorista motorista) throws BaseDadosException;	
	boolean insereFuncionario(Funcionario funcionario) throws BaseDadosException;	
	List<Funcionario> listaFuncionarios() throws BaseDadosException;	
	Motorista consultaFuncionario(int codigoFuncionario) throws BaseDadosException;	
	void updateFuncionario(String nome, String endereco, String complemento, String cep, String estado, String cidade,
			String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta) throws BaseDadosException;	
	void deleteMotorista(int codigo)  throws BaseDadosException;
}
