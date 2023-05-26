package br.edu.univas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.univas.models.Extrato;
import br.edu.univas.models.Produto;

public class ExtratoService {
	
	private static ArrayList<Extrato> dadosExtrato;
	
	public ExtratoService() {
		if(dadosExtrato == null)
			dadosExtrato = new ArrayList<>();
	}
	
	public void cadastrarExtrato(String clienteCPF, String nomeProd, Produto produto, int qtdeComprada) {
		Extrato produtoExtrato = new Extrato(clienteCPF, nomeProd, produto, qtdeComprada);
		dadosExtrato.add(produtoExtrato);
	}
	
	public List<Object> consultarExtrato(){
		return Arrays.asList(dadosExtrato.clone());
	}
	
	public int count() {
		return dadosExtrato.size();
	}

}
