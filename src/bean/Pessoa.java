package bean;

public class Pessoa{
    private String nome;
    private String endereco;
    private String complemento;
    private String cep;
    private String estado;
	private String cidade;
	private int codigoPessoa;
    
    public Pessoa(String nome, String endereco, String complemento, String cep, 
        String estado, String cidade, int codigoPessoa){
            this.setNome(nome);
            this.setEndereco(endereco);
            this.setComplemento(complemento);
            this.setCep(cep);
            this.setEstado(estado);
			this.setCidade(cidade);
			this.setCodigopessoa(codigoPessoa);
    }
    
    public Pessoa(int codigoFuncionario, String nome2) {
		this.setCodigopessoa(codigoFuncionario);
		this.setNome(nome2);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
    }
    public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getCodigopessoa()
	{
		return this.codigoPessoa;
	}

	public void setCodigopessoa(int codigoPessoa)
	{
		this.codigoPessoa = codigoPessoa;
	}
}