package br.edu.univas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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