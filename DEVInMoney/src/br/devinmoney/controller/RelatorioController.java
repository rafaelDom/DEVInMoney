package br.devinmoney.controller;

import java.util.Scanner;

import br.devinmoney.dao.DAOFake;
import br.devinmoney.menu.Menu;
import br.devinmoney.models.Conta;
import br.devinmoney.relatorios.Relatorio;
import br.devinmoney.validator.Validator;

public class RelatorioController {
	Menu menu = new Menu();
	Validator validator = new Validator();
	Scanner leitor = new Scanner(System.in);
	GeralController geralController;
	Relatorio relatorio = new Relatorio();

	
	public Object menuOpcoesRelatorios() {
		int opcaoMenu = 0;
		geralController = new GeralController();
		do {
			menu.menuRelatorios();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.todasContas();
				} else if (opcaoMenu == 2) {
					return this.contasSaldoNegativo();
				} else if (opcaoMenu == 3) {
					return this.totalValorInvestido();
				} else if (opcaoMenu == 4) {
					return this.transacoesCliente();
				}else if (opcaoMenu == 5) {
					return geralController.menuPrincipal();
				} else if (opcaoMenu == 6) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 8);

		return opcaoMenu;
	}
	
	public Object todasContas() {
		System.out.println("### RELATORIO DE TODAS AS CONTAS ###");
		System.out.println(">>>>>>> CONTA(S) CORRENTE <<<<<<<");
		relatorio.listarContasCorrente(DAOFake.contasCorrenteCadastradas);
		System.out.println("TOTAL DE CONTA CORRENTE CADASTRADA: " + DAOFake.contasCorrenteCadastradas.size());
		System.out.println(">>>>>>> CONTA(S) POUPANÇA <<<<<<<");
		relatorio.listarContasPoupanca(DAOFake.contasPoupancaCadastradas);
		System.out.println("TOTAL DE CONTA POUPANÇA CADASTRADA: " + DAOFake.contasPoupancaCadastradas.size());
		System.out.println(">>>>>>> CONTA(S) INVESTIMENTO <<<<<<<");
		relatorio.listarContasInvestimento(DAOFake.contasInvestimentoCadastradas);
		System.out.println("TOTAL DE CONTA INVESTIMENTO CADASTRADA: " + DAOFake.contasInvestimentoCadastradas.size());
		
		geralController.continuarSair();
		
		return this.menuOpcoesRelatorios();
		
	}
	
	public Object contasSaldoNegativo() {
		System.out.println("### RELATORIO DE TODAS AS CONTAS COM SALDO NEGATIVO ###");
		System.out.println(">>>>>>> CONTA(S) CORRENTE <<<<<<<");
		relatorio.listarContasCorrenteSaldoNegativo(DAOFake.contasCorrenteCadastradas);
		System.out.println(">>>>>>> CONTA(S) POUPANÇA <<<<<<<");
		relatorio.listarContasPoupancaSaldoNegativo(DAOFake.contasPoupancaCadastradas);
		System.out.println(">>>>>>> CONTA(S) INVESTIMENTO <<<<<<<");
		relatorio.listarContasInvestimentoSaldoNegativo(DAOFake.contasInvestimentoCadastradas);
		
		geralController.continuarSair();
		
		return this.menuOpcoesRelatorios();
		
	}
	
	public Object totalValorInvestido() {
		System.out.println("### RELATORIO DO TOTAL DE VALOR INVESTIDO ###");
		relatorio.totalValorInvestido(DAOFake.totalValorInvestido);
		
		geralController.continuarSair();
		
		return this.menuOpcoesRelatorios();
		
	}
	
	
	public Object transacoesCliente() {
		System.out.println("### RELATORIO DAS TRANSACOES DE UM CLIENTE ###");
		
		Conta contaTransacoes = (Conta) this.getInputContaTransacoes();
		
		relatorio.transacoesCliente(contaTransacoes.getConta());
		
		
		geralController.continuarSair();
		
		return this.menuOpcoesRelatorios();
		
	}
	
	public Object getInputContaTransacoes() {
		Conta contaTransacoes = null;
		boolean validador = false;
		int numeroConta = 0;

		do {
			System.out.println("Digite o numero da conta ou 0 para voltar ao Menu Principal:");
			try {
				numeroConta = leitor.nextInt();

				if (numeroConta == 0) {
					return geralController.menuPrincipal();
				}
				
				System.out.println("Número da conta: " + numeroConta);
				
				contaTransacoes = validator.contaCorrenteCadastrada(numeroConta);
				if (contaTransacoes == null) {
					contaTransacoes = validator.contaPoupancaCadastrada(numeroConta);
				}
				if (contaTransacoes == null) {
					contaTransacoes = validator.contaInvestimentoCadastrada(numeroConta);
				}
				if (contaTransacoes != null) {
					leitor.nextLine();
					validador = true;
				} else {
					System.out.println(
							"Numero da conta digitado não está cadastrada!!! Entre com o numero da conta ou digite 0 para voltar ao Menu inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Numero da conta digitado é inválido!!! Entre com o numero da conta ou digite 0 para voltar ao Menu inicia!!!");
				leitor.next();
			}
		} while (!validador);

		return contaTransacoes;

	}
	
}
