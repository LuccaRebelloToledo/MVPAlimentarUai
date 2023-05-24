package br.edu.univas.models;

public class Extrato {
	
	private String clienteCPF;
	private double valorTotal;
	private String nomeProd;
	private int qtdeCompradaProd;
	private double precoVendaProd;

	public Extrato(String clienteCPF, String nomeProd, int qtdeCompradaProd, double precoVendaProd) {
			this.clienteCPF = clienteCPF;
			this.nomeProd = nomeProd;
			this.qtdeCompradaProd = qtdeCompradaProd;
			this.precoVendaProd = precoVendaProd;
			this.valorTotal = qtdeCompradaProd * precoVendaProd;
	}
	
	public String getClienteCPF() {
		return this.clienteCPF;
	}
	public double getValorTotal() {
		return this.valorTotal;
	}

	public String getNomeProd() {
		return this.nomeProd;
	}

	public int getQtdeCompradaProd() {
		return this.qtdeCompradaProd;
	}

	public double getPrecoVendaProd() {
		return this.precoVendaProd;
	}

}