package Sistema;

public class Produto {
	private int codigo;
	private String nome;
	private double preco;
	
	public Produto(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Produto() {}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "]";
	}
}

