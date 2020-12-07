package basedados.dao;

import basedados.BaseDadosException;
import basedados.dao.jdbc.ClienteDaoJdbc;
import basedados.dao.jdbc.FuncionarioDaoJdbc;
import basedados.dao.jdbc.PedidoDaoJdbc;
import basedados.dao.jdbc.VeiculoDaoJdbc;

public interface DaoAbstractFactory {
	public FuncionarioDaoJdbc createFuncionarioDao() throws BaseDadosException;
	public ClienteDaoJdbc createClienteDao() throws BaseDadosException;
	public PedidoDaoJdbc createPedidoDao() throws BaseDadosException;
	public VeiculoDaoJdbc createVeiculoDao() throws BaseDadosException;
}
