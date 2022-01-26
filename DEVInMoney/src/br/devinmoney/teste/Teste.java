package br.devinmoney.teste;

import java.time.LocalDate;
import java.util.ArrayList;

import br.devinmoney.enums.Investimento;
import br.devinmoney.models.Agencia;
import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.ContaPoupanca;
import br.devinmoney.models.Transacao;
import br.devinmoney.relatorios.Relatorio;

public class Teste {
	ArrayList<Conta> contasCorrente = new ArrayList<Conta>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teste t1 = new Teste();
		t1.testesContaCorrente();
		
	
		
	}
	
	public void testesContaCorrente() {
		Agencia ag1 = new Agencia("001", "Florianópolis");
		ContaCorrente contaCorrente = new ContaCorrente("Rafael", "999.999.999-01", 4.500, ag1, 500.00);
		ContaCorrente contaCorrente2 = new ContaCorrente("Rafael", "999.999.999-01", 4.500, ag1, -500.00);
		contasCorrente.add(contaCorrente);
		contasCorrente.add(contaCorrente2);
		System.out.println("Numero da conta: " + contaCorrente.getConta());
		System.out.println("Numero da conta: " + contaCorrente2.getConta());
		contaCorrente.transferir(contaCorrente2, 50.00);
		Transacao transacao = new Transacao(LocalDate.now(), contaCorrente, contaCorrente2, 50.00, "DEP");
		contaCorrente.salvarTransacao(transacao);;
		Relatorio relatorio = new Relatorio();
		relatorio.listarTransacoesCliente(contaCorrente);
		
	}
	
	public void testesContaPoupanca() {

	}
	
	public void testesContaInvestimento() {

		
	}
	
	public void testesRelatorio() {
		Relatorio relatorio = new Relatorio();
		//relatorio.listarContas(contasCorrente);
		//relatorio.listarContasSaldoNegativo(contasCorrente);
		
	}


}
