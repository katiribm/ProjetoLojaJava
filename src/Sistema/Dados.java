package Sistema;

import java.util.ArrayList;

public class Dados {
	ArrayList<Produto> produtosList = new ArrayList<>();
	ArrayList<Clientes> clientesList = new ArrayList<>();
	ArrayList<Estoque> estoqueList = new ArrayList<>();
		
	public void AddCliente(Clientes cliente) {
		clientesList.add(cliente);
	}
	
	public String ListaClientes() {
		String lista = "";
		for (Clientes cliente : clientesList) {
			lista += "\n" + "Código: " + cliente.getCodigo() + "\n" +
					 "Nome: " + cliente.getNome() + "\n";
		}
		return lista;
	}
	
	public String ClienteById(int idCliente) {
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
	
	public ArrayList<Produto> GetProdutos() {
		return produtosList;
	}
	
	public String ListaProdutos() {
		String lista = "";
		for (Produto produto : produtosList) {
			lista += "\n" + "Código: " + produto.getCodigo() + "\n" +
					 "Descrição: " + produto.getNome() + "\n" +
					 "Quantidade: " + EstoqueByIdProduto(produto.getCodigo()) + "\n";
		}
		return lista;
	}
	
	public String ProdutoById(int idProduto) {
		String registro = "";
		for(Produto produto : produtosList){
			if (produto.getCodigo() == idProduto){
				registro = "\n" + "Código: " + produto.getCodigo() + "\n" +
						 "Descrição: " + produto.getNome() + "\n" +
						 "Quantidade: " + EstoqueByIdProduto(produto.getCodigo());
			}
		}
		return registro;
	}
	
	public int EstoqueByIdProduto(int idProduto) {
		int quantidade = 0;
		for(Estoque estoque : estoqueList){
			if (estoque.getCodigo() == idProduto){
				quantidade = estoque.getQuantidade();
			}
		}
		return quantidade;
	}
	
	public void AddProdutoEstoque(int idProduto, int quantidade) {
		for(Estoque estoque : estoqueList){
			if (estoque.getCodigo() == idProduto){
				estoque.setQuantidade(estoque.getQuantidade() + quantidade);
			}
		}
	}
	
	public void RemoveProdutoEstoque(int idProduto, int quantidade) {
		for(Estoque estoque : estoqueList){
			if (estoque.getCodigo() == idProduto){
				estoque.setQuantidade(estoque.getQuantidade() - quantidade);
			}
		}
	}
	
	public void AtualizaPrecoProduto(int idProduto, double preco) {
		for(Produto produto : produtosList){
			if (produto.getCodigo() == idProduto) produto.setPreco(preco);
		}
	}
}
