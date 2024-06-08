package bank;

public class Cliente {

	private final int number;
	private String nome;

	public Cliente(String clientName, int number) {
		this.nome = clientName;
		this.number = number;
	}

	public Cliente(int number) {
        this.number = number;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
