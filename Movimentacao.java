package Sistema;

import java.sql.Date;

public class Movimentacao extends Dados {
	private int cod_produto;
	private int cod_clientes;
	private int quantidade;
	private double preco;
	private Date data;
	private String tipo;
	
	public Movimentacao() {};
	
	public Movimentacao(int cod_produto, int cod_clientes, int quantidade, double preco, Date data, String tipo) {
		this.setCod_produto(cod_produto);
		this.setCod_clientes(cod_clientes);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
		this.setData(data);
		this.setTipo(tipo);
	}
	
	@Override
	public void AddMovimentacao(Movimentacao movimentacao) {
		super.AddMovimentacao(movimentacao);
	}
	
	@Override
	public String ListaMovimentacoes() {
		return super.ListaMovimentacoes();
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getCod_clientes() {
		return cod_clientes;
	}

	public void setCod_clientes(int cod_clientes) {
		this.cod_clientes = cod_clientes;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
