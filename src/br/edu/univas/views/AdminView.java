package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.services.AdminService;

public class AdminView {
	
	private AdminService adminService;
	
	public AdminView() {
		
	}
	
	public void painelAdm(Scanner scanner) {
		this.adminService = new AdminService();
		System.out.println("Bem-vindo ao Painel ADM \n");
		boolean continua = true;
		String opcao = "";
		do {
			this.menuPrincipal();
			opcao = scanner.nextLine();
			
			switch(opcao) {
			case "1":
				adminService.criarNovoProduto(scanner);
				break;
			
			case "2": 
				break;
				
			case "3":
				break;
				
			case "4":
				adminService.consultarProduto(scanner);
				break;
				
			case "0":
				continua = false;
				break;
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
	
}