package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.services.AdminService;
import br.edu.univas.services.ClienteService;

public class InterfacePrincipalView {
	
	private Scanner scanner;
	private AdminService adminService;
	private ClienteService clienteService;
	
	private void menuDeOpcoes() {
			System.out.println("Bem-vindo, escolha uma das opções para continuar :)"
					+ "\n"
					+ "1- Painel Adminstrador \n"
					+ "2- Painel Cliente \n"
					+ "0- Sair");			
	}
	
	public InterfacePrincipalView() {
		this.scanner = new Scanner(System.in);
	}
	
	public void menuPrincipal() {
		
		String opcao = "";
		boolean continua = true;
		
		do {
			menuDeOpcoes();
			opcao = this.scanner.nextLine();
			
			switch(opcao) {
			
			case "1":
				this.adminService = new AdminService();
				adminService.validacaoAdm(scanner);
				break;
				
			case "2":
				this.clienteService = new ClienteService();
				clienteService.teste();
				break;
				
			case "0": 
				continua = false;
				break;			
			}
			
		} while(continua);
		
	}
}