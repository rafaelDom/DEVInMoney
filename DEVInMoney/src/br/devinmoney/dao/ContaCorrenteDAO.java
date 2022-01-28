
package br.devinmoney.dao;

import br.devinmoney.models.ContaCorrente;

public class ContaCorrenteDAO {
	
	public boolean atualizarConta(ContaCorrente contaCorrente) {
		for (int i = 0; i < DAOFake.contasCorrenteCadastradas.size(); i++) {
			if(DAOFake.contasCorrenteCadastradas.get(i).getConta() == contaCorrente.getConta()) {
				DAOFake.contasCorrenteCadastradas.set(i, contaCorrente);
				return true;
			}	
		}
		return false;
	}
}
