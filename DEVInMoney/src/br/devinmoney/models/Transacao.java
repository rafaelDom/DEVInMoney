package br.devinmoney.models;

import java.time.LocalDate;

public class Transacao {
	private LocalDate data;
	private Conta contaOrigem;
	private Conta contaDestino;
	private Double valor;
	private String tipo;
	
	public Transacao(LocalDate data, Conta contaOrigem, Conta contaDestino, Double valor, String tipo) {
		super();
		this.data = data;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Transacao [data=" + data + ", contaOrigem=" + contaOrigem.getConta() + ", contaDestino=" + contaDestino.getConta()
				+ ", valor=" + valor + ", tipo=" + tipo + "]";
	}
	
	


	
	
	
}
