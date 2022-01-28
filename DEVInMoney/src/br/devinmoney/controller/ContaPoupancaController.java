package br.devinmoney.controller;

import java.time.LocalDate;
import java.util.Scanner;

import br.devinmoney.dao.ContaPoupancaDAO;
import br.devinmoney.dao.DAOFake;
import br.devinmoney.menu.Menu;
import br.devinmoney.models.Agencia;
import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaPoupanca;
import br.devinmoney.models.Transacao;
import br.devinmoney.validator.Validator;

public class ContaPoupancaController {
	Menu menu = new Menu();
	Validator validator = new Validator();
	Scanner leitor = new Scanner(System.in);
	ContaPoupanca contaPoupanca;
	GeralController geralController;
	ContaPoupancaDAO contaPoupancaDAO = new ContaPoupancaDAO();


	public Object cadastrarContaPoupanca() {
		geralController = new GeralController();
		System.out.println("### Cadastro de Conta Poupan�a ###");
		String nomeCompleto = geralController.getInputNome().toString();
		String cpf = geralController.getInputCPF().toString();
		Double rendaMensal = Double.parseDouble(geralController.getInputRendaMensal().toString());
		int opcaoAgencia = (int) geralController.getAgencia();
		String codigo = null;
		String cidade = null;

		if (opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florian�polis";
		} else if (opcaoAgencia == 2) {
			codigo = "002";
			cidade = "S�o Jos�";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		ContaPoupanca contaPoupanca = new ContaPoupanca(nomeCompleto, cpf, rendaMensal, agencia, 0.0);
		DAOFake.contasPoupancaCadastradas.add(contaPoupanca);

		System.out.println("Conta Poupan�a cadastrada com sucesso!!!");
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}

	public Object menuOpcoesContaPoupanca() {
		int opcaoMenu = 0;

		do {
			menu.acoesContaPoupanca();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.saqueContaPoupanca();
				} else if (opcaoMenu == 2) {
					return this.depositoContaPoupanca();
				} else if (opcaoMenu == 3) {
					return this.saldoContaPoupanca();
				} else if (opcaoMenu == 4) {
					return this.extratoContaPoupanca();
				} else if (opcaoMenu == 5) {
					return this.transferenciaContaPoupanca();
				} else if (opcaoMenu == 6) {
					return this.alterarContaPoupanca();
				} else if (opcaoMenu == 7) {
					return this.simularRendimentoPeriodo();
				}else if (opcaoMenu == 8) {
					return acessarCadastrarConta();
				} else if (opcaoMenu == 9) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Op��o digitada � inv�lida!!! Digite uma op��o v�lida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Op��o digitada � inv�lida!!! Digite uma op��o v�lida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 9);

		return opcaoMenu;
	}
	
	public Object saqueContaPoupanca() {
		System.out.println("### SAQUE CONTA POUPAN�A ###");
		
		String valorSaque = geralController.getInputValor().toString();
		
		if(contaPoupanca.sacar(Double.parseDouble(valorSaque))) {
			contaPoupanca.setSaldo(contaPoupanca.getSaldo());
			if(contaPoupancaDAO.atualizarConta(contaPoupanca)) {
				Transacao transacao = new Transacao(LocalDate.now(), contaPoupanca, contaPoupanca, Double.parseDouble(valorSaque), "SAQUE");
				contaPoupanca.salvarTransacao(transacao);
				System.out.println("Saque no valor de R$ " + valorSaque + " realizado com sucesso!!!");
			}else {
				System.out.println("Saque n�o realizado !!! Falha no saque!!!");
			}
		}else {
			System.out.println("Saque n�o realizado !!! Opera��o n�o permitida!!!");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaPoupanca();
		
	}
	
	public Object getInputContaPoupanca() {
		boolean validador = false;
		int numeroConta = 0;
		
		do {
			System.out.println("Digite o numero da conta:");
			try {
				numeroConta = leitor.nextInt();

				if (numeroConta == 0) {
					return geralController.menuPrincipal();
				}
				
				contaPoupanca = validator.contaPoupancaCadastrada(numeroConta);
				
				if ( contaPoupanca != null) {
					validador = true;
				} else {
					System.out.println(
							"Numero da conta digitado n�o est� cadastrada!!! Entre com o numero da conta ou digite 0 para voltar ao Menu inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Numero da conta digitado � inv�lido!!! Entre com o numero da conta ou digite 0 para voltar ao Menu inicia!!!");
				leitor.next();
			}
		} while (!validador);

		return "";

	}
	
	public Object depositoContaPoupanca() {
		System.out.println("### DEPOSITO CONTA POUPAN�A ###");
		
		String valorDeposito = geralController.getInputValor().toString();
		
		if(contaPoupanca.depositar(Double.parseDouble(valorDeposito))) {
			if(contaPoupancaDAO.atualizarConta(contaPoupanca)) {
				Transacao transacao = new Transacao(LocalDate.now(), contaPoupanca, contaPoupanca, Double.parseDouble(valorDeposito), "DEPOSITO");
				contaPoupanca.salvarTransacao(transacao);
				System.out.println("Dep�sito no valor de R$ " + valorDeposito + " realizado com sucesso!!!");
			}else {
				System.out.println("Dep�sito n�o realizado !!! Falha no dep�sito!!!");
			}
		}else {
			System.out.println("Dep�sito n�o realizado !!! Opera��o n�o permitida!!!");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaPoupanca();
		
	}
	
	public Object saldoContaPoupanca() {
		System.out.println("### SALDO CONTA POUPAN�A ###");
		
		System.out.println("O saldo da Conta Poupan�a " + contaPoupanca.getConta() + " � R$ " + contaPoupanca.getSaldo());
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaPoupanca();
		
	}
	
	public Object acessarCadastrarConta() {
		int opcaoMenu = 0;
		geralController = new GeralController();
		System.out.println("### Menu Conta Poupan�a ###");
		do {
			menu.menuCadastrarAcessarConta();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.cadastrarContaPoupanca();
				} else if (opcaoMenu == 2) {
					return this.acessarConta();
				} else if (opcaoMenu == 3) {
					return geralController.menuPrincipal(); 
					
				} else {
					System.out.println("Op��o digitada � inv�lida!!! Digite uma op��o v�lida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Op��o digitada � inv�lida!!! Digite uma op��o v�lida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 8);

		return opcaoMenu;
	}
	
	public Object acessarConta() {
		this.getInputContaPoupanca();
		return this.menuOpcoesContaPoupanca();
	}
	
	public Object extratoContaPoupanca() {
		System.out.println("### EXTRATO CONTA POUPAN�A ###");
		contaPoupanca.extrato();
		geralController.continuarSair();
		return this.menuOpcoesContaPoupanca();
		
	}

	public Object transferenciaContaPoupanca() throws NumberFormatException {
		System.out.println("### TRANSFERENCIA CONTA POUPAN�A ###");
		
		LocalDate dtAgora = LocalDate.now();
		String diaSemana = dtAgora.getDayOfWeek().toString();
		
		if(!diaSemana.equals("SATURDAY") && !diaSemana.equals("SUNDAY")) {
			Conta contaTransferir = (Conta) geralController.getInputContaTransferir();
			String valorTransferir = geralController.getInputValor().toString();
			
			
			if(contaPoupanca.transferir(contaPoupanca, contaTransferir, Double.parseDouble(valorTransferir))) {
				if(contaPoupancaDAO.atualizarConta(contaPoupanca)) {
					if(DAOFake.atualizarSaldo(contaTransferir)) {
						Transacao transacao = new Transacao(LocalDate.now(), contaPoupanca, contaTransferir, Double.parseDouble(valorTransferir), "TRANSFERENCIA");
						contaPoupanca.salvarTransacao(transacao);
						System.out.println("Tranfer�ncia do valor R$ " + valorTransferir +" para a conta " + contaTransferir.getConta() + " foi realizado com sucesso!!!");
					}else {
						System.out.println("Falha ao atualizar o saldo da conta destino!!!");
					}
				}else {
					System.out.println("Falha ao atualizar o saldo da conta origem!!!");
				}
			}else {
				System.out.println("N�o foi poss�vel realizar a tranfer�ncia do valor R$ " + valorTransferir +" para a conta " + contaTransferir.getConta() + " .");
			}
		}else {
			System.out.println("N�o � permitido realizar transfer�ncia de S�BADO/DOMINGO");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaPoupanca();
		
	}

	public Object alterarContaPoupanca() {
		geralController = new GeralController();
		System.out.println("### Alterar Cadastro Conta Poupan�a ###");
		System.out.println("Dados da conta: " + contaPoupanca.toString());
		String nomeCompleto = geralController.getInputNome().toString();
		Double rendaMensal = Double.parseDouble(geralController.getInputRendaMensal().toString());
		int opcaoAgencia = (int) geralController.getAgencia();
		String codigo = null;
		String cidade = null;

		if (opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florian�polis";
		} else if (opcaoAgencia == 2) {
			codigo = "002";
			cidade = "S�o Jos�";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		
		contaPoupanca.setNome(nomeCompleto);
		contaPoupanca.setAgencia(agencia);
		contaPoupanca.setRendaMensal(rendaMensal);

		if(contaPoupancaDAO.atualizarConta(contaPoupanca)) {
			System.out.println("Conta Poupan�a alterada sucesso!!!");
			System.out.println("Dados da conta: " + contaPoupanca.toString());
		}
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}
	
	public Object simularRendimentoPeriodo() {
		System.out.println("### Simular Rendimento do Saldo em per�odo de meses ###");
		boolean validador = false;
		Double valor;
		int qtdeMeses = 0;
		valor = Double.parseDouble(this.getInputRentabilidadeAnual().toString());
		do {
			System.out.println("Digite a qtde de meses para a simula��o de rendimento ou 0 para voltar ao Menu Principal:");
			try {
				qtdeMeses = leitor.nextInt();
				if (qtdeMeses == 0) {
					return geralController.menuPrincipal();
				}else if(qtdeMeses >= 1 &&  qtdeMeses <=12) {
					contaPoupanca.calcularRendimento(qtdeMeses, valor);
					break;
				}else {
					System.out.println("Qtde de meses para a simula��o de rendimento digitado � inv�lido!!! Limite deve estar entre 1 e 12 meses!!!");
				}

				
			} catch (Exception e) {
				System.out.println(
						"Qtde de meses para a simula��o de rendimento digitado � inv�lido!!! Entre com o numero da conta ou digite 0 para voltar ao Menu inicia!!!");
				leitor.next();
			}
		} while (!validador);
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}
	
	public Object getInputRentabilidadeAnual() {
		boolean validador = false;
		String rentabilidadeAnual = null;
		do {
			System.out.println("Digite a rentabilidade anual da popupan�a ou 0 para voltar ao Menu Inicial:");
			try {
				rentabilidadeAnual = leitor.next();
				
				System.out.println("Rentabilidade Anual: " + rentabilidadeAnual);
				
				if (rentabilidadeAnual.equals("0")) {
					return geralController.menuPrincipal();
				}
				
				if (validator.validaRentabilidadeAnual(rentabilidadeAnual)) {
					validador = true;
				} else {
					System.out.println(
							"Rentabilidade anual da popupan�a digitado � inv�lido!!! Digite a Rentabilidade anual da popupan�a ou 0 para voltar ao Menu Inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Rentabilidade anual da popupan�a digitado � inv�lido!!! Digite a Rentabilidade anual da popupan�a ou 0 para voltar ao Menu Inicial!!!");
				leitor.next();
			}
		} while (!validador);

		return rentabilidadeAnual;

	}
}
