package br.devinmoney.controller;

import java.time.LocalDate;
import java.util.Scanner;

import br.devinmoney.dao.ContaInvestimentoDAO;
import br.devinmoney.dao.DAOFake;
import br.devinmoney.enums.Investimento;
import br.devinmoney.menu.Menu;
import br.devinmoney.models.Agencia;
import br.devinmoney.models.Conta;
import br.devinmoney.models.ContaInvestimento;
import br.devinmoney.models.Transacao;
import br.devinmoney.validator.Validator;

public class ContaInvestimentoController {
	Menu menu = new Menu();
	Validator validator = new Validator();
	Scanner leitor = new Scanner(System.in);
	ContaInvestimento contaInvestimento;
	GeralController geralController;
	ContaInvestimentoDAO contaInvestimentoDAO = new ContaInvestimentoDAO();


	public Object cadastrarContaInvestimento() {
		geralController = new GeralController();
		System.out.println("### Cadastro de Conta Investimento ###");
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
		ContaInvestimento contaInvestimento = new ContaInvestimento(nomeCompleto, cpf, rendaMensal, agencia, 0.0);
		DAOFake.contasInvestimentoCadastradas.add(contaInvestimento);

		System.out.println("Conta Investimento cadastrada com sucesso!!!");
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}

	public Object menuOpcoesContaInvestimento() {
		int opcaoMenu = 0;

		do {
			menu.acoesContaInvestimento();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.saqueContaInvestimento();
				} else if (opcaoMenu == 2) {
					return this.depositoContaInvestimento();
				} else if (opcaoMenu == 3) {
					return this.saldoContaInvestimento();
				} else if (opcaoMenu == 4) {
					return this.extratoContaInvestimento();
				} else if (opcaoMenu == 5) {
					return this.transferenciaContaInvestimento();
				} else if (opcaoMenu == 6) {
					return this.alterarContaInvestimento();
				}else if (opcaoMenu == 7) {
					return this.escolherTipoInvestimento();
				}else if (opcaoMenu == 8) {
					return this.simularInvestimento();
				} else if (opcaoMenu == 9) {
					return this.realizarInvestimento();
				}else if (opcaoMenu == 10) {
					return acessarCadastrarConta();
				} else if (opcaoMenu == 11) {
					System.out.println("Programa finalizado!!! Volte sempre!!!");
					System.exit(0);
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 11);

		return opcaoMenu;
	}
	
	public Object saqueContaInvestimento() {
		System.out.println("### SAQUE CONTA INVESTIMENTO ###");
		
		String valorSaque = geralController.getInputValor().toString();
		
		if(contaInvestimento.sacar(Double.parseDouble(valorSaque))) {
			contaInvestimento.setSaldo(contaInvestimento.getSaldo());
			if(contaInvestimentoDAO.atualizarConta(contaInvestimento)) {
				Transacao transacao = new Transacao(LocalDate.now(), contaInvestimento, contaInvestimento, Double.parseDouble(valorSaque), "SAQUE");
				contaInvestimento.salvarTransacao(transacao);
				System.out.println("Saque no valor de R$ " + valorSaque + " realizado com sucesso!!!");
			}else {
				System.out.println("Saque não realizado !!! Falha no saque!!!");
			}
		}else {
			System.out.println("Saque não realizado !!! Operação não permitida!!!");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaInvestimento();
		
	}
	
	public Object getInputContaInvestimento() {
		boolean validador = false;
		int numeroConta = 0;
		
		do {
			System.out.println("Digite o numero da conta:");
			try {
				numeroConta = leitor.nextInt();

				if (numeroConta == 0) {
					return geralController.menuPrincipal();
				}
				
				contaInvestimento = validator.contaInvestimentoCadastrada(numeroConta);
				
				if ( contaInvestimento != null) {
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
	
	public Object depositoContaInvestimento() {
		System.out.println("### DEPOSITO CONTA INVESTIMENTO ###");
		
		String valorDeposito = geralController.getInputValor().toString();
		
		if(contaInvestimento.depositar(Double.parseDouble(valorDeposito))) {
			if(contaInvestimentoDAO.atualizarConta(contaInvestimento)) {
				Transacao transacao = new Transacao(LocalDate.now(), contaInvestimento, contaInvestimento, Double.parseDouble(valorDeposito), "DEPOSITO");
				contaInvestimento.salvarTransacao(transacao);
				System.out.println("Depósito no valor de R$ " + valorDeposito + " realizado com sucesso!!!");
			}else {
				System.out.println("Depósito não realizado !!! Falha no depósito!!!");
			}
		}else {
			System.out.println("Depósito não realizado !!! Operação não permitida!!!");
		}
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaInvestimento();
		
	}
	
	public Object saldoContaInvestimento() {
		System.out.println("### SALDO CONTA INVESTIMENTO ###");
		
		System.out.println("O saldo da Conta Investimento " + contaInvestimento.getConta() + " é R$ " + contaInvestimento.getSaldo());
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaInvestimento();
		
	}
	
	public Object acessarCadastrarConta() {
		int opcaoMenu = 0;
		geralController = new GeralController();
		System.out.println("### Menu Conta Investimento ###");
		do {
			menu.menuCadastrarAcessarConta();
			try {
				opcaoMenu = leitor.nextInt();

				if (opcaoMenu == 1) {
					return this.cadastrarContaInvestimento();
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
		this.getInputContaInvestimento();
		return this.menuOpcoesContaInvestimento();
	}
	
	public Object extratoContaInvestimento() {
		System.out.println("### EXTRATO CONTA INVESTIMENTO ###");
		contaInvestimento.extrato();
		geralController.continuarSair();
		return this.menuOpcoesContaInvestimento();
		
	}

	public Object transferenciaContaInvestimento() throws NumberFormatException {
		System.out.println("### TRANSFERENCIA CONTA INVESTIMENTO ###");
		
		LocalDate dtAgora = LocalDate.now();
		String diaSemana = dtAgora.getDayOfWeek().toString();
		
		if(!diaSemana.equals("SATURDAY") && !diaSemana.equals("SUNDAY")) {
			Conta contaTransferir = (Conta) geralController.getInputContaTransferir();
			String valorTransferir = geralController.getInputValor().toString();
			
			
			if(contaInvestimento.transferir(contaInvestimento, contaTransferir, Double.parseDouble(valorTransferir))) {
				if(contaInvestimentoDAO.atualizarConta(contaInvestimento)) {
					if(DAOFake.atualizarSaldo(contaTransferir)) {
						Transacao transacao = new Transacao(LocalDate.now(), contaInvestimento, contaTransferir, Double.parseDouble(valorTransferir), "TRANSFERENCIA");
						contaInvestimento.salvarTransacao(transacao);
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
		
		return this.menuOpcoesContaInvestimento();
		
	}

	public Object alterarContaInvestimento() {
		geralController = new GeralController();
		System.out.println("### Alterar Cadastro Conta Investimento ###");
		System.out.println("Dados da conta: " + contaInvestimento.toString());
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
		
		contaInvestimento.setNome(nomeCompleto);
		contaInvestimento.setAgencia(agencia);
		contaInvestimento.setRendaMensal(rendaMensal);

		if(contaInvestimentoDAO.atualizarConta(contaInvestimento)) {
			System.out.println("Conta Investimento alterada sucesso!!!");
			System.out.println("Dados da conta: " + contaInvestimento.toString());
		}
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}

	public Object escolherTipoInvestimento() {
		int opcaoMenu = 0;

		do {
			menu.tiposInvestimento();
			try {
				opcaoMenu = leitor.nextInt();
				
				if (opcaoMenu == 0 ) {
					return this.acessarCadastrarConta();
				}
				
				if (opcaoMenu == 1) {
					contaInvestimento.rendimentoAnualInvestimento(Investimento.TESOURO_DIRETO);
					break;
				}else if(opcaoMenu == 2) {
					contaInvestimento.rendimentoAnualInvestimento(Investimento.FUNDOS_IMOBILIARIOS);
					break;
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 8);
		
		
		geralController.continuarSair();
		
		return this.acessarCadastrarConta();
	}
	
	public Object simularInvestimento() {
		int opcaoMenu = 0;
		System.out.println("### Simular Investimento do Saldo ###");

		do {
			menu.tiposInvestimento();
			try {
				opcaoMenu = leitor.nextInt();
				
				if (opcaoMenu == 0 ) {
					return this.acessarCadastrarConta();
				}
				
				if (opcaoMenu == 1) {
					contaInvestimento.simularRendimentoAnual(Investimento.TESOURO_DIRETO);
					break;
				}else if(opcaoMenu == 2) {
					contaInvestimento.simularRendimentoAnual(Investimento.FUNDOS_IMOBILIARIOS);
					break;
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 8);
		
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaInvestimento();
	}
	
	public Object realizarInvestimento() {
		int opcaoMenu = 0;
		System.out.println("### Realizar Investimento ###");
		
		do {
			menu.tiposInvestimento();
			try {
				opcaoMenu = leitor.nextInt();
				
				if (opcaoMenu == 0 ) {
					return this.acessarCadastrarConta();
				}
				
				if (opcaoMenu == 1 || opcaoMenu == 2) {
					String valorInvestir = geralController.getInputValor().toString();
					System.out.println("Valor a ser Investido: " + valorInvestir);
					if(opcaoMenu == 1) {
						if(!contaInvestimento.realizarInvestimento(contaInvestimento, Investimento.TESOURO_DIRETO, Double.parseDouble(valorInvestir))) {
							break;
						}
					}else {
						if(!contaInvestimento.realizarInvestimento(contaInvestimento, Investimento.FUNDOS_IMOBILIARIOS, Double.parseDouble(valorInvestir))) {
							break;
						}
					}
					if(contaInvestimentoDAO.atualizarConta(contaInvestimento)) {
						Transacao transacao = new Transacao(LocalDate.now(), contaInvestimento, contaInvestimento, Double.parseDouble(valorInvestir), "INVESTIMENTO");
						contaInvestimento.salvarTransacao(transacao);
						DAOFake.totalValorInvestido.add(Double.parseDouble(valorInvestir));
					}else {
						System.out.println("Falha ao atualizar saldo após investimento !!!");
					}
					break;
					
				} else {
					System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				}
			} catch (Exception e) {
				System.out.println("Opção digitada é inválida!!! Digite uma opção válida do Menu!!!");
				leitor.next();
			}
		} while (opcaoMenu != 8);
		
		
		geralController.continuarSair();
		
		return this.menuOpcoesContaInvestimento();
	}
}
