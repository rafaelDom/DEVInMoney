package br.devinmoney.validator;

import br.devinmoney.dao.DAOFake;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.ContaPoupanca;

public class Validator {

	public boolean validaNome(String nome) {
		return nome.matches("([a-zA-Z]{3,}+\\s+[a-zA-Z]{3,})((\\s+[a-zA-Z]{3,})*)");
	}

	public boolean validaValor(String valor) {
		return valor.matches("^(0|[1-9]\\d{0,2}(\\d{3})*)\\.\\d{2}$");
	}
	
	public boolean validaRentabilidadeAnual(String valor) {
		return valor.matches("^(0|\\d{1,100})\\.(\\d{0,100})$");
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
	
	public ContaPoupanca contaPoupancaCadastrada(Integer numeroConta) {
		for(ContaPoupanca conta:DAOFake.contasPoupancaCadastradas) {
			if(conta.getConta().equals(numeroConta)) {
				System.out.println("Numero de conta Existente");
				return conta;
			}	
		}
		return null;
	}
	
	public ContaInvestimento contaInvestimentoCadastrada(Integer numeroConta) {
		for(ContaInvestimento conta:DAOFake.contasInvestimentoCadastradas) {
			if(conta.getConta().equals(numeroConta)) {
				System.out.println("Numero de conta Existente");
				return conta;
			}	
		}
		return null;
	}
}
