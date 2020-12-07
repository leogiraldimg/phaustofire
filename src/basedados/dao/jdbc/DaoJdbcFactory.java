package basedados.dao.jdbc;

import basedados.BaseDadosException;
import basedados.dao.DaoAbstractFactory;

public class DaoJdbcFactory implements DaoAbstractFactory{

	@Override
	public FuncionarioDaoJdbc createFuncionarioDao() throws BaseDadosException {
		return new FuncionarioDaoJdbc();
	}

	@Override
	public ClienteDaoJdbc createClienteDao() throws BaseDadosException {
		return new ClienteDaoJdbc();
	}

	@Override
	public PedidoDaoJdbc createPedidoDao() throws BaseDadosException {
		return new PedidoDaoJdbc();
	}

	@Override
	public VeiculoDaoJdbc createVeiculoDao() throws BaseDadosException {
		return new VeiculoDaoJdbc();
	}

}
