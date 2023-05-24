package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.services.ProdutoService;

public class AdminView {
	
	private Scanner scanner;
	private ProdutoService manipulador;
	private String senhaAdm = "123456";
	
	public AdminView() {
		this.scanner = new Scanner(System.in);
		this.manipulador = new ProdutoService();
	}
	
	public void validacaoAdm() {
		System.out.println("Digite a senha pra acessar o painel admin");
		String senha = this.scanner.nextLine();
		
		if(senha.equals(senhaAdm)) 
			painelAdm();
		 else 
			System.out.println("Senha Inválida!");
	}
	
	private void painelAdm() {
		System.out.println("Bem-vindo ao Painel ADM \n");
		boolean continua = true;
		String opcao = "";
		do {
			menuPrincipal();
			opcao = this.scanner.nextLine();
			
			switch(opcao) {
			case "1" -> {
				criarNovoProduto();
				break;
			}
			case "2" -> { break; }
			case "3" -> { break; }
			case "4" -> {
				consultarProduto();
				break;
			}
			case "0" -> {
				continua = false;
				break;
				}
			}
			
		} while(continua);
	}
	
	private void menuPrincipal() {
		System.out.println("1- Cadastrar Produto");
		System.out.println("2- Editar Produto");
		System.out.println("3- Excluir Produto");
		System.out.println("4- Consultar Produto(s) \n");
		System.out.println("0- Início");
	}
	
	private void criarNovoProduto() {
		System.out.println("Cadastro de Produto");
		
		System.out.println("Nome do produto:");
		String nomeProd = this.scanner.nextLine();
		
		System.out.println("Marca do produto:");
		String marcaProd = this.scanner.nextLine();
		
		System.out.println("Qual a quantidade de estoque do produto?");
		int qtdeEstoqueProd = this.scanner.nextInt();
		if(qtdeEstoqueProd < 1) {
			InterfacePrincipalView alimentarUai = new InterfacePrincipalView();
			System.out.println("Não é possível cadastrar produtos com estoque abaixo ou igual a zero!");
			alimentarUai.menuPrincipal();
		}
		
		System.out.println("Qual seu preço de venda?");
		double precoDeVendaProd = this.scanner.nextDouble();
		
		manipulador.cadastrarProduto(nomeProd, marcaProd, qtdeEstoqueProd, precoDeVendaProd);
		System.out.println("Produto Cadastrado");
	}
	
	private void consultarProduto() {
		System.out.println("Deseja procurar um produto específico? Se sim, informe o ID, caso contrario digite 0");
		int resposta = this.scanner.nextInt();
		
		if(resposta == 0) 
			System.out.println(manipulador.procurar());
		 else 
			System.out.println(manipulador.procurar(resposta));
		
	}
}