package br.edu.univas.views;

import java.util.Scanner;

public class AlimentarUai {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		iniciarAplicacao(scanner);
	}
	
	public static void iniciarAplicacao(Scanner scanner) {
		boolean continua = true;
		String escolha = "";
		do {
			System.out.println("Bem-vindo, escolha uma das opções para continuar :) \n"
					+ "1- Painel Adminstrador \n"
					+ "2- Painel Cliente \n"
					+ "0- Sair");
			escolha = scanner.next();
			switch(escolha) {
				default -> {
					System.out.println("Escolha Incorreta");
					break;
				}
				case "1" -> {
					System.out.println("PainelADM");
					break;
				}
				case "2" -> {
					System.out.println("Painel Cliente");
				}
				case "0" -> {
					System.out.println("Bye Bye");
					continua = false;
				}
			}
		} while (continua);
	}
}