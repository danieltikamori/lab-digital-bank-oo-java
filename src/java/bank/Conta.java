package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int digitoSequencial = 1;

	private final int agencia;
	private final int numero;
	private BigDecimal saldo;
	private Cliente cliente;

	private List<Transaction> transactionHistory;

	protected Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = digitoSequencial++;
		this.saldo = BigDecimal.ZERO; // Initialize saldo to zero
		this.cliente = cliente;
		this.transactionHistory = new ArrayList<>();
	}

	@Override
	public void sacar(BigDecimal valor) throws SaldoInsuficienteException {
		if (this.saldo.compareTo(valor) < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
		}
		this.saldo = this.saldo.subtract(valor);
		transactionHistory.add(new Transaction(TransactionType.WITHDRAWAL, valor, this.numero));
	}

	@Override
	public void depositar(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Valor deve ser maior que zero.");
		}
		this.saldo = this.saldo.add(valor);
		transactionHistory.add(new Transaction(TransactionType.DEPOSIT, valor, this.numero));
	}

	@Override
	public void transferir(BigDecimal valor, Conta contaDestino) throws SaldoInsuficienteException {
		this.sacar(valor);
		contaDestino.depositar(valor);
		transactionHistory.add(new Transaction(TransactionType.TRANSFER, valor, this.numero));
	}

	public List<Transaction> getTransactionHistory() {
		return transactionHistory;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}