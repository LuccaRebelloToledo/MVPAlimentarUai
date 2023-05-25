package br.edu.univas.views;

import java.util.Scanner;

public class ClienteView {
	
	public void painelCliente(Scanner scanner) {
		boolean continua = true;
		String opcao = "";
		do {
			this.menuPrincipal();
			opcao = scanner.nextLine();
			
			switch(opcao) {
			case "1":
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
	
	private void menuPrincipal() {
		System.out.println(
				"1- Listar Produtos \n" +
				"2- Carrinho \n" +
				"0- Início");
	}
	
	private void carrinho(Scanner scanner) {
		menuCarrinho();
	}
	
	private void menuCarrinho() {
		
	}

}
