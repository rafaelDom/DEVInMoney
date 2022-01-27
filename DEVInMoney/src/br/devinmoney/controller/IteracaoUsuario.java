package br.devinmoney.controller;

import java.util.Scanner;

import br.devinmoney.dao.DAOFake;
import br.devinmoney.menu.Menu;
import br.devinmoney.models.Agencia;
import br.devinmoney.models.ContaCorrente;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.ContaPoupanca;
import br.devinmoney.utils.ValidadorCPF;
import br.devinmoney.validator.Validator;

public class IteracaoUsuario {
	Menu menu = new Menu();
	Validator validator = new Validator();
	ValidadorCPF validatorCPF = new ValidadorCPF();
	Scanner leitor = new Scanner(System.in);

	public Object menuPrincipal() {
		int opcaoMenu = 0;

		do {
			menu.menuPrincipal();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.menuConta();
				} else if (opcaoMenu == 2) {
				} else if (opcaoMenu == 3) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 3);
		return "";
	}

	public Object menuConta() {
		int opcaoMenu = 0;

		do {
			menu.menuConta();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.menuOpcoesCadastroConta();
				} else if (opcaoMenu == 2) {
				} else if (opcaoMenu == 3) {
					this.menuPrincipal();
					break;
				} else if (opcaoMenu == 4) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 4);

		return "";

	}

	public Object cadastrarContaCorrente() {
		System.out.println("### Cadastro de Conta Corrente ###");
		String nomeCompleto = this.getInputNome();
		String cpf = this.getInputCPF();
		Double rendaMensal = Double.parseDouble(this.getInputRendaMensal());
		int opcaoAgencia = this.getAgencia();
		String codigo = null;
		String cidade = null;
		
		if(opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florianópolis";
		}else if(opcaoAgencia == 2) {
			codigo = "002";
			cidade = "São José";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		ContaCorrente contaCorrente = new ContaCorrente(nomeCompleto, cpf, rendaMensal, agencia, 0.0);
		DAOFake.contasCorrenteCadastradas.add(contaCorrente);
		
		System.out.println("Conta Corrente cadastrada com sucesso!!!");
		
		return this.menuPrincipal();
	}
	
	public Object cadastrarContaPoupanca() {
		System.out.println("### Cadastro de Conta Poupança ###");
		String nomeCompleto = this.getInputNome();
		String cpf = this.getInputCPF();
		Double rendaMensal = Double.parseDouble(this.getInputRendaMensal());
		int opcaoAgencia = this.getAgencia();
		String codigo = null;
		String cidade = null;
		
		if(opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florianópolis";
		}else if(opcaoAgencia == 2) {
			codigo = "002";
			cidade = "São José";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		ContaPoupanca contaPoupanca = new ContaPoupanca(nomeCompleto, cpf, rendaMensal, agencia, 0.0);
		DAOFake.contasPoupancaCadastradas.add(contaPoupanca);
		
		System.out.println("Conta Poupança cadastrada com sucesso!!!");
		
		return this.menuPrincipal();
	}
	
	public Object cadastrarContaInvestimento() {
		System.out.println("### Cadastro de Conta Investimento ###");
		String nomeCompleto = this.getInputNome();
		String cpf = this.getInputCPF();
		Double rendaMensal = Double.parseDouble(this.getInputRendaMensal());
		int opcaoAgencia = this.getAgencia();
		String codigo = null;
		String cidade = null;
		
		if(opcaoAgencia == 1) {
			codigo = "001";
			cidade = "Florianópolis";
		}else if(opcaoAgencia == 2) {
			codigo = "002";
			cidade = "São José";
		}
		Agencia agencia = new Agencia(codigo, cidade);
		ContaInvestimento contaInvestimento = new ContaInvestimento(nomeCompleto, cpf, rendaMensal, agencia, 0.0);

		DAOFake.contasInvestimentoCadastradas.add(contaInvestimento);
		
		System.out.println("Conta Investimento cadastrada com sucesso!!!");
		
		return this.menuPrincipal();
	}


	public String getInputNome() {
		boolean validador = false;
		String nome = null;
		leitor.nextLine();

		do {
			System.out.println("Digite o nome completo ou 0 para finalizar o programa:");
			try {
				nome = leitor.nextLine();

				if (nome.equals("0")) {
					System.exit(0);
				}
				if (validator.validaNome(nome)) {
					validador = true;
				} else {
					System.out.println(
							"Nome digitado é inválido!!! Entre com o nome completo ou digite 0 para finalizar o programa!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Nome digitado é inválido!!! Entre com o nome corretamente ou digite 0 para finalizar o programa!!!");
				leitor.next();
			}
		} while (!validador);

		return nome;

	}

	public Object menuOpcoesCadastroConta() {
		int opcaoMenu = 0;

		do {
			menu.menuOpcoesCadastroConta();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.cadastrarContaCorrente();
				} else if (opcaoMenu == 2) {
					return this.cadastrarContaPoupanca();
				} else if (opcaoMenu == 3) {
					return this.cadastrarContaInvestimento();
				} else if (opcaoMenu == 4) {
					return this.menuPrincipal();
				} else if (opcaoMenu == 5) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 5);

		return opcaoMenu;
	}

	public String getInputCPF() {
		boolean validador = false;
		String cpf = null;

		do {
			System.out.println("Digite o CPF (Somente os dígitos) ou 0 para finalizar o programa:");
			try {
				cpf = leitor.nextLine();

				if (cpf.equals("0")) {
					System.exit(0);
				}
				if (validatorCPF.isCPF(cpf)) {
					validador = true;
				} else {
					System.out.println(
							"CPF digitado é inválido!!! Digite o CPF (Somente os dígitos) ou 0 para finalizar o programa!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"CPF digitado é inválido!!! Digite o CPF (Somente os dígitos) ou 0 para finalizar o programa!!!");
				leitor.next();
			}
		} while (!validador);

		return cpf;

	}
	
	public String getInputRendaMensal() {
		boolean validador = false;
		String rendaMensal = null;

		do {
			System.out.println("Digite a renda mensal (Exemplo: 980.60 ou 3500.00) ou 0 para finalizar o programa:");
			try {
				rendaMensal = leitor.nextLine();

				if (rendaMensal.equals("0")) {
					System.exit(0);
				}
				if (validator.validaRendaMensal(rendaMensal)) {
					validador = true;
				} else {
					System.out.println(
							"Renda Mensal digitada é inválido!!! Digite A renda mensal (Exemplo: 980.60 ou 3500.00) ou 0 para finalizar o programa!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Renda Mensal digitada é inválido!!! Digite A renda mensal (Exemplo: 980.60 ou 3500.00) ou 0 para finalizar o programa!!!");
				leitor.next();
			}
		} while (!validador);

		return rendaMensal;

	}
	
	public int getAgencia() {
		int opcaoMenu = 0;

		do {
			menu.menuOpcoesAgencia();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return 1;
				} else if (opcaoMenu == 2) {
					return 2;
				} else if (opcaoMenu == 3) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 3);

		return 0;
	}

}
