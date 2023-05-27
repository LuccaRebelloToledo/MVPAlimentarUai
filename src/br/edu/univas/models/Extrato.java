package br.edu.univas.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extrato {
	
	private String clienteCPF;
	private int codProd;
	private String nomeProd;
	private double precoVendaProd;
	private double valorTotal;
	private int qtdeComprada;
	private String formaDePagamento;
	private Date dataVenda;

	public Extrato(String clienteCPF, String formaDePagamento, Carrinho prodCarrinho) {
			this.clienteCPF = clienteCPF;
			this.formaDePagamento = formaDePagamento;
			this.codProd = prodCarrinho.getCodProd();
			this.nomeProd = prodCarrinho.getNomeProd();
			this.precoVendaProd = prodCarrinho.getPrecoVendaProd();
			this.qtdeComprada = prodCarrinho.getQtdeAComprarProd();
			this.valorTotal = prodCarrinho.getPrecoTotal();
			this.dataVenda = new Date();
	}
	
	public String getClienteCPF() {
		return this.clienteCPF;
	}
	
	public Date getDataVenda() {
		return this.dataVenda;
	}
	
	public double getPrecoVendaProd() {
		return this.precoVendaProd;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}

	public int getQtdeComprada() {
		return this.qtdeComprada;
	}
	
	public int getCodProd() {
		return this.codProd;
	}

	public String getNomeProd() {
		return this.nomeProd;
	}

	public String getDataVendaFormatada() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatador.format(this.getDataVenda());
	}
	
	public String getPrecoVendaProdFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.getPrecoVendaProd());
	}
	
	public String getPrecoVendaTotalFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.getValorTotal());
	}

	public String toString() {
		return
				"CPF Comprador: " + this.getClienteCPF() + " | " +
				"Código do produto: " + this.getCodProd() + " | " +
				"Nome do produto: " + this.getNomeProd() + " | " +
				"Qtde Comprada: " + this.getQtdeComprada() + " | " +
				"Valor unitário do produto: " + this.getPrecoVendaProdFormatado() + " | " +
				"Valor Total da Venda: " + this.getPrecoVendaTotalFormatado() + " | " +
				"Data/Hora da Venda:" + this.getDataVendaFormatada() + " | " +
				"Forma de Pagamento: " + this.getFormaDePagamento() + "\n";
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Extrato aux = (Extrato)obj;
		return this.getCodProd() == aux.getCodProd();
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	
}