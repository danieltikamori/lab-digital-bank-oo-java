# Criando um Banco Digital com Java e Orientação a Objetos

## Um Banco Digital Simples com Java e Orientação a Objetos

Este projeto demonstra a implementação de um banco digital simples em Java, utilizando os princípios da Orientação a Objetos (OO). O objetivo é apresentar uma solução prática e didática para o desenvolvimento de sistemas bancários, explorando conceitos como:

- **Abstração:** Definindo classes que representam entidades do mundo real, como contas bancárias e clientes.
- **Encapsulamento:** Escondendo a implementação interna das classes e expondo apenas as funcionalidades necessárias através de métodos.
- **Herança:** Criando hierarquias de classes para representar diferentes tipos de contas (corrente e poupança), reutilizando código e comportamento.
- **Polimorfismo:** Permitindo que diferentes tipos de contas sejam tratados de forma genérica, através de interfaces e métodos abstratos.

## Estrutura do Projeto

O projeto está organizado em pacotes, cada um com um propósito específico:

- **`bank`:** Contém as classes principais do sistema bancário, como `Conta`, `ContaCorrente`, `ContaPoupanca`, `Cliente`, `Transaction`, `TransactionType`, `SaldoInsuficienteException`, e `Transactions`.
- **`Main`:**  A classe principal que contém o ponto de entrada do programa, onde são criados objetos e realizadas operações bancárias.

## Como Executar o Projeto

1. **Clone o repositório:**
```bash
git clone https://github.com/danieltikamori/lab-digital-bank-oo-java.git
```

2. **Compile o projeto:**

```bash
javac bank/*.java Main.java
``` 

3. **Execute o programa:**

```bash
java Main
```

## Demonstração

O programa demonstra as seguintes funcionalidades:
- **Criação de contas:** Cria contas correntes e poupança para clientes.
- **Depósito:** Permite depositar dinheiro em uma conta.
- **Saque:** Permite sacar dinheiro de uma conta, verificando se há saldo suficiente.
- **Transferência:** Permite transferir dinheiro entre contas.
- **Extrato:** Imprime o extrato de uma conta, mostrando o saldo atual.
- **Histórico de Transações:** Armazena e exibe o histórico de transações de uma conta.


## Próximos Passos
Este projeto é um ponto de partida para o desenvolvimento de um sistema bancário mais completo. Algumas ideias para futuras implementações:

* **Gerenciamento de Usuários:** Implementar login e autenticação de usuários.
* **Taxas e Juros:** Incluir taxas e juros para contas correntes e poupança.
* **Investimentos:** Adicionar funcionalidades para investimentos.
* **Interface Gráfica:** Criar uma interface gráfica para interagir com o sistema.
* **Persistência de Dados:** Implementar a persistência de dados em um banco de dados.

## Contribuições

Contribuições são bem-vindas! Se você tiver alguma sugestão ou melhoria, sinta-se à vontade para abrir um pull request.

## Licença

Este projeto está licenciado sob a licença MIT.