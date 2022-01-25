package br.devinmoney.enums;

public enum Investimento {
	TESOURO_DIRETO(5.46),
	CDB(3.58),
	LCI(2.86),
	FUNDOS_IMOBILIARIOS(4.16);

	private final Double rendimentoAnual;
	
	Investimento(Double rendimentoAnual){
		this.rendimentoAnual = rendimentoAnual;
	}

	public Double getRendimentoAnual() {
		return rendimentoAnual;
	}

	
}
