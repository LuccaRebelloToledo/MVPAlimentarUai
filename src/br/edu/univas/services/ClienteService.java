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
	
	
	public void adicionarProdutoAoCarrinho(Scanner scanner) {
		System.out.print("Digite o código do produto: ");
		int codProd = scanner.nextInt();
		scanner.nextLine();
		
		produtoService = new ProdutoService();
		Produto produto = produtoService.consultar(codProd);
		if(produto != null) {
			System.out.print("Quantidade desejada: ");
			int qtdeAComprar = scanner.nextInt();
			scanner.nextLine();
			
			if(qtdeAComprar > produto.getQtdeEstoqueProd())
				System.out.println("Quantidade solicitada maior que a dispónivel no estoque! \n");
			else {
				carrinhoService = new CarrinhoService();
				carrinhoService.adicionarAoCarrinho(produto, qtdeAComprar);
			}
			
		} else
				System.out.println("Produto não encontrado! \n");
		}
}