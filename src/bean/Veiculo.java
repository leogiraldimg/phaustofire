package bean;

public class Veiculo {
    private String marca;
    private String modelo;
    private double pesoMax;
    private int codigoVeiculo;
    private String tipoVeiculo;
    private String placa;
    
    public Veiculo(String marca, String modelo, double pesoMax, String tipoVeiculo, int codigoVeiculo, String placa){
    	this.setCodigoVeiculo(codigoVeiculo);
    	this.setMarca(marca);
    	this.setModelo(modelo);
    	this.setPesoMax(pesoMax);
    	this.setTipoVeiculo(tipoVeiculo);
    	this.setPlaca(placa);
    }

	public Veiculo(String placa2, String tipoVeiculo2, String modelo2) {
		this.setPlaca(placa2);
		this.setTipoVeiculo(tipoVeiculo2);
		this.setModelo(modelo2);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public int getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(int codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
    
    
}
