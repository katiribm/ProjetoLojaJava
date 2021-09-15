package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Dados {
	List<Produto> produtosList = new ArrayList<Produto>();
	List<Clientes> clientesList = new ArrayList<Clientes>();
	//List<Estoque> estoqueList = new ArrayList<Estoque>();
	List<Movimentacao> movimentacaoList = new ArrayList<Movimentacao>();
		
	public void AddCliente(Clientes cliente) {
		clientesList.add(cliente);
	}
	
	public Clientes GetClienteById(int codigo) {
		for (Clientes cliente : clientesList){
			if (codigo == cliente.getCodigo()){
				return cliente;
			}
		}
		return null;
	}
	
	public String ListaClientes() {
		String lista = "";
		for (Clientes cliente : clientesList) {
			lista += "\n" + "Código: " + cliente.getCodigo() + "\n" +
					 "Nome: " + cliente.getNome() + "\n";
		}
		return lista;
	}
	
	public String ExibeClienteById(int idCliente) {
		String registro = "";
		for (Clientes cliente : clientesList){
			if (cliente.getCodigo() == idCliente){
				registro = "Código: " + cliente.getCodigo() + "\n" +
						 "Nome: " + cliente.getNome() + "\n" +
						 "CPF: " + cliente.getCpf();
			}
		}
		return registro;
	}
	
	public void AddProduto(Produto produto) {
		produtosList.add(produto);
	}
	
	public List<Produto> GetProdutos() {
		return produtosList;
	}
	
	public String ListaProdutos() {
		String lista = "";
		for (Produto produto : produtosList) {
			lista += "\n" + "Código: " + produto.getCodigo() + "\n" +
					 "Descrição: " + produto.getNome() + "\n" +
					 "Quantidade: " + produto.getQuantidade() + "\n" +
					 "Preco: " + produto.getPreco() + "\n";
		}
		return lista;
	}
	
	public Produto GetProdutoById(int codigo) {
		for (Produto produto : produtosList){
			if (codigo == produto.getCodigo()){
				return produto;
			}
		}
		return null;
	}
	
	public int GetQuantidadeProdutoById(int codigo) {
		for (Produto produto : produtosList){
			if (codigo == produto.getCodigo()){
				return produto.getQuantidade();
			}
		}
		return 0;
	}
	
	public String ExibeProdutoById(int idProduto) {
		String registro = "";
		for(Produto produto : produtosList){
			if (produto.getCodigo() == idProduto){
				registro = "\n" + "Código: " + produto.getCodigo() + "\n" +
						 "Descrição: " + produto.getNome() + "\n" +
						 "Quantidade: " + produto.getQuantidade();
			}
		}
		return registro;
	}
	
	public void AddQuantidadeProduto(int idProduto, int quantidade) {
		for(Produto produto : produtosList){
			if (produto.getCodigo() == idProduto) produto.setQuantidade(quantidade);
		}
	}
	
	public void RemoveProdutoEstoque(int idProduto, int quantidade) {
		for(Produto produto : produtosList){
			if (produto.getCodigo() == idProduto){
				produto.setQuantidade(produto.getQuantidade() - quantidade);
			}
		}
	}
	
	public void AtualizaPrecoProduto(int idProduto, double preco) {
		for(Produto produto : produtosList){
			if (produto.getCodigo() == idProduto) produto.setPreco(preco);
		}
	}
	
	public void AddMovimentacao(Movimentacao movimentacao) {
		movimentacaoList.add(movimentacao);
	}
	
	public String ListaMovimentacoes() {
		String lista = "";
		for (Movimentacao movimentacao : movimentacaoList) {
			var tipoMovimentacao = "";
			if (movimentacao.getTipo() == "E") tipoMovimentacao = "Entrada";
			else tipoMovimentacao = "Saída";
			lista += "\n" + "Cliente: " + movimentacao.getCod_clientes() + "\n" +
					 "Produto: " + movimentacao.getCod_produto() + "\n" +
					 "Quantidade: " + movimentacao.getQuantidade() + "\n" +
					 "Preco: " + movimentacao.getPreco() + "\n" +
					 tipoMovimentacao;
		}
		return lista;
	}
	
}
