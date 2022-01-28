
package br.devinmoney.dao;

import br.devinmoney.models.ContaPoupanca;

public class ContaPoupancaDAO {
	
	public boolean atualizarConta(ContaPoupanca contaPoupanca) {
		for (int i = 0; i < DAOFake.contasPoupancaCadastradas.size(); i++) {
			if(DAOFake.contasPoupancaCadastradas.get(i).getConta() == contaPoupanca.getConta()) {
				DAOFake.contasPoupancaCadastradas.set(i, contaPoupanca);
				return true;
			}	
		}
		return false;
	}
}
