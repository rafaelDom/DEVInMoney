package br.devinmoney.interfaces;

import java.util.List;

import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.ContaPoupanca;

public interface IRelatorio {
	public void listarContasCorrente(List<ContaCorrente> listaContaCorrente);
	public void listarContasPoupanca(List<ContaPoupanca> listaContaPoupanca);
	public void listarContasInvestimento(List<ContaInvestimento> listaContaInvestimento);
	public void listarContasCorrenteSaldoNegativo(List<ContaCorrente> listaConta);
	public void listarContasPoupancaSaldoNegativo(List<ContaPoupanca> listaConta);
	public void listarContasInvestimentoSaldoNegativo(List<ContaInvestimento> listaConta);
	public void totalValorInvestido(List<Double> valoresInvestido);
	public void listarTransacoesCliente(Conta conta);
	public boolean transacoesCliente(Integer numeroConta);
}
