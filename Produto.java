package Sistema;

import java.util.List;
import java.util.Scanner;

public class Produto extends Dados {
	Scanner sc = new Scanner(System.in);
	
	private int codigo;
	private String nome;
	private double preco;
	private int quantidade;
	
	public Produto(int codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
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
	
	public Produto IncluirProduto() {
		System.out.println("Código: ");
		int codigo = sc.nextInt();
	
		System.out.println("Descrição: ");
        String descricao = sc.next();
		
        System.out.println("Preço: ");
        double preco = sc.nextDouble();
	
    	Produto produto = new Produto(codigo, descricao, preco);
		return produto;
	}
	
	public Produto AlterarPrecoProduto() {
		Produto produto = null;
		System.out.println("\n===== Alteração de produto =====\n");
		System.out.println("Código do produto: ");
		int codProduto = sc.nextInt();
		Produto produtoAltera = GetProdutoById(codProduto);
		if (produtoAltera != null) {
			System.out.println("Novo preço: ");
			double preco = sc.nextDouble();
			if (preco <= 0) System.out.println("O preço deve ser maior que zero.");
			while (preco <= 0) {
				System.out.println("Preço:");
				preco = Double.parseDouble(sc.nextLine());
				if (preco <= 0) System.out.println("O preço deve ser maior que zero.");
			}
			produto = new Produto(codProduto, produtoAltera.getNome(), preco);
		} 
		return produto;
	}
	
	
	
	@Override
	public void AddProduto(Produto produto) {
		super.AddProduto(produto);
	}
	
	@Override
	public String ListaProdutos() {
		return super.ListaProdutos();
	}
	
	@Override
	public List<Produto> GetProdutos() {
		return super.GetProdutos();
	}
	
	@Override
	public void AtualizaPrecoProduto(int idProduto, double preco) {
		super.AtualizaPrecoProduto(idProduto, preco);
	}
	
	@Override
	public Produto GetProdutoById(int codigo) {
		return super.GetProdutoById(codigo);
	}
	
	@Override
	public void AddQuantidadeProduto(int idProduto, int quantidade) {
		super.AddQuantidadeProduto(idProduto, quantidade);
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "]";
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String ListaClientes() {
		return super.ListaClientes();
	}
	
}

