package Sistema;

import java.util.Scanner;

public class Main {
	static Scanner scc = new Scanner(System.in);
	public static void main(String[] args) {
		CadastroProdutos cadastroProduto = new CadastroProdutos();
		CadastroCliente cadastroCliente = new CadastroCliente();
		ControleEstoque movimentacao = new ControleEstoque();
		
		int opcao;			
		do {
			System.out.println("Menu");
			System.out.println("1 - Produtos");
			System.out.println("2 - Clientes");
			System.out.println("3 - Movimentação");
			System.out.println("0 - Finalizar");
			System.out.println("Opção: ");
			opcao = scc.nextInt();
						
			if (opcao == 1) cadastroProduto.cadastrarProdutos();
			else if (opcao == 2) cadastroCliente.Menu();
			else if (opcao == 3) movimentacao.menuMovimentacao();;
		} while (opcao!=0);
	}
}
