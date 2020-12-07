package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
	private int codigoCliente;
	private int codigoMotorista;
	private int codigoPedido;
	private int codigoVeiculo;
	private double peso;
	private String tipoCarga;
	private int riscoCarga;
	private double distancia;
	private boolean finalizado;
	private String dataEntrega;
	private String descricao;

	public Pedido(int codigoCliente, int codigoMotorista, int codigoPedido, int codigoVeiculo, double peso, String tipoCarga,
			int riscoCarga, double distancia, boolean finalizado, String dataEntrega, String descricao) {
		this.setCodigoCliente(codigoCliente);
		this.setCodigoMotorista(codigoMotorista);
		this.setCodigoPedido(codigoPedido);
		this.setCodigoVeiculo(codigoVeiculo);
		this.setPeso(peso);
		this.setTipocarga(tipoCarga);
		this.setRiscoCarga(riscoCarga);
		this.setDistancia(distancia);
		this.setFinalizado(finalizado);
		this.setDescricao(descricao);
		
		
		//data entrega
		String dia = dataEntrega.substring(0, 2);
		String mes = dataEntrega.substring(2, 4);
		String ano = dataEntrega.substring(4, 8);
		String data = ano + '-' + mes + '-' + dia;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada;
		try {
			dataFormatada = formatter.parse(data);
			Date actual = new Date();
			if (dataFormatada.compareTo(actual) > 0) {
				this.setDataEntrega(dataEntrega);
			} else if (dataFormatada.compareTo(actual) < 0) {
				//
			} else {
				this.setDataEntrega(dataEntrega);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Pedido(int codigoPedido2, boolean finalizado2, int codigoCliente2, int codigoVeiculo2) {
		this.setCodigoPedido(codigoPedido2);
		this.setFinalizado(finalizado2);
		this.setCodigoCliente(codigoCliente2);
		this.setCodigoVeiculo(codigoVeiculo2);
	}

	public Pedido(boolean finalizado, int codigoPedido) {
		this.setFinalizado(finalizado);
		this.setCodigoPedido(codigoPedido);
	}

	public Pedido(int codigoPedido) {
		this.setCodigoPedido(codigoPedido);
	}

	public Pedido(boolean boolean1, int codigoPedido2, double double1, String string, int int1, double double2, String dataEntrega) {
		this.setFinalizado(boolean1);
		this.setCodigoPedido(codigoPedido2);
		this.setPeso(double2);
		this.setTipocarga(string);
		this.setRiscoCarga(int1);
		this.setDistancia(double2);
		this.setDataEntrega(dataEntrega);
	}

	public int getCliente() {
		return this.codigoCliente;
	}

	public void setCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoPedido() {
		return this.codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTipocarga() {
		return this.tipoCarga;
	}

	public void setTipocarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public int getRiscoCarga() {
		return this.riscoCarga;
	}

	public void setRiscoCarga(int riscoCarga) {
		this.riscoCarga = riscoCarga;
	}

	public double getDistancia() {
		return this.distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public boolean getFinalizado() {
		return this.finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		String dia = dataEntrega.substring(0, 2);
		String mes = dataEntrega.substring(2, 4);
		String ano = dataEntrega.substring(4, 8);
		String data = ano + '-' + mes + '-' + dia;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada;
		try {
			dataFormatada = formatter.parse(data);
			Date actual = new Date();
			if (dataFormatada.compareTo(actual) > 0) {
				this.dataEntrega = dataEntrega;
			} else if (dataFormatada.compareTo(actual) < 0) {
				//
			} else {
				this.dataEntrega = dataEntrega;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoVeiculo() {
		return this.codigoVeiculo;
	}

	public void setCodigoVeiculo(int codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public int getCodigoMotorista() {
		return this.codigoMotorista;
	}

	public void setCodigoMotorista(int codigoMotorista) {
		this.codigoMotorista = codigoMotorista;
	}
}