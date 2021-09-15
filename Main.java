package Sistema;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Produto produto = new Produto();
		Clientes cliente = new Clientes();
		Movimentacao movimentacao = new Movimentacao();
		Scanner sc = new Scanner(System.in); 
		int opcao;			
		do {
			System.out.println("Menu");
			System.out.println("1 - Cadastrar Produtos");
			System.out.println("2 - Listar Produtos");
			System.out.println("3 - Alterar Preço de Produtos");
			System.out.println("4 - Cadastrar Clientes");
			System.out.println("5 - Listar Clientes");
			System.out.println("6 - Compra");
			System.out.println("7 - Venda");
			System.out.println("8 - Relatório de Movimentações");
			System.out.println("0 - Finalizar");
			System.out.println("Opcao: ");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				
				Produto result = produto.IncluirProduto();
				
				if (result == null) {
					System.out.println("Erro ao cadastrar o produto!");
					break;
				}
				var retorno = produto.GetProdutoById(result.getCodigo());
				if (retorno !=  null) {
					System.out.println("Esse código ja foi utilizado, escolha outro código");
					break;
				}
				
				produto.AddProduto(result);
				System.out.println("Produto cadastrado com sucesso!");
				break;
			}
			case 2: {
				System.out.println(produto.ListaProdutos());
				break;
				//a quantidade é adicionada em movimentação.
			}
			
			case 3: {
				Produto result = produto.AlterarPrecoProduto();
				
				if (result == null) {
					System.out.println("Produto não cadastrado!");
					break;
				}
				
				produto.AtualizaPrecoProduto(result.getCodigo(), result.getPreco());
				System.out.println("Produto atualizado com sucesso!");
			
				break;
			}
			
			case 4: {
				Clientes result =  cliente.CadastrarCliente();
				if (result == null) {
					System.out.println("Erro ao cadastrar o cliente!");
					break;
				}
				cliente.AddCliente(result);
				System.out.println("Cliente cadastrado com sucesso!");
				break;
			}
			case 5: {
				System.out.println(cliente.ListaClientes());
				break;
			}
			case 6: {
				System.out.println("\n====== Entrada de Produtos ======\n");
				System.out.println("Código do Produto: ");
				int codProduto = sc.nextInt();
				Produto produtoAltera = produto.GetProdutoById(codProduto);
				if (produtoAltera == null) {
					System.out.println("Produto não cadastrado.");
				} else {
					System.out.println("Quantidade atual: " + produto.GetQuantidadeProdutoById(produtoAltera.getCodigo()));
					int quantidadeEntrada = 0;
			
					while (quantidadeEntrada <= 0) {
						System.out.println("Quantidade entrada: ");
						quantidadeEntrada = sc.nextInt();
						if (quantidadeEntrada <= 0) {
							System.out.println("A quantidade deve ser maior que zero.");
						}
					}
					
					System.out.println("Confirma a transacao (S/N)?");
					String inserir = sc.next();

					if (inserir.equals("S")) {
						Movimentacao result = new Movimentacao(codProduto, 0, quantidadeEntrada, produtoAltera.getPreco(), null, "E");
						movimentacao.AddMovimentacao(result);
						produto.AddQuantidadeProduto(codProduto, quantidadeEntrada);
					}
				}
				break;
			}
			case 7: {
				System.out.println("\n====== Saída de Produtos / Venda ======\n");
				System.out.println("Código do Produto: ");
				int codProduto = sc.nextInt();
				var produtoAltera = produto.GetProdutoById(codProduto);
				if (produtoAltera == null) {
					System.out.println("Produto não cadastrado.");
					break;
				}
				
				System.out.println("Código do Cliente: ");
				int idCliente = sc.nextInt();
				var clienteVenda = cliente.GetClienteById(idCliente);
				if (clienteVenda == null) {
					System.out.println("Cliente não cadastrado!");
					break;
				}
							
				int quantidadeEstoque = produto.GetQuantidadeProdutoById(produtoAltera.getCodigo());
				System.out.println("Quantidade atual: " + quantidadeEstoque);
				System.out.println("Quantidade saída: ");
				int quantidadeSaida = sc.nextInt();
		
				if (quantidadeSaida <= 0) System.out.println("A quantidade deve ser maior que zero.");
				else if (quantidadeEstoque - quantidadeSaida < 0 ) {
					System.out.println("A quantidade informada superior a disponível em estoque!");
				}
				
				while (quantidadeSaida <= 0 || quantidadeEstoque - quantidadeSaida < 0 ) {
					System.out.println("Quantidade: ");
					quantidadeSaida = sc.nextInt();
					if (quantidadeSaida <= 0) System.out.println("A quantidade deve ser maior que zero.");
					else if (quantidadeEstoque - quantidadeSaida < 0 ) System.out.println("A quantidade ficará negativa !");
				}
			
				System.out.println("Quantidade final: " + (quantidadeEstoque - quantidadeSaida));

				System.out.println("Confirma a transacao (S/N)?");
				String inserir = sc.next();

				if (inserir.equals("S")) {
					Movimentacao result = new Movimentacao(codProduto, idCliente, quantidadeSaida, produtoAltera.getPreco(), null, "S");
					movimentacao.AddMovimentacao(result);
					produto.RemoveProdutoEstoque(codProduto, quantidadeSaida);
				}
				break;
			}
			case 8:{
				System.out.println(movimentacao.ListaMovimentacoes());
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} while (opcao!=0);
		
	}	
}
