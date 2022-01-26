package br.devinmoney.validator;

public class Validator {

	public boolean validaNome(String nome) {
		return nome.matches("[a-zA-Z]{3,}+\\s+[a-zA-Z]{3,}");
	}

	public boolean validaRendaMensal(String rendaMensal) {
		return rendaMensal.matches("^\\d+,*\\.*\\d{0,2}$");
	}
}
