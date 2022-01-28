package br.devinmoney.interfaces;

import br.devinmoney.enums.Investimento;
import br.devinmoney.models.ContaInvestimento;

public interface IContaInvestimento {
	public void rendimentoAnualInvestimento(Investimento investimento);
	public void simularRendimentoAnual(Investimento investimento);
	public boolean realizarInvestimento(ContaInvestimento conta,Investimento investimento, Double valor) ;
}
