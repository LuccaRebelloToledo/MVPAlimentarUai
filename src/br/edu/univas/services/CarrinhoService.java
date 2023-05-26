package br.edu.univas.services;

import java.util.ArrayList;

import br.edu.univas.models.Produto;

public class CarrinhoService {
	
	private static ArrayList<Produto> dadosCarinho;
	
	public CarrinhoService() {
		if(dadosCarinho == null)
			dadosCarinho = new ArrayList<>();
	}

}