package bean;

public class Motorista extends Funcionario{
    private String tipoCarta;

    public Motorista(String nome, String endereco, String complemento, String cep, 
    String estado, String cidade, String cpf, String cargo, int codigoPessoa, String login, String senha, String tipoCarta){
        super(nome, endereco, complemento, cep, estado, cidade, codigoPessoa, cpf, cargo, login, senha);
        this.setTipoCarta(tipoCarta);
    }

	public String getTipoCarta() {
		return tipoCarta;
	}

	public void setTipoCarta(String tipoCarta) {
		this.tipoCarta = tipoCarta;
	}

	
    
}