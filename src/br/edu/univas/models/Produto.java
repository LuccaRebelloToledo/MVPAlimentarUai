package br.edu.univas.models;

import java.text.DecimalFormat;

public class Produto {
	
	private int codProd;
	private String nomeProd;
	private String marcaProd;
	private int qtdeEstoqueProd;
	private double precoVendaProd;
	private static int contadorCodProd = 0;
	
	public Produto(String nomeProd, String marcaProd, int qtdeEstoqueProd, double precoVendaProd) {
		this.codProd = ++Produto.contadorCodProd;
		this.nomeProd = nomeProd;
		this.marcaProd = marcaProd;
		this.qtdeEstoqueProd = qtdeEstoqueProd;
		this.precoVendaProd = precoVendaProd;
	}
	
	private Produto(int codProd, String nomeProd, String marcaProd, int qtdeEstoqueProd, double precoVendaProd) {
		this.codProd = codProd;
		this.nomeProd = nomeProd;
		this.marcaProd = marcaProd;
		this.qtdeEstoqueProd = qtdeEstoqueProd;
		this.precoVendaProd = precoVendaProd;
	}
	
	public Produto clone() {
		return new Produto(
				this.getCodProd(),
				this.getNomeProd(),
				this.getMarcaProd(),
				this.getQtdeEstoqueProd(),
				this.getPrecoVendaProd()
				);
	}
	
	public int getCodProd() {
		return this.codProd;
	}
	
	public String getNomeProd() {
		return this.nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	
	public String getMarcaProd() {
		return this.marcaProd;
	}
	public void setMarcaProd(String marcaProd) {
		this.marcaProd = marcaProd;
	}
	
	public int getQtdeEstoqueProd() {
		return this.qtdeEstoqueProd;
	}
	public void setQtdeEstoqueProd(int qtdeEstoqueProd) {
		this.qtdeEstoqueProd = qtdeEstoqueProd;
	}
	
	public double getPrecoVendaProd() {
		return this.precoVendaProd;
	}
	public void setPrecoVendaProd(double precoVendaProd) {
		this.precoVendaProd = precoVendaProd;
	}
	
	public String getPrecoVendaProdFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.getPrecoVendaProd());
	}
	
	@Override
	public boolean equals(Object obj) {
		Produto aux = (Produto)obj;
		return this.codProd == aux.getCodProd();
	}
	
	public String toString() {
		return 	"\n"+
				"Código: " + this.getCodProd() + "\n" +
				"Nome: " + this.getNomeProd() + "\n" +
				"Marca: " + this.getMarcaProd() + "\n" +
				"Quantidade no Estoque: " + this.getQtdeEstoqueProd() + "\n" +
				"Preço de Venda: " + this.getPrecoVendaProdFormatado();
	}
}
