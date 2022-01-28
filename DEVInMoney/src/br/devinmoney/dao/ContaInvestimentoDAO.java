
package br.devinmoney.dao;

import br.devinmoney.models.ContaInvestimento;

public class ContaInvestimentoDAO {
	
	public boolean atualizarConta(ContaInvestimento contaInvestimento) {
		for (int i = 0; i < DAOFake.contasInvestimentoCadastradas.size(); i++) {
			if(DAOFake.contasInvestimentoCadastradas.get(i).getConta() == contaInvestimento.getConta()) {
				DAOFake.contasInvestimentoCadastradas.set(i, contaInvestimento);
				return true;
			}	
		}
		return false;
	}
}
