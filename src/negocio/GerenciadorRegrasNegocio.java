package negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import basedados.BaseDadosException;
import basedados.dao.BaseDadosFacade;
import bean.Cliente;
import bean.Funcionario;
import bean.Motorista;
import bean.Pedido;
import bean.Veiculo;
import utilidades.Log;

public class GerenciadorRegrasNegocio {
	
	private BaseDadosFacade facade;

	public enum BaseDados {
		RAM, JDBC;
	}

	private BaseDados bd;

	public GerenciadorRegrasNegocio(BaseDados bd) throws NegocioException {
		this.bd = bd;
		if (this.bd == BaseDados.JDBC) {
			try {
				facade = new BaseDadosFacade();
			} catch (BaseDadosException e) {
				throw new NegocioException(e);
			}
		} else {
			throw new NegocioException("Problemas no acesso à base de dados");
		}
    }
	
	public boolean existeUsuario(String login) throws NegocioException {
		try {
			return facade.existeUsuario(login);
		} catch (BaseDadosException e) {
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}
	
	public boolean existeSenha(String senha, String login) throws NegocioException{
		try{
			return facade.existeSenha(senha, login);
		} catch(BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados");
		}
	}
    
	public boolean cadastraCliente(String nome, String endereco, String complemento, 
			String cep, String estado, String cidade, int codigoPessoa,String cnpj) throws NegocioException{
		
		Cliente cliente = new Cliente(nome, endereco, complemento, cep, estado, cidade, codigoPessoa, cnpj);
		try {
			return facade.insereCliente(cliente);
		} catch (BaseDadosException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean cadastraMotorista(String nome, String endereco, String complemento, String cep, 
		    String estado, String cidade, String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta) throws NegocioException {
		Motorista motorista = new Motorista(nome, endereco, complemento, cep, estado, cidade, cpf, cargo, codigoPessoa, login,
				senha, tipoCarta);
		try {
			return facade.insereMotorista(motorista);
		} catch (BaseDadosException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean cadastraVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo, String placa) throws NegocioException{
		Veiculo veiculo = new Veiculo(marca, modelo, pesoMax, tipoVeiculo, codigoVeiculo, placa);
		try {
			return facade.insereVeiculo(veiculo);
		} catch (BaseDadosException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean cadastraFuncionario(String nome, String endereco, String complemento, String cep, 
		    String estado, String cidade, int codigoPessoa, String cpf, String cargo, String login, String senha) throws NegocioException{
		Funcionario funcionario = new Funcionario(nome, endereco, complemento, cep, estado, cidade, codigoPessoa, cpf, cargo, login, senha);
		try {
			return facade.insereFuncionario(funcionario);
		} catch (BaseDadosException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Funcionario> listaFuncionarios() throws NegocioException{
		try{
			return facade.listaFuncionarios();
		} catch (BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}
	public List<Cliente> listaClientes() throws NegocioException{
		try{
			return facade.listaClientes();
		} catch (BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}

	public List<Veiculo> listaVeiculos() throws NegocioException{
		try{
			return facade.listaVeiculos();
		} catch (BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}
	
	public Motorista consultaFuncionario(int codigoFuncionario) throws NegocioException{
		try{
			return facade.consultaFuncionario(codigoFuncionario);
		} catch(BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}

	public Cliente consultaCliente(int codigoCliente)  throws NegocioException{
		try{
			return facade.consultaCliente(codigoCliente);
		} catch(BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}

	public Veiculo consultaVeiculo(int codigoVeiculo) throws NegocioException{
		try{
			return facade.consultaVeiculo(codigoVeiculo);
		} catch(BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}

	public void updateFuncionario(String nome, String endereco, String complemento, String cep, 
		    String estado, String cidade, String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta) throws NegocioException{
		try {
			facade.updateFuncionario(nome,endereco,complemento,cep,estado,cidade,cpf,cargo,codigoPessoa,login,senha,tipoCarta);
		} catch (BaseDadosException e) {
			e.printStackTrace();
		}
	}

	public void updateCliente(String nome, String endereco, String complemento, 
			String cep, String estado, String cidade, int codigoPessoa,String cnpj)  throws NegocioException{
		try{
			facade.updateCliente(nome,endereco,complemento,cep,estado,cidade,codigoPessoa,cnpj);
		} catch (BaseDadosException e) {
			e.printStackTrace();
		}
	}

	public void updateVeiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo, String placa)  throws NegocioException{
		try{
			facade.updateVeiculo(marca, modelo, pesoMax, tipoVeiculo, codigoVeiculo, placa);
		} catch (BaseDadosException e) {
			e.printStackTrace();
		}
	}

	public void deleteMotorista(int codigo) throws NegocioException{
		try {
			facade.deleteMotorista(codigo);
		} catch (BaseDadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteCliente(int codigo) throws NegocioException{
		try {
			facade.deleteCliente(codigo);
		} catch (BaseDadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	public void deleteVeiculo(int codigo) throws NegocioException{
		try {
			facade.deleteVeiculo(codigo);
		} catch (BaseDadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public boolean cadastrarPedido(int codigoCliente, int codigoMotorista, int codigoPedido, int codigoVeiculo, double peso, String tipoCarga,
			int riscoCarga, double distancia, boolean finalizado, String dataEntrega, String descricao) throws NegocioException{
		try {
			if(!facade.verificaUnicidadePedido(codigoPedido)){
				return false;
			}
			boolean liberado = validaDistancia(distancia, dataEntrega, codigoMotorista);
			if(!liberado){
				JOptionPane.showMessageDialog(null, "Motorista já atingiu distância máxima de entrega para um dia.");
				return false;
			}
			Veiculo veiculo = facade.consultaVeiculo(codigoVeiculo);
			liberado = validaTipoVeiculo(veiculo.getTipoVeiculo(), peso);
			if(!liberado){
				JOptionPane.showMessageDialog(null, "Carga excedeu a capacidade do veículo selecionado");
				return false;
			}
			boolean pesook = validaPesoCarga(peso);
			if(pesook){
				facade.cadastrarPedido(codigoCliente, codigoMotorista, codigoPedido, codigoVeiculo, peso, tipoCarga,
						riscoCarga, distancia, finalizado, dataEntrega, descricao);
				JOptionPane.showMessageDialog(null, "A viagem durará: " + horasViagem(peso, distancia)+ " horas");
				return true;
			} else{
				JOptionPane.showMessageDialog(null, "Não trabalhamos com esse limite de carga.");
				return false;
			}
		} catch (BaseDadosException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Pedido> listaPedidos(int codigoMotorista) throws NegocioException{
		try{
			return facade.listaPedidos(codigoMotorista);
		} catch (BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}

	public Pedido consultaPedido(int codigoPedido) throws NegocioException{
		try{
			return facade.consultaPedido(codigoPedido);
		} catch (BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas ao acesso ao banco.");
		}
		
	}

	public void updatePedido(boolean status, int codigoPedido) throws NegocioException{
		try{
			facade.updatePedido(status, codigoPedido);
			Pedido pedido = consultaPedido(codigoPedido);
			if(status == true){//foi finalizado
				double preco = calculaPreco(pedido.getDistancia(), pedido.getPeso(), pedido.getTipocarga(), pedido.getRiscoCarga());
				try {
					if(temTaxaExtra(pedido.getDataEntrega())){
						preco = preco * 1.7;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Preço total = " + preco);
			}
		} catch (BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas ao acesso ao banco.");
		}
	}
	
	public Pedido deletePedido(Pedido pedido) throws NegocioException{
		try{
			return facade.deletePedido(pedido);
		}catch(BaseDadosException e){
			Log.gravaLog(e);
			throw new NegocioException("Problemas no acesso ao banco de dados.");
		}
	}
	
	public boolean validaDistancia(double distancia, String data, int codigoFuncionario){
		double distanciaTotal = 0;
		try {
			distanciaTotal = facade.distanciaPedido(data,codigoFuncionario);
			double somaDistancia = distancia + distanciaTotal;
			if(somaDistancia <= 100)
				return true;
			return false;
		} catch (BaseDadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validaTipoVeiculo(String tipo, double pesoCarga){
		if(tipo.equals("Van") && pesoCarga >= 20 && pesoCarga < 100)
			return true;
		else if(tipo.equals("Caminhão 2 Eixos") && pesoCarga >= 100 && pesoCarga < 3000)
			return true;
		else if(tipo.equals("Caminhão 4 Eixos") && pesoCarga >= 3000 && pesoCarga < 6000)
			return true;
		else
			return false;
	}
	
	public double calculaPreco(double distancia, double peso, String tipoCarga, int classeRisco){
		double precoTotal = 0;
		if(distancia >= 1 && distancia < 20){
			if(peso < 100)
				precoTotal = 50;
			else if(peso < 3000)
				precoTotal = 200;
			else if(peso <= 6000)
				precoTotal = 550;
		}else if(distancia < 30){
			if(peso < 100)
				precoTotal = 70;
			else if(peso < 3000)
				precoTotal = 300;
			else if(peso <= 6000)
				precoTotal = 650;
		}else if(distancia < 60){
			if(peso < 100)
				precoTotal = 90;
			else if(peso < 3000)
				precoTotal = 400;
			else if(peso <= 6000)
				precoTotal = 750;
		}else if(distancia <=100 ){
			if(peso < 100)
				precoTotal = 150;
			else if(peso < 3000)
				precoTotal = 500;
			else if(peso <= 6000)
				precoTotal = 850;
		}
		if(tipoCarga.equals("Sólida - Grãos"))
			precoTotal = precoTotal*0.8;
		else if(tipoCarga.equals("Sólida - Maciça"))
			precoTotal = precoTotal*1.5;
		else if(tipoCarga.equals("Sólida - Frágil"))
			precoTotal = precoTotal*2;
		else if(tipoCarga.equals("Liquida"))
			precoTotal = precoTotal*1;
		switch(classeRisco){
			case 0:
			break;
			case 1:
				precoTotal = precoTotal*1.7;
			break;
			case 2:
				precoTotal = precoTotal*1.5;
			break;
			case 3:
				precoTotal = precoTotal*3;
			break;
			case 4:
				precoTotal = precoTotal*1.3;
			break;
			case 5:
				precoTotal = precoTotal*1.4;
			break;
		}
		return precoTotal;
	}
	public boolean validaPesoCarga(double peso){
		if(peso > 6000 || peso<20)
			return false;
		return true;
	}
	
	public static boolean temTaxaExtra(String data) throws ParseException{
		String datagamb = data.substring(0,2) + "/" + data.substring(2,4) + "/" + data.substring(4,8);
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
	    df.setLenient(false);
	    Date d1 = new Date();//data atual
	    Date d2 = (Date) df.parse (datagamb);
	    long dt = (d2.getTime() - d1.getTime()) + 3600000;
	    int dias = (int) (dt / 86400000L);
	    if(dias <= 1)
	         return true;
	    return false;
	}
	
	public int horasViagem(double peso, double distancia){
		if(peso < 100){
			if(distancia > 20)
				return 1;
			else if(distancia > 30)
				return 2;
			else if(distancia > 60)
				return 3;
			else if(distancia > 100)
				return 4;
		}else if(peso < 3000){
			if(distancia > 20)
				return 3;
			else if(distancia > 30)
				return 4;
			else if(distancia > 60)
				return 5;
			else if(distancia > 100)
				return 6;
		}else if(peso <= 6000){
			if(distancia > 20)
				return 2;
			else if(distancia > 30)
				return 4;
			else if(distancia > 60)
				return 5;
			else if(distancia > 100)
				return 6;
		}
		return 0;
	}
}