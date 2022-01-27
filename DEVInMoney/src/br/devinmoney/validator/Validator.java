package br.devinmoney.validator;

public class Validator {

	public boolean validaNome(String nome) {
		return nome.matches("[a-zA-Z]{3,}+\\s+[a-zA-Z]{3,}");
	}

	public boolean validaRendaMensal(String rendaMensal) {
		return rendaMensal.matches("^(0|[1-9]\\d{0,2}(\\d{3})*)\\.\\d{2}$");
	}
}
