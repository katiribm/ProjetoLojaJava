package Sistema;

public class Estoque {
	private int cod_produto;
	private int quantidade;
	
	public Estoque() {}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return cod_produto;
	}
}
