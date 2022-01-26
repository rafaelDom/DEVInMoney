package br.devinmoney.interfaces;

import br.devinmoney.enums.Investimento;

public interface IContaInvestimento {
	public void rendimentoAnualInvestimento(Investimento investimento);
	public void simularRendimentoAnual(Investimento investimento);
	public void realizarInvestimento(Investimento investimento, Double valor);
}
