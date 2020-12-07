package bean;

public class Funcionario extends Pessoa{
    private String cpf;
    private String cargo;
    private String login;
    private String senha;

    public Funcionario(String nome, String endereco, String complemento, String cep, 
    String estado, String cidade, int codigoPessoa, String cpf, String cargo, String login, String senha){
        super(nome, endereco, complemento, cep, estado, cidade, codigoPessoa);
        this.setCpf(cpf);
		this.setCargo(cargo);
		this.setLogin(login);
		this.setSenha(senha);
    }
	public Funcionario(int codigoFuncionario, String nome, String cargo2) {
		super(codigoFuncionario, nome);
		this.setCargo(cargo2);
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
    }
	public String getCargo()
	{
		return this.cargo;
	}
	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}