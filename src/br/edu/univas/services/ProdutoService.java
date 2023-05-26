package br.edu.univas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.univas.models.Produto;

public class ProdutoService {
	
	private static ArrayList<Produto> dadosProd;
	
	public ProdutoService() {
		if(dadosProd == null)
			dadosProd = new ArrayList<>();
	}
	
	public void cadastrarProduto(String nomeProd, String marcaProd, int qtdeEstoqueProd, double precoVendaProd) {
		Produto produto = new Produto(nomeProd.trim(), marcaProd.trim(), qtdeEstoqueProd, precoVendaProd);
		dadosProd.add(produto);
	}
	
	public Produto consultar(int codProd) {
		for(Produto prod : dadosProd) {
			if(prod.getCodProd() == codProd) {
				return prod.clone();
			}
		}
		return null;
	}
	
	public List<Object> consultar(){
		return Arrays.asList(dadosProd.clone());
	}
	
	public void atualizar(Produto produtoInformado) {
		for(Produto prod : dadosProd) {
			if(prod.getCodProd() == produtoInformado.getCodProd()) {
				prod.setNomeProd(produtoInformado.getNomeProd());
				prod.setMarcaProd(produtoInformado.getMarcaProd());
				prod.setQtdeEstoqueProd(produtoInformado.getQtdeEstoqueProd());
				prod.setPrecoVendaProd(produtoInformado.getPrecoVendaProd());
			}
		}
	}
	
	public void deletar(int codProd) {
		Produto produtoASerExcluido = null;
		for(Produto prod : dadosProd) {
			if(prod.getCodProd() == codProd) {
				produtoASerExcluido = prod;
			}
		}
		if(produtoASerExcluido != null) {
			dadosProd.remove(produtoASerExcluido);
		}
	}
	
	public int count() {
		return dadosProd.size();
	}
	
}