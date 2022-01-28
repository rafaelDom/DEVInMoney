package br.devinmoney.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.devinmoney.enums.Investimento;
import br.devinmoney.interfaces.IConta;
import br.devinmoney.interfaces.IContaInvestimento;

public class ContaInvestimento extends Conta implements IConta, IContaInvestimento{
private List<Transacao> extratoConta = new ArrayList<Transacao>();

	public ContaInvestimento(String nome, String cpf, Double rendaMensal, Agencia agencia,
			Double saldo) {
		super(nome, cpf, rendaMensal, agencia, saldo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean sacar(Double valor) {
		if(this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			return true;
		}
		return false;
	}

	@Override
	public boolean depositar(Double valor) {
		this.setSaldo(this.getSaldo() + valor);
		return true;
	}

	@Override
	public Double saldo() {
		return this.getSaldo();
	}

	@Override
	public void extrato() {
		for (Transacao t:extratoConta) {
			System.out.println(t.toString());
		}
	}

	@Override
	public boolean transferir(Conta contaOrigem, Conta contaDestino, Double valor){
		if(!contaDestino.equals(contaOrigem)) {
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean alterarDadosCadastrais(ContaCorrente contaCorrente) {
		if(contaCorrente.getCpf().equals(this.getCpf())) {
			this.setAgencia(contaCorrente.getAgencia());
			this.setConta(contaCorrente.getConta());
			this.setNome(contaCorrente.getNome());
			this.setRendaMensal(contaCorrente.getRendaMensal());
			return true;
		}
		
		return false;
	}

	
	@Override
	public void salvarTransacao(Transacao transacao) {
		extratoConta.add(transacao);
	}
	
	@Override
	public void rendimentoAnualInvestimento(Investimento investimento) {
		List<Investimento> listaInvestimento = Arrays.asList(Investimento.values());
		for (Investimento inv:listaInvestimento) {
			if(investimento.name() == inv.name()) {
				System.out.println("O investimento anual do " + investimento.name() + " é: " + investimento.getRendimentoAnual());
			}
		}
	}
	
	@Override
	public void simularRendimentoAnual(Investimento investimento) {
		Double valorRendimentoAnual;
		valorRendimentoAnual = this.getSaldo() * (investimento.getRendimentoAnual() / 100);
		
		System.out.println("O valor do rendimento anual para o investimento " + investimento.name() + " com a rentabilidade anual de " + investimento.getRendimentoAnual() + " é de: " + String.format("%.2f", valorRendimentoAnual));
		System.out.println("Com base no saldo atual de: " + this.getSaldo());
		
	}
	
	@Override
	public void realizarInvestimento(Investimento investimento, Double valor) {
		Double valorRendimentoAnual;
		valorRendimentoAnual = valor * (investimento.getRendimentoAnual() / 100);
		
		System.out.println("O valor do investimento é: " + valor + " com a rentabilidade anual de " + investimento.getRendimentoAnual());
		System.out.println("Esse valor renderá anualmente: " + String.format("%.2f", valorRendimentoAnual));
		
	}


}
