package br.devinmoney.controller;

import java.util.Scanner;

import br.devinmoney.menu.Menu;
import br.devinmoney.models.Conta;
import br.devinmoney.utils.ValidadorCPF;
import br.devinmoney.validator.Validator;

public class GeralController {
	Menu menu = new Menu();
	Validator validator = new Validator();
	ValidadorCPF validatorCPF = new ValidadorCPF();
	Scanner leitor = new Scanner(System.in);
	ContaCorrenteController ccController = new ContaCorrenteController();
	
	public Object menuPrincipal() {
		int opcaoMenu = 0;
		do {
			menu.menuPrincipal();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.menuOpcoesCadastroConta();
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
	
	public Object getInputNome() {
		boolean validador = false;
		String nome = null;

		do {
			System.out.println("Digite o nome completo ou 0 para voltar ao Menu Inicial:");
			try {
				nome = leitor.nextLine();

				if (nome.equals("0")) {
					return this.menuPrincipal();
				}
				if (validator.validaNome(nome)) {
					validador = true;
				} else {
					System.out.println(
							"Nome digitado é inválido!!! Entre com o nome completo ou digite 0 para voltar ao Menu Inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Nome digitado é inválido!!! Entre com o nome corretamente ou digite 0 para voltar ao Menu Inicial!!!");
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
					return ccController.acessarCadastrarConta();
				} else if (opcaoMenu == 2) {

				} else if (opcaoMenu == 3) {

				} else if (opcaoMenu == 4) {

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

	public Object getInputCPF() {
		boolean validador = false;
		String cpf = null;

		do {
			System.out.println("Digite o CPF (Somente os dígitos) ou 0 para voltar ao menu inicial:");
			try {
				cpf = leitor.nextLine();

				if (cpf.equals("0")) {
					return this.menuPrincipal();
				}
				if (validatorCPF.isCPF(cpf)) {
					validador = true;
				} else {
					System.out.println(
							"CPF digitado é inválido!!! Digite o CPF (Somente os dígitos) ou 0 para voltar ao Menu Inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"CPF digitado é inválido!!! Digite o CPF (Somente os dígitos) ou 0 para voltar ao Menu Inicial!!!");
				leitor.next();
			}
		} while (!validador);

		return cpf;

	}

	public Object getInputRendaMensal() {
		boolean validador = false;
		String rendaMensal = null;

		do {
			System.out.println("Digite a renda mensal (Exemplo: 980.60 ou 3500.00) ou 0 para voltar ao Menu Inicial:");
			try {
				rendaMensal = leitor.nextLine();

				if (rendaMensal.equals("0")) {
					return this.menuPrincipal();
				}
				if (validator.validaValor(rendaMensal)) {
					validador = true;
				} else {
					System.out.println(
							"Renda Mensal digitada é inválido!!! Digite A renda mensal (Exemplo: 980.60 ou 3500.00) ou 0 para voltar ao Menu Inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Renda Mensal digitada é inválido!!! Digite A renda mensal (Exemplo: 980.60 ou 3500.00) ou 0 para voltar ao Menu Inicial!!!");
				leitor.next();
			}
		} while (!validador);

		return rendaMensal;

	}

	public Object getAgencia() {
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
					return this.menuPrincipal();
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
	
	public Object getInputValor() {
		boolean validador = false;
		String valor = null;
		
		do {
			System.out.println("Digite o valor (Exemplo: 50.60 ou 1500.00) ou 0 para voltar ao Menu Inicial:");
			try {
				valor = leitor.nextLine();

				if (valor.equals("0")) {
					return this.menuPrincipal();
				}
				if (validator.validaValor(valor)) {
					validador = true;
				} else {
					System.out.println(
							"Valor digitado é inválido!!! Digite o valor para saque (Exemplo: 50.60 ou 1500.00) ou 0 para voltar ao Menu Inicial!!!");
				}
			} catch (Exception e) {
				System.out.println(
						"Valor digitado é inválido!!! Digite o valor para saque (Exemplo: 50.60 ou 1500.00) ou 0 para voltar ao Menu Inicial!!!");
				leitor.next();
			}
		} while (!validador);

		return valor;

	}
	
	public Object continuarSair() {
		int opcaoMenu = 0;

		System.out.println("Digite 1 para continuar ou qualquer coisa para voltar ao Menu Inicial...");
		try {
			opcaoMenu = leitor.nextInt();

			if (opcaoMenu == 1) {
				leitor.nextLine();
			} else {
				this.menuPrincipal();
			}
		} catch (Exception e) {
			System.exit(0);
		}
		return "";
	
	}

	public Object getInputContaTransferir() {
		Conta contaTransferir = null;
		boolean validador = false;
		int numeroConta = 0;
		
		do {
			System.out.println("Digite o numero da conta destino:");
			try {
				numeroConta = leitor.nextInt();

				if (numeroConta == 0) {
					return this.menuPrincipal();
				}
				
				contaTransferir = validator.contaCorrenteCadastrada(numeroConta);
				
				if ( contaTransferir != null) {
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

		return contaTransferir;

	}
}
