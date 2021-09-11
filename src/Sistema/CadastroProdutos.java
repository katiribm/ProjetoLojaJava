package Sistema;

import java.util.Scanner;

public class CadastroProdutos {
	Dados dados = new Dados();
	Scanner sc = new Scanner(System.in); 

	public void cadastrarProdutos() {
		int opcao;
		do {
			System.out.println("Cadastro de produtos");
			System.out.println("1 - Inclusão");
			System.out.println("2 - Listar Produtos");
			System.out.println("3 - Alteração de preço");
			System.out.println("0 - Retornar");
			System.out.println("Opção: ");
			opcao = sc.nextInt();
			
			if (opcao == 1) incluirProduto();
			else if (opcao == 2) System.out.println(dados.ListaProdutos());
			else if (opcao == 3) alterarProduto();
			else if (opcao == 0) break;
		} while (opcao <= 3);
	}

	private void incluirProduto() {
			System.out.println("Código:");
			int codigo = sc.nextInt();
		
			System.out.println("Descrição:");
            String descricao = sc.next();
			
			System.out.println("Confirma inclusão(S/N)?");
			String inserir = sc.next();

			if ("S".equals(inserir.toUpperCase())) {
				Produto produto = new Produto(codigo, descricao);
				dados.AddProduto(produto);
			}
	}

	private void alterarProduto() {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("Alteração do produto \n");
			// percorre lista: se encontrar modifica, caso contrário vai exibir mensagem
			System.out.println("Código do produto: ");
			int codProduto = sc.nextInt();
			Produto produto = null;
			for (Produto produtos : dados.produtosList) {
				if (codProduto == produtos.getCodigo()) produto = produtos;
			}

			if (produto != null) {
				System.out.println("Novo preço: ");
				double preco = Double.parseDouble(sc.nextLine());
				produto.setPreco(preco);
				if (produto.getPreco() <= 0) {
					System.out.println("O preço deve ser maior que zero.");
				}
				while (produto.getPreco() <= 0) {
					System.out.println("Preço:");
					preco = Double.parseDouble(sc.nextLine());
					produto.setPreco(preco);
					if (produto.getPreco() <= 0) {
						System.out.println("O preço deve ser maior que zero.");
					}
				}

				System.out.println("Confirma alteração (S/N)?");
				String inserir = sc.nextLine();

				if ("S".equals(inserir)) dados.AtualizaPrecoProduto(codProduto, preco);
			} else {
				System.out.println("Produto não cadastrado.");
			}
			System.out.println("Repetir operação  (S/N)?");
			opcao = sc.nextLine();
		}
	}
	
}


