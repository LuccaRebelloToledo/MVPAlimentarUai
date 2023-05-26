package br.edu.univas.services;

import java.util.ArrayList;

import br.edu.univas.models.Carrinho;
import br.edu.univas.models.Produto;

public class CarrinhoService {
	
	private static ArrayList<Carrinho> dadosCarrinho;
	
	public CarrinhoService() {
		if(dadosCarrinho == null)
			dadosCarrinho = new ArrayList<>();
	}
	
	public void adicionarAoCarrinho(Produto produto, int qtdeAComprarProd) {
			if(temNoCarrinho(produto))
				System.out.println("O produto já existe no carrinho! \n");
			else {
				Carrinho carrinho = new Carrinho(produto, qtdeAComprarProd);
				dadosCarrinho.add(carrinho);
				}
	}
	
	public boolean temNoCarrinho(Produto prodInformado) {
		for(Carrinho prodCarrinho : dadosCarrinho) {
			if(prodCarrinho.getCodProd() == prodInformado.getCodProd()) {
				return true;
			}
		}
		return false;
	}
	
	public void removerDoCarinho(int codProd) {
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
	
	public void deletarCarinho() {
		dadosCarrinho.removeAll(dadosCarrinho);	
	}
	
	public int count() {
		return dadosCarrinho.size();
	}

}