package br.devinmoney.controller;

import java.time.LocalDate;
import java.util.Scanner;

import br.devinmoney.dao.ContaCorrenteDAO;
import br.devinmoney.dao.DAOFake;
import br.devinmoney.menu.Menu;
import br.devinmoney.models.Agencia;
import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.Transacao;
import br.devinmoney.validator.Validator;

public class ContaCorrenteController {
	Menu menu = new Menu();
	Validator validator = new Validator();
	Scanner leitor = new Scanner(System.in);
	ContaCorrente contaCorrente;
	GeralController geralController;
	ContaCorrenteDAO contaCorrenteDAO = new ContaCorrenteDAO();


	public Object cadastrarContaCorrente() {
		geralController = new GeralController();
		System.out.println("### Cadastro de Conta Corrente ###");
		String nomeCompleto = geralController.getInputNome().toString();
		String cpf = geralController.getInputCPF().toString();
		Double rendaMensal = Double.parseDouble(geralController.getInputRendaMensal().toString());
		int opcaoAgencia = (int) geralController.getAgencia();
		String codigo = null;
		String cidade = null;

		if (opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florianópolis";
		} else if (opcaoAgencia == 2) {
			codigo = "002";
			cidade = "São José";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		ContaCorrente contaCorrente = new ContaCorrente(nomeCompleto, cpf, rendaMensal, agencia, 0.0);
		DAOFake.contasCorrenteCadastradas.add(contaCorrente);

		System.out.println("Conta Corrente cadastrada com sucesso!!!");
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}

	public Object menuOpcoesContaCorrente() {
		int opcaoMenu = 0;

		do {
			menu.acoesContaCorrente();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.saqueContaCorrente();
				} else if (opcaoMenu == 2) {
					return this.depositoContaCorrente();
				} else if (opcaoMenu == 3) {
					return this.saldoContaCorrente();
				} else if (opcaoMenu == 4) {
					return this.extratoContaCorrente();
				} else if (opcaoMenu == 5) {
					return this.transferenviaContaCorrente();
				} else if (opcaoMenu == 6) {
					return this.alterarContaCorrente();
				} else if (opcaoMenu == 7) {
					return acessarCadastrarConta();
				} else if (opcaoMenu == 8) {
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
	
	public Object saqueContaCorrente() {
		System.out.println("### SAQUE CONTA CORRENTE ###");
		
		String valorSaque = geralController.getInputValor().toString();
		
		if(contaCorrente.sacar(Double.parseDouble(valorSaque))) {
			contaCorrente.setSaldo(contaCorrente.getSaldo());
			if(contaCorrenteDAO.atualizarConta(contaCorrente)) {
				Transacao transacao = new Transacao(LocalDate.now(), contaCorrente, contaCorrente, Double.parseDouble(valorSaque), "SAQUE");
				contaCorrente.salvarTransacao(transacao);
				System.out.println("Saque no valor de R$ " + valorSaque + " realizado com sucesso!!!");
			}else {
				System.out.println("Saque não realizado !!! Falha no saque!!!");
			}
		}else {
			System.out.println("Saque não realizado !!! Operação não permitida!!!");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaCorrente();
		
	}
	
	public Object getInputContaCorrente() {
		boolean validador = false;
		int numeroConta = 0;
		
		do {
			System.out.println("Digite o numero da conta:");
			try {
				numeroConta = leitor.nextInt();

				if (numeroConta == 0) {
					return geralController.menuPrincipal();
				}
				
				contaCorrente = validator.contaCorrenteCadastrada(numeroConta);
				
				if ( contaCorrente != null) {
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

		return "";

	}
	
	public Object depositoContaCorrente() {
		System.out.println("### DEPOSITO CONTA CORRENTE ###");
		
		String valorDeposito = geralController.getInputValor().toString();
		
		if(contaCorrente.depositar(Double.parseDouble(valorDeposito))) {
			if(contaCorrenteDAO.atualizarConta(contaCorrente)) {
				Transacao transacao = new Transacao(LocalDate.now(), contaCorrente, contaCorrente, Double.parseDouble(valorDeposito), "DEPOSITO");
				contaCorrente.salvarTransacao(transacao);
				System.out.println("Depósito no valor de R$ " + valorDeposito + " realizado com sucesso!!!");
			}else {
				System.out.println("Depósito não realizado !!! Falha no depósito!!!");
			}
		}else {
			System.out.println("Depósito não realizado !!! Operação não permitida!!!");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaCorrente();
		
	}
	
	public Object saldoContaCorrente() {
		System.out.println("### SALDO CONTA CORRENTE ###");
		
		System.out.println("O saldo da Conta Corrente " + contaCorrente.getConta() + " é R$ " + contaCorrente.getSaldo());
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaCorrente();
		
	}
	
	public Object acessarCadastrarConta() {
		int opcaoMenu = 0;
		System.out.println("### Menu Conta Corrente ###");
		geralController = new GeralController();
		do {
			menu.menuCadastrarAcessarConta();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.cadastrarContaCorrente();
				} else if (opcaoMenu == 2) {
					return this.acessarConta();
				} else if (opcaoMenu == 3) {
					return geralController.menuPrincipal(); 
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
	
	public Object acessarConta() {
		this.getInputContaCorrente();
		return this.menuOpcoesContaCorrente();
	}
	
	public Object extratoContaCorrente() {
		System.out.println("### EXTRATO CONTA CORRENTE ###");
		contaCorrente.extrato();
		geralController.continuarSair();
		return this.menuOpcoesContaCorrente();
		
	}

	public Object transferenviaContaCorrente() throws NumberFormatException {
		System.out.println("### TRANSFERENCIA CONTA CORRENTE ###");
		
		LocalDate dtAgora = LocalDate.now();
		String diaSemana = dtAgora.getDayOfWeek().toString();
		
		if(!diaSemana.equals("SATURDAY") && !diaSemana.equals("SUNDAY")) {
			Conta contaTransferir = (Conta) geralController.getInputContaTransferir();
			String valorTransferir = geralController.getInputValor().toString();
			
			
			if(contaCorrente.transferir(contaCorrente, contaTransferir, Double.parseDouble(valorTransferir))) {
				if(contaCorrenteDAO.atualizarConta(contaCorrente)) {
					if(DAOFake.atualizarSaldo(contaTransferir)) {
						Transacao transacao = new Transacao(LocalDate.now(), contaCorrente, contaTransferir, Double.parseDouble(valorTransferir), "TRANSFERENCIA");
						contaCorrente.salvarTransacao(transacao);
						System.out.println("Tranferência do valor R$ " + valorTransferir +" para a conta " + contaTransferir.getConta() + " foi realizado com sucesso!!!");
					}else {
						System.out.println("Falha ao atualizar o saldo da conta destino!!!");
					}
				}else {
					System.out.println("Falha ao atualizar o saldo da conta origem!!!");
				}
			}else {
				System.out.println("Não foi possível realizar a tranferência do valor R$ " + valorTransferir +" para a conta " + contaTransferir.getConta() + " .");
			}
		}else {
			System.out.println("Não é permitido realizar transferência de SÁBADO/DOMINGO");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaCorrente();
		
	}

	public Object alterarContaCorrente() {
		geralController = new GeralController();
		System.out.println("### Alterar Cadastro Conta Corrente ###");
		System.out.println("Dados da conta: " + contaCorrente.toString());
		String nomeCompleto = geralController.getInputNome().toString();
		Double rendaMensal = Double.parseDouble(geralController.getInputRendaMensal().toString());
		int opcaoAgencia = (int) geralController.getAgencia();
		String codigo = null;
		String cidade = null;

		if (opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florianópolis";
		} else if (opcaoAgencia == 2) {
			codigo = "002";
			cidade = "São José";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		
		contaCorrente.setNome(nomeCompleto);
		contaCorrente.setAgencia(agencia);
		contaCorrente.setRendaMensal(rendaMensal);

		if(contaCorrenteDAO.atualizarConta(contaCorrente)) {
			System.out.println("Conta Corrente alterada sucesso!!!");
			System.out.println("Dados da conta: " + contaCorrente.toString());
		}
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}
}
