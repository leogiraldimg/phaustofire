package bean;

public class Cliente extends Pessoa{
    private String cnpj;
    
    public Cliente(int codigoCliente, String nome, String cnpj){
    	super(codigoCliente, nome);
    	this.setCnpj(cnpj);
    }
	
	public Cliente(String nome, String endereco, String complemento, String cep, 
	String estado, String cidade, int codigoPessoa,String cnpj){
		super(nome, endereco, complemento, cep, estado, cidade, codigoPessoa);
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	

    
}