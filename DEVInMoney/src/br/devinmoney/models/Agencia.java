package br.devinmoney.models;

public class Agencia {
	private String codigo;
	private String Cidade;
	
	public Agencia(String codigo, String cidade) {
		super();
		this.codigo = codigo;
		Cidade = cidade;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	
	
}
