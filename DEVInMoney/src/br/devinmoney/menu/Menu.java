package br.devinmoney.menu;

public class Menu {
	public void menuPrincipal() {
		System.out.println("#####################");
		System.out.println("###  DEVInMoney   ###");
		System.out.println("### Menu Princial ###");
		System.out.println("#####################");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Conta");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Finalizar Programa");
	}

	public void menuOpcoesCadastroConta() {
		System.out.println("###########################");
		System.out.println("###    DEVInMoney       ###");
		System.out.println("###    Menu Conta       ###");
		System.out.println("###########################");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Poupança");
		System.out.println("3 - Conta Investimento");
		System.out.println("4 - Voltar Menu Principal");
		System.out.println("5 - Finalizar Programa");
	}
	
	public void menuOpcoesAgencia() {
		System.out.println("Digite a opção da agência desejada:");
		System.out.println("1 - Florianópolis");
		System.out.println("2 - São José");
		System.out.println("3 - Voltar ao Menu Inicial");
	}
	
	public void acoesContaCorrente() {
		System.out.println("##############################");
		System.out.println("###    DEVInMoney          ###");
		System.out.println("###  Opções Conta Corrente ###");
		System.out.println("##############################");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Saque");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saldo");
		System.out.println("4 - Extrato");
		System.out.println("5 - Transferência");
		System.out.println("6 - Alterar Dados Cadastrais");
		System.out.println("7 - Voltar ao menu Inicial Conta Corrente");
		System.out.println("8 - Finalizar Programa");
		
	}
	
	public void menuCadastrarAcessarConta() {
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Acessar Conta");
		System.out.println("3 - Voltar ao Menu Inicial");
	}
	
	public void acoesContaPoupanca() {
		System.out.println("##############################");
		System.out.println("###    DEVInMoney          ###");
		System.out.println("###  Opções Conta Poupança ###");
		System.out.println("##############################");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Saque");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saldo");
		System.out.println("4 - Extrato");
		System.out.println("5 - Transferência");
		System.out.println("6 - Alterar Dados Cadastrais");
		System.out.println("7 - Simular Rendimento");
		System.out.println("8 - Voltar ao menu Inicial Conta Poupanca");
		System.out.println("9 - Finalizar Programa");
		
	}
	
	public void tipoConta() {
		System.out.println("Digite o tipo de conta:");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Poupança");
		System.out.println("3 - Conta Investimento");
	}

	public void acoesContaInvestimento() {
		System.out.println("##################################");
		System.out.println("###    DEVInMoney          #######");
		System.out.println("###  Opções Conta Investimento ###");
		System.out.println("##################################");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Saque");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saldo");
		System.out.println("4 - Extrato");
		System.out.println("5 - Transferência");
		System.out.println("6 - Alterar Dados Cadastrais");
		System.out.println("7 - Ver Rendimento anual de Investimento");
		System.out.println("8 - Simular Rendimento do Saldo");
		System.out.println("9 - Realizar Investimento");
		System.out.println("10 - Voltar ao menu Inicial Conta Investimento");
		System.out.println("11 - Finalizar Programa");
		
	}
	
	public void tiposInvestimento() {
		System.out.println("Digite a opção de investimento desejada ou 0 para voltar menu:");
		System.out.println("1 - TESOURO DIRETO");
		System.out.println("2 - FUNDOS IMOBILIARIOS");
	}
	
	public void menuRelatorios() {
		System.out.println("###################");
		System.out.println("###  DEVInMoney ###");
		System.out.println("###  RELATORIOS ###");
		System.out.println("###################");
		System.out.println("Digite a opção desejada ou 0 para voltar menu:");
		System.out.println("1 - Listar todas as Contas");
		System.out.println("2 - Contas com saldo negativo");
		System.out.println("3 - Total do valor investido");
		System.out.println("4 - Todas as transações de um determinado cliente");
		System.out.println("5 - Voltar ao menu Inicial");
		System.out.println("6 - Finalizar Programa");
		
	}
	
}
