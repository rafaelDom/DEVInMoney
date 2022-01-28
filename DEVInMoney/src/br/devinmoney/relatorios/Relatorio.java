package br.devinmoney.relatorios;

import java.util.List;

import br.devinmoney.dao.DAOFake;
import br.devinmoney.interfaces.IRelatorio;
import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.ContaPoupanca;

public class Relatorio implements IRelatorio{
	
	@Override
	public void listarContasCorrente(List<ContaCorrente> listaContaCorrente) {
		for (Conta conta:listaContaCorrente) {
			System.out.println(conta.toString());
		}
	} 
	
	@Override
	public void listarContasPoupanca(List<ContaPoupanca> listaContaPoupanca) {
		for (Conta conta:listaContaPoupanca) {
			System.out.println(conta.toString());
		}
	} 
	
	@Override
	public void listarContasInvestimento(List<ContaInvestimento> listaContaInvestimento) {
		for (Conta conta:listaContaInvestimento) {
			System.out.println(conta.toString());
		}
	} 
	
	@Override
	public void listarContasCorrenteSaldoNegativo(List<ContaCorrente> listaConta) {
		for (Conta conta:listaConta) {
			if(conta.getSaldo() < 0) {
				System.out.println(conta.toString());
			}
		}
	}
	
	@Override
	public void listarContasPoupancaSaldoNegativo(List<ContaPoupanca> listaConta) {
		for (Conta conta:listaConta) {
			if(conta.getSaldo() < 0) {
				System.out.println(conta.toString());
			}
		}
	}
	
	@Override
	public void listarContasInvestimentoSaldoNegativo(List<ContaInvestimento> listaConta) {
		for (Conta conta:listaConta) {
			if(conta.getSaldo() < 0) {
				System.out.println(conta.toString());
			}
		}
	}
	@Override
	public void totalValorInvestido(List<Double> valoresInvestido) {
		Double totalValorInvestido = 0.0;
		for (int i = 0; i < valoresInvestido.size(); i++) {
			totalValorInvestido = totalValorInvestido + valoresInvestido.get(i);
		}
		
		System.out.println("O total do valor investido é R$ " + String.format("%.2f", totalValorInvestido));
	}
	
	@Override
	public void listarTransacoesCliente(Conta conta) {
		conta.extrato();
	}
	
	@Override
	public boolean transacoesCliente(Integer numeroConta) {
		for (ContaCorrente conta:DAOFake.contasCorrenteCadastradas) {
			if(conta.getConta().equals(numeroConta)) {
				conta.extrato();
				return true;
			}	
		}
		for (ContaPoupanca conta:DAOFake.contasPoupancaCadastradas) {
			if(conta.getConta().equals(numeroConta)) {
				conta.extrato();
				return true;
			}	
		}
		for (ContaInvestimento conta:DAOFake.contasInvestimentoCadastradas) {
			if(conta.getConta().equals(numeroConta)) {
				conta.extrato();
				return true;
			}	
		}
		return false;
	}
	
}
