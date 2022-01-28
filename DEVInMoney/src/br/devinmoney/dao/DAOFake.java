package br.devinmoney.dao;

import java.util.ArrayList;


import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaPoupanca;
import br.devinmoney.models.ContaInvestimento;

public class DAOFake {
	public static ArrayList<ContaCorrente> contasCorrenteCadastradas = new ArrayList<ContaCorrente>();
	public static ArrayList<ContaPoupanca> contasPoupancaCadastradas = new ArrayList<ContaPoupanca>();
	public static ArrayList<ContaInvestimento> contasInvestimentoCadastradas = new ArrayList<ContaInvestimento>();

	
	public static boolean atualizarSaldo(Conta conta) {
		for (int i = 0; i < DAOFake.contasCorrenteCadastradas.size(); i++) {
			if(DAOFake.contasCorrenteCadastradas.get(i).getConta() == conta.getConta()) {
				DAOFake.contasCorrenteCadastradas.set(i, (ContaCorrente) conta);
				return true;
			}	
		}
		for (int i = 0; i < DAOFake.contasPoupancaCadastradas.size(); i++) {
			if(DAOFake.contasPoupancaCadastradas.get(i).getConta() == conta.getConta()) {
				DAOFake.contasPoupancaCadastradas.set(i, (ContaPoupanca) conta);
				return true;
			}	
		}
		for (int i = 0; i < DAOFake.contasInvestimentoCadastradas.size(); i++) {
			if(DAOFake.contasInvestimentoCadastradas.get(i).getConta() == conta.getConta()) {
				DAOFake.contasInvestimentoCadastradas.set(i, (ContaInvestimento) conta);
				return true;
			}	
		}
		return false;
	}
}
