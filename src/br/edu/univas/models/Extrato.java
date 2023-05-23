package br.edu.univas.models;

public class Extrato {
	
	private String clienteCPF;
	private double valorTotal;
	private Produto produto;
	
	public Extrato(String clienteCPF, Produto produto, double valorTotal) {
		this.clienteCPF = clienteCPF;
		this.produto = produto;
		this.valorTotal = valorTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public String getClienteCPF() {
		return clienteCPF;
	}
	
}