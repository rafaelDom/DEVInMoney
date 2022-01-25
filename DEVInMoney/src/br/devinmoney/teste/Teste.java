package br.devinmoney.teste;

import java.time.LocalDate;

import br.devinmoney.enums.Investimento;
import br.devinmoney.models.Agencia;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.ContaPoupanca;
import br.devinmoney.models.Transacao;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teste t1 = new Teste();
		t1.testesContaInvestimento();
	
		
	}
	
	public void testesContaCorrente() {
		ContaCorrente contaCorrente = new ContaCorrente();
		Agencia agencia = new Agencia();
		agencia.setCidade("Florianópolis");
		agencia.setCodigo("001");
		contaCorrente.setAgencia(agencia);
		contaCorrente.setConta("99999");
		contaCorrente.setCpf("405852587-96");
		contaCorrente.setNome("Rafael");
		contaCorrente.setRendaMensal(3500.20);
		contaCorrente.setSaldo(500.00);
		
		ContaCorrente contaCorrente2 = new ContaCorrente();
		Agencia agencia2 = new Agencia();
		agencia2.setCidade("Florianópolis");
		agencia2.setCodigo("001");
		contaCorrente2.setAgencia(agencia);
		contaCorrente2.setConta("9999");
		contaCorrente2.setCpf("405852587-9");
		contaCorrente2.setNome("Rafael Up");
		contaCorrente2.setRendaMensal(4000.20);
		contaCorrente2.setSaldo(700.00);

		/*
		System.out.println(contaCorrente.getSaldo());
		contaCorrente.depositar(800.00);
		System.out.println(contaCorrente.getSaldo());
		
		System.out.println(contaCorrente.sacar(4800.00));
		
		System.out.println(contaCorrente.getSaldo());
		
		System.out.println(contaCorrente.transferir(contaCorrente2, 50.00));
		
		System.out.println(contaCorrente.getSaldo());
		
		System.out.println(contaCorrente2.getSaldo());
		
		System.out.println("Nome: " + contaCorrente.getNome());
		contaCorrente.alterarDadosCadastrais(contaCorrente2);
		System.out.println("Nome: " + contaCorrente.getNome());
		*/
		
		contaCorrente.depositar(800.00);
		LocalDate testeData = null;
		LocalDate dataAgr = testeData.now();
		Transacao t1 = new Transacao(dataAgr, contaCorrente, contaCorrente, 800.00,"Deposito");
		
		contaCorrente.salvarTransacao(t1);
		contaCorrente.extrato();
		
	}
	
	public void testesContaPoupanca() {
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		Agencia agencia = new Agencia();
		agencia.setCidade("Florianópolis");
		agencia.setCodigo("001");
		contaPoupanca.setAgencia(agencia);
		contaPoupanca.setConta("99999");
		contaPoupanca.setCpf("405852587-96");
		contaPoupanca.setNome("Rafael");
		contaPoupanca.setRendaMensal(3500.20);
		contaPoupanca.setSaldo(500.00);
		
		contaPoupanca.calcularRendimento(6, 5.12);
		
	}
	
	public void testesContaInvestimento() {
		ContaInvestimento contaInvestimento = new ContaInvestimento();
		Agencia agencia = new Agencia();
		agencia.setCidade("Florianópolis");
		agencia.setCodigo("001");
		contaInvestimento.setAgencia(agencia);
		contaInvestimento.setConta("99999");
		contaInvestimento.setCpf("405852587-96");
		contaInvestimento.setNome("Rafael");
		contaInvestimento.setRendaMensal(3500.20);
		contaInvestimento.setSaldo(500.00);
		
		Investimento investimento = null;
		
		contaInvestimento.rendimentoAnualInvestimento(investimento.CDB);
		
		contaInvestimento.simularRendimentoAnual(investimento.CDB);
		
	}


}
