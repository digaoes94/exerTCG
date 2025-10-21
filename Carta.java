package cartas;

import jogador.Jogador;

public abstract class Carta {
	private String nome;
	private int poder;
	protected static int cartasJogadas;
	
	public Carta(String nome, int poder) {
		this.nome = nome;
		this.poder = poder;
	}

	public String getNome() {
		return nome;
	}

	public int getPoder() {
		return poder;
	}

	public static int getCartasJogadas() {
		return cartasJogadas;
	}
	
	public abstract void jogar(Jogador atual, Jogador adversario);
}
