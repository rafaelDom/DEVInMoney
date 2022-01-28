package br.devinmoney.validator;

import br.devinmoney.dao.DAOFake;
import br.devinmoney.models.ContaCorrente;

public class Validator {

	public boolean validaNome(String nome) {
		return nome.matches("([a-zA-Z]{3,}+\\s+[a-zA-Z]{3,})((\\s+[a-zA-Z]{3,})*)");
	}

	public boolean validaValor(String rendaMensal) {
		return rendaMensal.matches("^(0|[1-9]\\d{0,2}(\\d{3})*)\\.\\d{2}$");
	}
	
	public ContaCorrente contaCorrenteCadastrada(Integer numeroConta) {
		for(ContaCorrente conta:DAOFake.contasCorrenteCadastradas) {
			if(conta.getConta().equals(numeroConta)) {
				System.out.println("Numero de conta Existente");
				return conta;
			}	
		}
		return null;
	}
}
