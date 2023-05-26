package br.edu.univas.services;

public class ClienteService {
	
	private ProdutoService produtoService;
	
	public ClienteService() {
		
	}
	
	public void consultarProdutos() {
		produtoService = new ProdutoService();
		System.out.println(produtoService.consultar());
	}
	
}