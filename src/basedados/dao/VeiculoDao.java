package basedados.dao;

import java.util.List;

import basedados.BaseDadosException;
import bean.Veiculo;

public interface VeiculoDao {
	boolean insereVeiculo(Veiculo veiculo) throws BaseDadosException;
	List<Veiculo> listaVeiculos() throws BaseDadosException;
	Veiculo consultaVeiculo(int codigoVeiculo) throws BaseDadosException;
	void updateVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo,
			String placa) throws BaseDadosException;
	void deleteVeiculo(int codigo) throws BaseDadosException;
}
