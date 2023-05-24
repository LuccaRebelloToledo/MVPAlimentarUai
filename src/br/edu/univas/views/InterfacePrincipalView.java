package br.edu.univas.views;

import java.util.Scanner;

public class InterfacePrincipalView {
	
	private Scanner scanner;
	private AdminView admin;
	
	private void menuDeOpcoes() {
			System.out.println("Bem-vindo, escolha uma das opções para continuar :) \n"
					+ "1- Painel Adminstrador \n"
					+ "2- Painel Cliente \n"
					+ "0- Sair");			
	}
	
	public InterfacePrincipalView() {
		scanner = new Scanner(System.in);
		admin = new AdminView();
	}
	
	public void menuPrincipal() {
		
		String opcao = "";
		boolean continua = true;
		
		do {
			menuDeOpcoes();
			opcao = this.scanner.nextLine();
			switch(opcao) {
			case "1" -> {	
				admin.validacaoAdm();
				break;
				}
			case "0" -> {
				continua = false;
				break;
				}
			}
		} while(continua);
		
	}
}