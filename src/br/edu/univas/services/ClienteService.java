package br.edu.univas.services;

import java.util.Scanner;

import br.edu.univas.models.Produto;

public class ClienteService {
	
	private ProdutoService produtoService;
	private CarrinhoService carrinhoService;
	private ExtratoService extratoService;
	
	public ClienteService() {
		
	}
	
	public void consultarProdutos(Scanner scanner) {
		this.produtoService = new ProdutoService();
		if(produtoService.possuiProduto()) {
			System.out.println("Deseja procurar um produto específico? Se sim, informe o ID, caso contrario digite 0");
			int codProdInformado = scanner.nextInt();
			scanner.nextLine();
			
			if(codProdInformado == 0) 
				System.out.println(produtoService.consultar());
			 else 
				System.out.println(produtoService.consultar(codProdInformado));
			
		} else
			System.out.println("Nenhum produto encontrado! \n");
	}
	
	public void consultarCarrinho() {
		this.carrinhoService = new CarrinhoService();
		if(carrinhoService.possuiCarrinho())
			System.out.println(carrinhoService.consultarCarrinho());
		else
			System.out.println("O carrinho está vazio! \n");	
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
				System.out.println("Quantidade solicitada maior que a disponível no estoque! \n");
			else {
				this.carrinhoService = new CarrinhoService();
				carrinhoService.adicionarAoCarrinho(codProd, produto, qtdeAComprar);
			}	
		} else
				System.out.println("Produto não encontrado! \n");
	}
	
	public void editarExcluirCarrinho(Scanner scanner) {
		this.carrinhoService = new CarrinhoService();
		if(carrinhoService.possuiCarrinho()) {
		System.out.println(
				"Deseja editar ou excluir um produto? \n" +
				"1- Editar \n"+
				"2- Excluir");
		int escolha = scanner.nextInt();
		scanner.nextLine();
		if(escolha == 1) 
			editarProdCarrinho(scanner, carrinhoService);
		 else if (escolha == 2) 
			excluirProdCarrinho(scanner, carrinhoService);
		 else
			System.out.println("Escolha incorreta! \n");
		}
		else
			System.out.println("Você não possui nenhum item no carrinho! \n");
	}
	
	public void editarProdCarrinho(Scanner scanner, CarrinhoService carrinhoService) {
		System.out.print("Digite o código do produto que deseja editar: ");
		int codProd = scanner.nextInt();
		scanner.nextLine();	
		carrinhoService.editarProdCarrinho(codProd, scanner);	
	}
	
	public void excluirProdCarrinho(Scanner scanner, CarrinhoService carrinhoService) {
		System.out.print("Digite o código do produto que deseja excluir do carrinho: ");
		int codProd = scanner.nextInt();
		scanner.nextLine();
		carrinhoService.removerProdCarinho(codProd);
		System.out.println("Produto excluído do carrinho! \n");
	}
	
	public void efetuarPagamento(Scanner scanner) {
		carrinhoService = new CarrinhoService();
		if(carrinhoService.possuiCarrinho()) {
			System.out.println(carrinhoService.consultarCarrinho());
			System.out.println("Valor total do Carrinho: " + carrinhoService.totalCarrinhoFormatado());
			System.out.print("Deseja efetuar o pagamento do carrinho ('S' para SIM,'N' para não): ");
			String escolha = scanner.nextLine();
			if(escolha.toUpperCase().equals("S")) {
				System.out.println("Por favor digite seu CPF: ");
				String clienteCPF = scanner.nextLine();
				if(clienteCPF.length() != 11) {
					System.out.println("Por favor digite a forma de pagamento: ");
					String formaDePagamento = scanner.nextLine();
					this.extratoService = new ExtratoService();
					this.produtoService = new ProdutoService();
					carrinhoService.gerarExtrato(clienteCPF, formaDePagamento, extratoService, produtoService);
					System.out.println("Compra finalizada! \n");
				} else
					System.out.println("CPF Inválido! \n");
				
			}
		} else
			System.out.println("O carrinho está vazio! \n");
	}
}