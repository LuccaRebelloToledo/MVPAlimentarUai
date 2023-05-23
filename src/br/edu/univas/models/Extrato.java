package br.edu.univas.models;

public class Extrato extends Produto {
	
	private String clienteCPF;
	private double valorTotal;

	public Extrato(String clienteCPF, double valorTotal, String nomeProd, String marcaProd, int qtdeEstoqueProd, double precoVendaProd) {
		super(nomeProd, marcaProd, qtdeEstoqueProd, precoVendaProd);
		this.clienteCPF = clienteCPF;
		this.valorTotal = valorTotal;
	}
	
	public String getClienteCPF() {
		return this.clienteCPF;
	}
	public double getValorTotal() {
		return this.valorTotal;
	}

}