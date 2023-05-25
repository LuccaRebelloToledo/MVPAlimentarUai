package br.edu.univas.services;

import java.util.Scanner;

import br.edu.univas.views.AdminView;
import br.edu.univas.views.InterfacePrincipalView;

public class AdminService {
	
	private ProdutoService produtoService;
	private String senhaAdm = "123456";
	private InterfacePrincipalView alimentarUai;
	private AdminView adminView;
	
	public AdminService() {
		
	}
	
	public void validacaoAdm(Scanner scanner) {
		System.out.print("Digite a senha pra acessar o painel admin: ");
		String senha = scanner.nextLine();
		
		if(senha.equals(senhaAdm)) {
			this.adminView = new AdminView();
			adminView.painelAdm(scanner);
		}
		 else 
			System.out.println("Senha Inválida!");
	}
	
	public void criarNovoProduto(Scanner scanner) {
		
		System.out.print("Nome do produto: ");
		String nomeProd = scanner.nextLine();
		
		System.out.print("Marca do produto: ");
		String marcaProd = scanner.nextLine();
		
		System.out.print("Qual a quantidade de estoque do produto: ");
		int qtdeEstoqueProd = scanner.nextInt();
		scanner.nextLine();
		if(qtdeEstoqueProd < 1) {
			this.alimentarUai = new InterfacePrincipalView();
			System.out.println("Não é possível cadastrar produtos com estoque abaixo ou igual a zero!");
			alimentarUai.menuPrincipal();
		}
		
		System.out.print("Qual seu preço de venda: ");
		double precoDeVendaProd = scanner.nextDouble();
		scanner.nextLine();
		if(precoDeVendaProd < 0) {
			this.alimentarUai = new InterfacePrincipalView();
			System.out.println("Não é possível cadastrar produtos com preço abaixo ou igual a zero!");
			alimentarUai.menuPrincipal();
		}
		this.produtoService = new ProdutoService();
		produtoService.cadastrarProduto(nomeProd, marcaProd, qtdeEstoqueProd, precoDeVendaProd);
		System.out.println("Produto Cadastrado");
	}
	
	public void consultarProduto(Scanner scanner) {
		this.produtoService = new ProdutoService();
		if(produtoService.count() == 0) {
			System.out.println("Nenhum produto encontrado! \n");
		} else {
		System.out.println("Deseja procurar um produto específico? Se sim, informe o ID, caso contrario digite 0");
		int resposta = scanner.nextInt();
		scanner.nextLine();
		
		if(resposta == 0) 
			System.out.println(produtoService.procurar());
		 else 
			System.out.println(produtoService.procurar(resposta));
		}
	}
}
