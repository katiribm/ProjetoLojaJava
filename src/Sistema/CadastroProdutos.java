package Sistema;

import java.util.Scanner;

public class CadastroProdutos {
	Dados dados = new Dados();
	Scanner sc = new Scanner(System.in); 

	public void cadastrarProdutos() {
		int opcao;
		do {
			System.out.println("Cadastro de produtos");
			System.out.println("1 - Inclus�o");
			System.out.println("2 - Listar Produtos");
			System.out.println("3 - Altera��o de pre�o");
			System.out.println("0 - Retornar");
			System.out.println("Op��o: ");
			opcao = sc.nextInt();
			
			if (opcao == 1) incluirProduto();
			else if (opcao == 2) System.out.println(dados.ListaProdutos());
			else if (opcao == 3) alterarProduto();
			else if (opcao == 0) break;
		} while (opcao <= 3);
	}

	private void incluirProduto() {
			System.out.println("C�digo:");
			int codigo = sc.nextInt();
		
			System.out.println("Descri��o:");
            String descricao = sc.next();
			
			System.out.println("Confirma inclus�o(S/N)?");
			String inserir = sc.next();

			if ("S".equals(inserir.toUpperCase())) {
				Produto produto = new Produto(codigo, descricao);
				dados.AddProduto(produto);
			}
	}

	private void alterarProduto() {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("Altera��o do produto \n");
			// percorre lista: se encontrar modifica, caso contr�rio vai exibir mensagem
			System.out.println("C�digo do produto: ");
			int codProduto = sc.nextInt();
			Produto produto = null;
			for (Produto produtos : dados.produtosList) {
				if (codProduto == produtos.getCodigo()) produto = produtos;
			}

			if (produto != null) {
				System.out.println("Novo pre�o: ");
				double preco = Double.parseDouble(sc.nextLine());
				produto.setPreco(preco);
				if (produto.getPreco() <= 0) {
					System.out.println("O pre�o deve ser maior que zero.");
				}
				while (produto.getPreco() <= 0) {
					System.out.println("Pre�o:");
					preco = Double.parseDouble(sc.nextLine());
					produto.setPreco(preco);
					if (produto.getPreco() <= 0) {
						System.out.println("O pre�o deve ser maior que zero.");
					}
				}

				System.out.println("Confirma altera��o (S/N)?");
				String inserir = sc.nextLine();

				if ("S".equals(inserir)) dados.AtualizaPrecoProduto(codProduto, preco);
			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("Repetir opera��o  (S/N)?");
			opcao = sc.nextLine();
		}
	}
	
}


