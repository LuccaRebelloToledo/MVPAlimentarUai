package br.edu.univas.services;

import java.util.Scanner;

import br.edu.univas.models.Produto;

public class ClienteService {
	
	private ProdutoService produtoService;
	private CarrinhoService carrinhoService;
	
	public ClienteService() {
		
	}
	
	public void consultarProdutos(Scanner scanner) {
		this.produtoService = new ProdutoService();
		if(produtoService.count() == 0) {
			System.out.println("Nenhum produto encontrado! \n");
		} else {
		System.out.println("Deseja procurar um produto específico? Se sim, informe o ID, caso contrario digite 0");
		int codProdInformado = scanner.nextInt();
		scanner.nextLine();
		
		if(codProdInformado == 0) 
			System.out.println(produtoService.consultar());
		 else 
			System.out.println(produtoService.consultar(codProdInformado));
		}
	}
	
	public void consultarCarrinho() {
		this.carrinhoService = new CarrinhoService();
		System.out.println(carrinhoService.consultarCarrinho());
	}
	
	
	public void adicionarProdutoAoCarrinho(Scanner scanner) {
		System.out.print("Digite o código do produto: ");
		int codProd = scanner.nextInt();
		scanner.nextLine();
		
		this.produtoService = new ProdutoService();
		Produto produto = produtoService.consultar(codProd);
		if(produto != null) {
			System.out.print("Quantidade desejada: ");
			int qtdeAComprar = scanner.nextInt();
			scanner.nextLine();
			
			if(qtdeAComprar > produto.getQtdeEstoqueProd())
				System.out.println("Quantidade solicitada maior que a dispónivel no estoque! \n");
			else {
				this.carrinhoService = new CarrinhoService();
				carrinhoService.adicionarAoCarrinho(codProd, produto, qtdeAComprar);
			}	
		} else
				System.out.println("Produto não encontrado! \n");
	}
	
	public void editarExcluirCarrinho(Scanner scanner) {
		System.out.println(
				"Deseja editar ou excluir um produto? \n" +
				"1- Editar \n"+
				"2- Excluir");
		int escolha = scanner.nextInt();
		scanner.nextLine();
		if(escolha == 1) 
			editarProdCarrinho(scanner);
		 else if (escolha == 2) 
			excluirProdCarrinho(scanner);
		 else
			System.out.println("Escolha incorreta! \n");
	}
	
	public void editarProdCarrinho(Scanner scanner) {
		
	}
	
	public void excluirProdCarrinho(Scanner scanner) {
		
	}
	
	public void efetuarPagamento(Scanner scanner) {
		
	}
}