package Sistema;

public class Clientes {
	private int codigo = 0; 
	private String nome;
	private String cpf;
	private String dataNascimento;
	
	public Clientes(int codigo, String nome, String cpf, String dataNascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Clientes() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Clientes [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ "]";
	}
}
	
	
	