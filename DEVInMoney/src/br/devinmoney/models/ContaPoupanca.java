package br.devinmoney.models;

import java.util.ArrayList;
import java.util.List;

import br.devinmoney.interfaces.IConta;
import br.devinmoney.interfaces.IRentabilidadePopupanca;

public class ContaPoupanca extends Conta implements IConta, IRentabilidadePopupanca {
	private List<Transacao> extratoConta = new ArrayList<Transacao>();

	public ContaPoupanca(String nome, String cpf, Double rendaMensal, Agencia agencia, Double saldo) {
		super(nome, cpf, rendaMensal, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sacar(Double valor) {
		if (this.getSaldo() >= valor) {
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
		for (Transacao t : extratoConta) {
			System.out.println(t.toString());
		}
	}

	@Override
	public boolean transferir(Conta contaOrigem, Conta contaDestino, Double valor) {
		if (!contaDestino.equals(contaOrigem)) {
			if (contaOrigem.getSaldo() >= valor) {
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
				return true;
			} else {
				System.out.println("Limite não autorizado para transferência!!!");
			}
		}
		return false;
	}

	@Override
	public boolean alterarDadosCadastrais(ContaCorrente contaCorrente) {
		if (contaCorrente.getCpf().equals(this.getCpf())) {
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
	public void calcularRendimento(int qtdeMes, Double rentabilidadeAnual) {
		Double rentabilidadeProporcinal = (rentabilidadeAnual / 12) * qtdeMes;
		Double valorRendimento;
		valorRendimento = this.getSaldo() * (rentabilidadeProporcinal / 100);

		System.out.println("O valor do rendimento no período de " + qtdeMes + " mese(s) com a rentabilidade anual de "
				+ rentabilidadeAnual + " para o saldo de " + this.getSaldo() + " é de R$ "
				+ String.format("%.2f", valorRendimento));

	}

}
