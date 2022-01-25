package br.devinmoney.models;

import java.util.Objects;

public abstract class Conta {
	private String nome;
	private String cpf;
	private Double rendaMensal;
	private String conta;
	private Agencia agencia;
	private Double saldo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getRendaMensal() {
		return rendaMensal;
	}
	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(agencia, conta, cpf, nome, rendaMensal, saldo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(conta, other.conta)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome)
				&& Objects.equals(rendaMensal, other.rendaMensal) && Objects.equals(saldo, other.saldo);
	}
}
