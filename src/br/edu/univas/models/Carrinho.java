package br.edu.univas.models;

import java.text.DecimalFormat;

public class Carrinho {
	
	private Produto produto;
	private int codProd;
	private String nomeProd;
	private double precoVendaProd;
	private int qtdeDesejada;
	
	public Carrinho(Produto produto, int qtdeDesejada) {
		this.codProd = this.produto.getCodProd();
		this.nomeProd = this.produto.getNomeProd();
		this.qtdeDesejada = qtdeDesejada;
		this.precoVendaProd = this.produto.getPrecoVendaProd();
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public int getQtdeDesejada() {
		return this.qtdeDesejada;
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
	
	public String getPrecoVendaProdFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.getPrecoVendaProd());
	}

}
