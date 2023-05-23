package br.edu.univas.models;

public class Produto {
	
	protected int codProd;
	protected String nomeProd;
	protected String marcaProd;
	protected int qtdeEstoqueProd;
	protected double precoVendaProd;
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
	
	@Override
	public boolean equals(Object obj) {
		Produto aux = (Produto)obj;
		return this.codProd == aux.getCodProd();
	}
	
	public String toString() {
		return 
				"Produto \n" +
				"Código: " + this.getCodProd() + "\n" +
				"Nome: " + this.getNomeProd() + "\n" +
				"Marca: " + this.getMarcaProd() + "\n" +
				"Qtde Estoque: " + this.getQtdeEstoqueProd() + "\n" +
				"Preço de Venda: " + this.getPrecoVendaProd();
	}
}
