package br.edu.univas.services;

import java.util.Scanner;

import br.edu.univas.models.Carrinho;
import br.edu.univas.models.Produto;
import br.edu.univas.views.AdminView;
import br.edu.univas.views.InterfacePrincipalView;

public class AdminService {
	
	private ProdutoService produtoService;
	private ExtratoService extratoService;
	private String senhaAdm = "123456";
	private InterfacePrincipalView alimentarUai;
	private AdminView adminView;
	private CarrinhoService carrinhoService;
	
	public AdminService() {
		
	}
	
	public void validacaoAdm(Scanner scanner) {
		System.out.print("Digite a senha pra acessar o painel admin: ");
		String senha = scanner.nextLine();
		
		if(senha.equals(senhaAdm)) {
			this.adminView = new AdminView();
			adminView.painelAdm(scanner);
		}
		 else 
			System.out.println("Senha Inválida!");
	}
	
	public void criarNovoProduto(Scanner scanner) {
		
		System.out.print("Nome do produto: ");
		String nomeProd = scanner.nextLine();
		
		System.out.print("Marca do produto: ");
		String marcaProd = scanner.nextLine();
		
		System.out.print("Qual a quantidade de estoque do produto: ");
		int qtdeEstoqueProd = scanner.nextInt();
		scanner.nextLine();
		if(qtdeEstoqueProd < 1) {
			this.alimentarUai = new InterfacePrincipalView();
			System.out.println("Não é possível cadastrar produtos com estoque abaixo ou igual a zero!");
			alimentarUai.menuPrincipal();
		}
		
		System.out.print("Qual seu preço de venda: ");
		double precoDeVendaProd = scanner.nextDouble();
		scanner.nextLine();
		if(precoDeVendaProd < 0) {
			this.alimentarUai = new InterfacePrincipalView();
			System.out.println("Não é possível cadastrar produtos com preço abaixo ou igual a zero!");
			alimentarUai.menuPrincipal();
		}
		this.produtoService = new ProdutoService();
		produtoService.cadastrarProduto(nomeProd, marcaProd, qtdeEstoqueProd, precoDeVendaProd);
		System.out.println("Produto cadastrado! \n");
	}
	
	public void editarProduto(Scanner scanner){
		this.produtoService = new ProdutoService();
		if(produtoService.possuiProduto()) {
			System.out.print("Digite o ID do produto que deseja editar: ");
			int codProdInformado = scanner.nextInt();
			scanner.nextLine();
			ProdutoService produto = new ProdutoService();
			Produto prodEncontrado = produto.consultar(codProdInformado);
			if(prodEncontrado != null) {
				int escolha = 0;
				escolha = this.desejaAlterar("Você deseja alterar o nome do produto: ", scanner);
				if(escolha == 1) {
					System.out.print("Digite o novo nome do produto: ");
					prodEncontrado.setNomeProd(scanner.nextLine());
				}
				
				escolha = 0;
				escolha = this.desejaAlterar("Você deseja alterar a marca do produto: ", scanner);
				if(escolha == 1) {
					System.out.print("Digite a nova marca do produto: ");
					prodEncontrado.setMarcaProd(scanner.nextLine());
				}
				
				escolha = 0;
				escolha = this.desejaAlterar("Você deseja alterar o estoque atual do produto: ", scanner);
				if(escolha == 1) {
					System.out.print("Digite a nova quantidade de estoque do produto: ");
					prodEncontrado.setQtdeEstoqueProd(scanner.nextInt());
					scanner.nextLine();
				}
				
				this.carrinhoService = new CarrinhoService();
				Carrinho prodNoCarrinho = carrinhoService.prodCarrinho(prodEncontrado.getCodProd());
				if(prodNoCarrinho != null) {
					if(prodEncontrado.getQtdeEstoqueProd() < prodNoCarrinho.getQtdeAComprarProd()) {
						prodNoCarrinho.setQtdeAComprarProd(prodEncontrado.getQtdeEstoqueProd());
						carrinhoService.atualizar(prodNoCarrinho);
					}
				}
				
				escolha = 0;
				escolha = this.desejaAlterar("Você deseja alterar o preço de venda do produto: ", scanner);
				if(escolha == 1) {
					System.out.print("Digite o novo preço de venda do produto: ");
					prodEncontrado.setPrecoVendaProd(scanner.nextDouble());
					scanner.nextLine();
				}
				
				produto.atualizar(prodEncontrado);
				System.out.println("Produto atualizado! \n");
			} 
			else 
				System.out.println("Produto não encontrado \n");
		} 	else 
				System.out.println("Cadastre um produto primeiro! \n");
}
	
	public void excluirProduto(Scanner scanner) {
		this.produtoService = new ProdutoService();
		if(produtoService.possuiProduto()) {
			System.out.print("Digite o ID do produto que deseja excluir: ");
			int codProdInformado = scanner.nextInt();
			scanner.nextLine();
			ProdutoService produto = new ProdutoService();
			Produto prodEncontrado = produto.consultar(codProdInformado);
			if(prodEncontrado != null) {
				produto.deletar(codProdInformado);
				System.out.println("Produto excluído! \n");
			}
			else
				System.out.println("Produto não encontrado! \n");
			
		} else 
			System.out.println("Cadastre um produto primeiro! \n");
	}
	
	public void consultarProduto(Scanner scanner) {
		this.produtoService = new ProdutoService();
		if(produtoService.possuiProduto()) {
			System.out.println("Deseja procurar um produto específico? Se sim, informe o ID, caso contrario digite 0");
			int codProdInformado = scanner.nextInt();
			scanner.nextLine();
			
			if(codProdInformado == 0) 
				System.out.println(produtoService.consultar());
			 else {
				 Produto prodSolicitado = produtoService.consultar(codProdInformado);
				 if(prodSolicitado != null) 
					 System.out.println(produtoService.consultar(codProdInformado));
				 else
					 System.out.println("Produto inexistente! \n");
			 }
				
			
		} else
			System.out.println("Nenhum produto encontrado! \n");	
	}
	
	public void consultarExtrato() {
		extratoService = new ExtratoService();
		if(extratoService.possuiExtrato())
			System.out.println(extratoService.consultarExtrato());	
		else
			System.out.println("Ainda não foi realizado nenhuma venda! \n");
	}
	
 	private int desejaAlterar(String msgDesejada, Scanner scanner) {
 		System.out.print(msgDesejada + " (1 = Sim, 0 = Nao): ");
 		int escolha = scanner.nextInt();
 		scanner.nextLine();	
 		return escolha;
 	}
}
