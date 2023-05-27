package br.edu.univas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.univas.models.Carrinho;
import br.edu.univas.models.Extrato;

public class ExtratoService {
	
	private static ArrayList<Extrato> dadosExtrato;
	
	public ExtratoService() {
		if(dadosExtrato == null)
			dadosExtrato = new ArrayList<>();
	}
	
	public void cadastrarExtrato(String clienteCPF, String formaDePagamento, Carrinho prodCarrinho) {
		Extrato produtoExtrato = new Extrato(clienteCPF, formaDePagamento, prodCarrinho);
		dadosExtrato.add(produtoExtrato);
	}
	
	public List<Object> consultarExtrato(){
		return Arrays.asList(dadosExtrato.clone());
	}
	
	private int count() {
		return dadosExtrato.size();
	}
	
	public boolean possuiExtrato() {
		if(count() > 0)
			return true;
		else
			return false;
	}

}
