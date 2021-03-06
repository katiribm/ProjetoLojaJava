package Sistema;

import java.util.Scanner;

public class Clientes extends Dados {
	Scanner sc = new Scanner(System.in);
	
	private int codigo = 0; 
	private String nome;
	private String cpf;
	private String dataNascimento;
	
	public Clientes(int codigo, String nome, String cpf, String dataNascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Clientes() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Clientes CadastrarCliente(){
		System.out.println("\n===== Cadastro de cliente =====\n");

		System.out.println("C?digo: ");
        int codigo = sc.nextInt();
		
        System.out.println("Nome: ");
        String nome = sc.next();

        System.out.println("CPF: ");
        String cpf = sc.next();

        System.out.println("Data de nascimento: ");
        String dataNascimento = sc.next();

        Clientes cliente = new Clientes(codigo, nome, cpf, dataNascimento);

        return cliente;
	}	

	@Override
	public void AddCliente(Clientes cliente) {
		super.AddCliente(cliente);
	}
	
	@Override
	public String ListaClientes() {
		return super.ListaClientes();
	}
	
	@Override
	public String toString() {
		return "Clientes [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ "]";
	}
}
	
	
	