package br.devinmoney.interfaces;

import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.Transacao;

public interface IConta {
	public boolean sacar(Double valor);
	public boolean depositar(Double valor);
	public Double saldo();
	public void salvarTransacao(Transacao transacao);
	public boolean transferir(Conta conta, Double valor);
	public boolean alterarDadosCadastrais(ContaCorrente contaCorrente);
}
