package bank;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class ContaTest {

    private Conta conta;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Daniel", 1234567890);
        conta = new ContaCorrente(cliente);
    }

    @Test
    void sacar() throws SaldoInsuficienteException {
        // Arrange
        BigDecimal valorSaque = new BigDecimal("100.00");
        conta.depositar(new BigDecimal("200.00"));

        // Act
        conta.sacar(valorSaque);

        // Assert
        assertEquals(new BigDecimal("100.00"), conta.getSaldo());
    }

    @Test
    void sacarSaldoInsuficiente() {
        // Arrange
        BigDecimal valorSaque = new BigDecimal("100.00");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(valorSaque));
    }

    @Test
    void depositar() {
        // Arrange
        BigDecimal valorDeposito = new BigDecimal("150.00");

        // Act
        conta.depositar(valorDeposito);

        // Assert
        assertEquals(new BigDecimal("150.00"), conta.getSaldo());
    }

    @Test
    void transferir() throws SaldoInsuficienteException {
        // Arrange
        Conta contaDestino = new ContaCorrente(new Cliente("João", 987654321));
        BigDecimal valorTransferencia = new BigDecimal("50.00");
        conta.depositar(new BigDecimal("100.00"));

        // Act
        conta.transferir(valorTransferencia, contaDestino);

        // Assert
        assertEquals(new BigDecimal("50.00"), conta.getSaldo());
        assertEquals(new BigDecimal("50.00"), contaDestino.getSaldo());
    }

    @Test
    void getSaldo() {
        assertEquals(BigDecimal.ZERO, conta.getSaldo());
    }

    @Test
    void getCliente() {
        assertEquals(cliente, conta.getCliente());
    }
}