package br.edu.univas.models;

import java.text.DecimalFormat;

public class Carrinho {
	
	private Produto produto;
	private int codProd;
	private String nomeProd;
	private double precoVendaProd;
	private int qtdeAComprarProd;
	private double precoTotal;
	
	public Carrinho(Produto produto, int qtdeAComprarProd) {
		this.codProd = this.produto.getCodProd();
		this.nomeProd = this.produto.getNomeProd();
		this.qtdeAComprarProd = qtdeAComprarProd;
		this.precoVendaProd = this.produto.getPrecoVendaProd();
		this.precoTotal = qtdeAComprarProd*this.produto.getPrecoVendaProd();
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public int getQtdeAComprarProd() {
		return this.qtdeAComprarProd;
	}

	public int getCodProd() {
		return this.codProd;
	}

	public String getNomeProd() {
		return this.nomeProd;
	}

	public double getPrecoVendaProd() {
		return this.precoVendaProd;
	}
	
	public double getPrecoTotal() {
		return this.precoTotal;
	}
	
	public String getPrecoVendaProdFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.getPrecoVendaProd());
	}
	public String getPrecoVendaProdTotalFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.getPrecoTotal());
	}
	
	public String toString() {
		return
				"\n" +
				"Código: " + this.getCodProd() +
				"Nome: " + this.getNomeProd() +
				"Quantidade: " + this.getQtdeAComprarProd() +
				"Preço: " + this.getPrecoVendaProdTotalFormatado();
	}
	
	@Override
	public boolean equals(Object obj) {
		Carrinho aux = (Carrinho)obj;
		return this.codProd == aux.getCodProd();
	}
}
