package bank;

import java.math.BigDecimal;

public interface IConta {
	
	void sacar(BigDecimal valor) throws SaldoInsuficienteException;
	
	void depositar(BigDecimal valor);
	
	void transferir(BigDecimal valor, IConta contaDestino);
	
	void imprimirExtrato();

	void transferir(BigDecimal valor, Conta contaDestino) throws SaldoInsuficienteException;
}
