package Sistema;

import java.util.Scanner;

public class ControleEstoque {
	Dados dados = new Dados();
	Scanner sc = new Scanner(System.in); 
	
	public void menuMovimentacao() {
		int opcao;
		do {
	        System.out.println("1 - Entrada");
	        System.out.println("2 - Sa�da");
	        System.out.println("0 - Retornar");
	        System.out.println("Op��o: ");
	        opcao = Integer.parseInt(sc.next());
	       
	        switch (opcao) {
	            case 1:
	               entradaProduto();
	                break;
	            case 2:
	                saidaProduto();
	                break;
	        }
		} while(opcao !=0);
	}

	
	private void entradaProduto() {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("Sistema de controle de estoque ");
			System.out.println("C�digo do Produto:");
			int codProduto = sc.nextInt();
			Produto produto = null;
			for (Produto produtos : dados.produtosList) {
				if (codProduto == produtos.getCodigo()) produto = produtos;
			}
			if (produto != null) {
				System.out.println("Quantidade atual: " + dados.EstoqueByIdProduto(produto.getCodigo()));
				System.out.println("Quantidade entrada: ");
				int quantidadeEntrada = Integer.parseInt(sc.next());
		
				if (quantidadeEntrada <= 0) {
					System.out.println("A quantidade deve ser maior que zero.");
				}
				//Adicionar valida��o Igual ao da quantidade menor igual a zero
				while (quantidadeEntrada <= 0) {
					System.out.println("Quantidade:");
					quantidadeEntrada = Integer.parseInt(sc.next());
					if (quantidadeEntrada <= 0) {
						System.out.println("A quantidade deve ser maior que zero.");
					}
				}
			
				System.out.println("Quantidade final: " + (quantidadeEntrada + dados.EstoqueByIdProduto(produto.getCodigo())));

				System.out.println("Confirma (S/N)?");
				String inserir = sc.nextLine();
	
				if ("S".equals(inserir)) dados.AddProdutoEstoque(produto.getCodigo(), quantidadeEntrada);
			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("Repetir opera��o (S/N)?");
			opcao = sc.nextLine();
		}
	}
   
	private void saidaProduto() {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("Controle de estoque ");
			System.out.println("C�digo do Produto: ");
			int codProduto = sc.nextInt();
			Produto produto = null;
			for (Produto produtos : dados.produtosList) {
				if (codProduto == produtos.getCodigo()) produto = produtos;
			}
			if (produto != null) {
				int quantidadeEstoque = dados.EstoqueByIdProduto(produto.getCodigo());
				System.out.println("Quantidade atual: " + quantidadeEstoque);
				System.out.println("Quantidade sa�da: ");
				int quantidadeSaida = Integer.parseInt(sc.nextLine());
		
				if (quantidadeSaida <= 0) System.out.println("A quantidade deve ser maior que zero.");
				else if (quantidadeEstoque - quantidadeSaida < 0 ) {
					System.out.println("A quantidade informada superior a dispon�vel em estoque!");
				}
				//Adicionar valida��o Igual ao da quantidade menor igual a zero
				while (quantidadeSaida <= 0 || quantidadeEstoque - quantidadeSaida < 0 ) {
					System.out.println("Quantidade: ");
					quantidadeSaida = Integer.parseInt(sc.nextLine());
					if (quantidadeSaida <= 0) System.out.println("A quantidade deve ser maior que zero.");
					else if (quantidadeEstoque - quantidadeSaida < 0 ) System.out.println("A quantidade ficar� negativa !");
				}
			
				System.out.println("Quantidade final: " + (quantidadeEstoque - quantidadeSaida));

				System.out.println("Confirma (S/N)?");
				String inserir = sc.next();
	
				if (inserir.equals("S")) dados.RemoveProdutoEstoque(codProduto, quantidadeSaida);
			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("Repetir opera��o (S/N)?");
			opcao = sc.nextLine();
		}
	}
	
	/*
	public void reajustePreco(Scanner scanner, CadastroProdutos controladorDeEstoque) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			
			System.out.println("Controle de estoque ");
			System.out.println("REAJUSTE PRE�O ");
			// Aqui eu percorro a lista, e verifico se existe algum produto
			// com o nome digitado
			// se encontrar, vou modificar o pre�o, caso contr�rio vai exibir mensagem
			System.out.println("NOME:");
			String nome = scanner.nextLine();
			Produto produtoASerAlterado = null;
			for (Produto produto : controladorDeEstoque.getProdutos()) {
				if (nome.equals(produto.getNome())) {
					produtoASerAlterado = produto;
				}
				if (produtoASerAlterado != null) {
					System.out.println("PRE�O ATUAL: " + produtoASerAlterado.getPreco());
					
				}
			}
//
			if (produtoASerAlterado != null) {
				System.out.println("NOVO PRE�O: ");
				double preco = Double.parseDouble(scanner.nextLine());
				produtoASerAlterado.setPreco(preco);
				if (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("O pre�o deve ser maior que zero.");
				}
				while (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("PRE�O:");
					preco = Double.parseDouble(scanner.nextLine());
					if (preco <= 0) {
						System.out.println("O pre�o deve ser maior que zero.");
					}
				}

				System.out.println("CONFIRMA REAJUSTE(S/N)?");
				String inserir = scanner.nextLine();

				if ("S".equals(inserir)) {
					produtoASerAlterado.setPreco(preco);
					controladorDeEstoque.getProdutos().remove(produtoASerAlterado);
					controladorDeEstoque.getProdutos().add(produtoASerAlterado);
				}
			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)?");
			opcao = scanner.nextLine();
		}
		
		*/
}
	


