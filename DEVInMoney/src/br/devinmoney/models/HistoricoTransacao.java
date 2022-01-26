package br.devinmoney.models;

import java.time.LocalDate;

public class HistoricoTransacao {
	private Conta contaOrigem;
	private Conta contaDestino;
	private Double valor;
	private LocalDate data;
	
	
	public HistoricoTransacao(Conta contaOrigem, Conta contaDestino, Double valor) {
		super();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.data = LocalDate.now();
	}
	
	public Conta getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public Conta getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "HistoricoTransacao [contaOrigem=" + contaOrigem.getConta() + ", contaDestino=" + contaDestino.getConta() + ", valor=" + valor
				+ ", data=" + data + "]";
	}
	
	
	
	
}
