package Sistema;

import java.util.*;

public class CadastroCliente {
	Scanner sc = new Scanner(System.in);
	Scanner scc = new Scanner(System.in);
	Dados dados = new Dados();
	
	public void Menu() {
		int opcao;			
		do {
			System.out.println("Menu");
			System.out.println("1 - Cadastrar de Clientes");
			System.out.println("2 - Listar Clientes");
			System.out.println("0 - Retornar");
			System.out.println("Opção: ");
			opcao = sc.nextInt();

			if (opcao == 1) cadastrar();
			else if (opcao == 2) listarClientes();
			else if (opcao == 0) break;
		} while (opcao <= 2);
	}
	
	
	private void cadastrar(){
		System.out.println("\n===== Cadastro de cliente =====\n");

		System.out.println("Código: ");
        int codigo = sc.nextInt();
		
        System.out.println("Nome: ");
        String nome = sc.next();

        System.out.println("CPF: ");
        String cpf = sc.next();

        System.out.println("Data de nascimento: ");
        String dataNascimento = sc.next();

        Clientes cliente = new Clientes(codigo, nome, cpf, dataNascimento);
        dados.AddCliente(cliente);
        
        System.out.println("Cliente cadastrado com sucesso.");    
	}
	
	private void listarClientes(){
		var clientes = dados.ListaClientes();
		System.out.println(clientes);
	}
	
}	
	
