package bank;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException {
		// Create clients
		Cliente daniel = new Cliente("Daniel", 1234567890);
		Cliente charles = new Cliente("Charles", 987654320);

		// Create accounts
		ContaCorrente cc = new ContaCorrente(daniel);
		ContaPoupanca poupanca = new ContaPoupanca(daniel);
		Conta conta1 = new ContaCorrente(charles); // Assuming conta1 is a checking account

		// Perform transactions
		cc.depositar(BigDecimal.valueOf(100));
		cc.transferir(BigDecimal.valueOf(50), poupanca); // Transfer from cc to poupanca
		conta1.depositar(new BigDecimal("100.00"));
		conta1.sacar(new BigDecimal("50.00"));

		// Print account statements
		System.out.println("---- Conta Corrente ----");
		cc.imprimirExtrato();
		System.out.println("---- Conta Poupança ----");
		poupanca.imprimirExtrato();
		System.out.println("---- Conta 1 ----");
		conta1.imprimirExtrato();

		// Print transaction history for conta1
		System.out.println("---- Transaction History for Conta 1 ----");
		for (Transaction transaction : conta1.getTransactionHistory()) {
			System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount() + ", Account: " + transaction.getAccountNumber());
		}
	}
}