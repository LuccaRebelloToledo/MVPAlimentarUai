package br.edu.univas.services;

import java.util.ArrayList;

import br.edu.univas.models.Extrato;

public class ClienteService {
	
	private static ArrayList<Extrato> dadosCarinho;
	
	public ClienteService() {
		if(dadosCarinho == null)
			dadosCarinho = new ArrayList<>();
	}
	
}
