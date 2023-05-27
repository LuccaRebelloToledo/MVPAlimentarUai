package br.edu.univas.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.edu.univas.models.Carrinho;
import br.edu.univas.models.Produto;

public class CarrinhoService {
	
	private static ArrayList<Carrinho> dadosCarrinho;
	
	public CarrinhoService() {
		if(dadosCarrinho == null)
			dadosCarrinho = new ArrayList<>();
	}
	
	public void adicionarAoCarrinho(int codProd, Produto produto, int qtdeAComprarProd) {
			if(temNoCarrinho(codProd))
				System.out.println("O produto já existe no carrinho! \n");
			else {
				Carrinho carrinho = new Carrinho(produto, qtdeAComprarProd);
				dadosCarrinho.add(carrinho);
				}
	}
	
	public boolean temNoCarrinho(int prodInformado) {
		for(Carrinho prodCarrinho : dadosCarrinho) {
			if(prodCarrinho.getCodProd() == prodInformado) {
				return true;
			}
		}
		return false;
	}
	
	public List<Object> consultarCarrinho(){
		return Arrays.asList(dadosCarrinho.clone());
	}
	
	public void editarProdCarrinho(int codProd, Scanner scanner) {		
		Carrinho prodParaEditar = null;
		for(Carrinho prodCarrinho : dadosCarrinho) {
			if(prodCarrinho.getCodProd() == codProd) {
				prodParaEditar = prodCarrinho;
			}
		}
		if(prodParaEditar != null) {
			System.out.println("Quantidade atual do produto no carrinho: " + prodParaEditar.getQtdeAComprarProd());
			System.out.print("Qual a nova quantidade do produto: ");
			prodParaEditar.setQtdeAComprarProd(scanner.nextInt());
			scanner.nextLine();
			atualizar(prodParaEditar);
		} else
			System.out.println("Produto não encontrado no carrinho! \n");
	}
	
	public void removerProdCarinho(int codProd) {
		Carrinho produtoASerExcluido = null;
		for(Carrinho prodCarrinho : dadosCarrinho) {
			if(prodCarrinho.getCodProd() == codProd) {
				produtoASerExcluido = prodCarrinho;
			}
		}
		if(produtoASerExcluido != null) 
			dadosCarrinho.remove(produtoASerExcluido);
		else
			System.out.println("Produto nao encontrado no carrinho! \n");
	}
	
	public void atualizar(Carrinho produtoInformado) {
		for(Carrinho prod : dadosCarrinho) {
			if(prod.getCodProd() == produtoInformado.getCodProd()) {
				prod.setQtdeAComprarProd(produtoInformado.getQtdeAComprarProd());
				prod.setPrecoTotal(produtoInformado.getQtdeAComprarProd());
			}
		}
	}
	
	public double totalCarrinho() {
		double valorTotal = 0;
		for(Carrinho prod : dadosCarrinho) {
			valorTotal += prod.getPrecoTotal();
		}
		return valorTotal;
	}
	
	public String totalCarrinhoFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(totalCarrinho());
	}
	
	public boolean validaQtdeDisponivelParaCompra() {
		return false;
	}
	
	public void deletarCarinho() {
		dadosCarrinho.removeAll(dadosCarrinho);	
	}
	
	private int count() {
		return dadosCarrinho.size();
	}
	
	public boolean possuiCarrinho() {
		if(count() > 0)
			return true;
		else
			return false;
	}

}