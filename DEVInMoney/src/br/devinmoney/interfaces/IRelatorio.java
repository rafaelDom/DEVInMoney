package br.devinmoney.interfaces;

import java.util.List;

import br.devinmoney.models.Conta;

public interface IRelatorio {
	public void listarContas(List<Conta> listaConta);
	public void listarContasSaldoNegativo(List<Conta> listaConta);
	public void totalValorInvestido(List<Double> valoresInvestido);
	public void listarTransacoesCliente(Conta conta);
}
