package br.devinmoney.dao;

import java.util.ArrayList;

import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaPoupanca;
import br.devinmoney.models.ContaInvestimento;

public class DAOFake {
	public static ArrayList<ContaCorrente> contasCorrenteCadastradas = new ArrayList<ContaCorrente>();
	public static ArrayList<ContaPoupanca> contasPoupancaCadastradas = new ArrayList<ContaPoupanca>();
	public static ArrayList<ContaInvestimento> contasInvestimentoCadastradas = new ArrayList<ContaInvestimento>();
	
}
