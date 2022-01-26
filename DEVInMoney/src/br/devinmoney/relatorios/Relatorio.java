package br.devinmoney.relatorios;

import java.util.List;

import br.devinmoney.models.Conta;

public class Relatorio {
	public void listarContas(List<Conta> listaConta) {
		for (Conta conta:listaConta) {
			System.out.println(conta.toString());
		}
	} 
	
	public void listarContasSaldoNegativo(List<Conta> listaConta) {
		for (Conta conta:listaConta) {
			if(conta.getSaldo() < 0) {
				System.out.println(conta.toString());
			}
		}
	}
	
	public void totalValorInvestido(List<Double> valoresInvestido) {
		Double totalValorInvestido = 0.0;
		for (int i = 0; i < valoresInvestido.size(); i++) {
			totalValorInvestido = totalValorInvestido + valoresInvestido.get(i);
		}
		
		System.out.println("O total do valor investido é: " + String.format("%.2f", totalValorInvestido));
	}
	
	public void listarTransacoesCliente(Conta conta) {
		conta.extrato();
	}
	
}
