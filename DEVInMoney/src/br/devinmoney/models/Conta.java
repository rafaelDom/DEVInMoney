package br.devinmoney.models;

import java.util.Objects;

import br.devinmoney.utils.GeradorConta;

public abstract class Conta {
	private String nome;
	private String cpf;
	private Double rendaMensal;
	private Integer conta = 0;
	private Agencia agencia;
	private Double saldo;
	
	
	
	public Conta(String nome, String cpf, Double rendaMensal, Agencia agencia, Double saldo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rendaMensal = rendaMensal;
		this.conta = this.conta + 1;
		this.agencia = agencia;
		this.saldo = saldo;
		this.conta = GeradorConta.getProximaConta();
	}
	
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
	public Integer getConta() {
		return conta;
	}
	public void setConta(Integer conta) {
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

	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", cpf=" + cpf + ", rendaMensal=" + rendaMensal + ", conta=" + conta
				+ ", agencia=" + agencia + ", saldo=" + saldo + "]";
	}
	
	public void extrato() {
	}

	
}
