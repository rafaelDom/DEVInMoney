package br.devinmoney.models;

import java.util.ArrayList;
import java.util.List;

import br.devinmoney.interfaces.IChequeEspecial;
import br.devinmoney.interfaces.IConta;

public class ContaCorrente extends Conta implements IConta, IChequeEspecial{
	private List<Transacao> extratoConta = new ArrayList<Transacao>();
	
	public ContaCorrente(String nome, String cpf, Double rendaMensal, Agencia agencia, Double saldo) {
		super(nome, cpf, rendaMensal, agencia, saldo);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public boolean sacar(Double valor) {
		if(this.getSaldo() + this.limiteChequeEspecial(this.getRendaMensal()) >= valor) {
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
	public boolean transferir(Conta conta, Double valor) {
		if(!conta.equals(this)) {
			conta.setSaldo(conta.getRendaMensal() + valor);
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
	public Double limiteChequeEspecial(Double rendaMensal) {
		return rendaMensal =  rendaMensal * 1.2;
	}

	@Override
	public void salvarTransacao(Transacao transacao) {
		extratoConta.add(transacao);
	}
	
	

}
