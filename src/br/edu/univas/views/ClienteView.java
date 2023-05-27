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
				"1- Consultar o carrinho de compras \n"+
				"2- Adicionar ao carrinho de compras \n"+
				"3- Editar/Excluir carrinho de compras \n"+
				"4- Efetuar pagamento do carrinho de compras \n"+
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
				carrinhoCliente(scanner);
				break;
			case "0":
				continua = false;
				break;	
			}
		} while (continua);
	}
	
	private void carrinhoCliente(Scanner scanner) {
		boolean continua = true;
		String opcao = "";
		this.clienteService = new ClienteService();
		do {
			menuCarrinho();
			opcao = scanner.nextLine();
			
			switch(opcao) {
				
			case "1":
				clienteService.consultarCarrinho();
				break;
			case "2":
				clienteService.adicionarProdutoAoCarrinho(scanner);
				break;
			case "3":
				clienteService.editarExcluirCarrinho(scanner);
				break;
			case "4":
				clienteService.efetuarPagamento(scanner);
				break;
			case "0":
				continua = false;
				break;
			default:
				System.out.println("Opção Inválida! \n");
				
			}
			
		} while(continua);
	}

}