package br.edu.univas.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extrato {
	
	private String clienteCPF;
	private double valorTotal;
	private int qtdeComprada;
	private Produto produto;
	private Date dataVenda;

	public Extrato(String clienteCPF, String nomeProd, Produto produto, int qtdeComprada) {
			this.clienteCPF = clienteCPF;
			this.valorTotal = this.produto.getPrecoVendaProd() * this.qtdeComprada;
			this.dataVenda = new Date();
	}
	
	public String getClienteCPF() {
		return this.clienteCPF;
	}
	public double getValorTotal() {
		return this.valorTotal;
	}

	public int getQtdeComprada() {
		return this.qtdeComprada;
	}
	
	public Date getDataVenda() {
		return this.dataVenda;
	}
	
	public String getDataVendaFormatada() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatador.format(this.getDataVenda());
	}
	
	public String getPrecoVendaProdFormatado() {
		DecimalFormat precoFormatado = new DecimalFormat();
		precoFormatado.applyPattern("R$ #,##0.00");
		return precoFormatado.format(this.produto.getPrecoVendaProd());
	}

	public String toString() {
		return
				"\n" +
				"CPF Comprador: " + this.getClienteCPF() +
				"Produto: " + this.produto.getNomeProd() +
				"Qtde Comprada: " + this.getQtdeComprada() +
				"Valor da Venda: " + this.getPrecoVendaProdFormatado() +
				"Data/Hora da Venda:" + this.getDataVendaFormatada();
		
	}
	
}