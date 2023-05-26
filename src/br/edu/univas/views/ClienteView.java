package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.services.ClienteService;

public class ClienteView {
	
	private ClienteService clienteService;
	
	
	private void menuPrincipal() {
		System.out.println(
				"1- Listar Produtos \n" +
				"2- Carrinho \n" +
				"0- Início");
	}
	
	private void menuCarrinho() {
		System.out.println(
				"1- Adicionar ao carrinho \n"+
				"0- Voltar");
	}
	
	public void painelCliente(Scanner scanner) {
		boolean continua = true;
		String opcao = "";
		do {
			this.menuPrincipal();
			opcao = scanner.nextLine();
			
			switch(opcao) {
			case "1":
				this.clienteService = new ClienteService();
				clienteService.consultarProdutos(scanner);
				break;
			case "2":
				carrinho(scanner);
				break;
			case "0":
				continua = false;
				break;	
			}
		} while (continua);
	}
	
	private void carrinho(Scanner scanner) {
		boolean continua = true;
		String opcao = "";
		do {
			menuCarrinho();
			opcao = scanner.nextLine();
			
			switch(opcao) {
				
			case "1":
				this.clienteService = new ClienteService();
				clienteService.adicionarProdutoAoCarrinho(scanner);
				break;
			case "0":
				break;
			default:
				System.out.println("Opção Inválida! \n");
				
			}
			
		} while(continua);
	}

}