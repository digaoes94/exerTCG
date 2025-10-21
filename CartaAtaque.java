package cartas;

import jogador.Jogador;

public class CartaAtaque extends Carta {
	public CartaAtaque(String nome, int poder) {
		super(nome, poder);
	}

	@Override
	public void jogar(Jogador atual, Jogador adversario) {
		adversario.atacar(this.getPoder());
		Carta.cartasJogadas++;
	}
	
	@Override
	public String toString() {
		return String.format(" atacou com %s! Causa %d de dano!", this.getNome(), this.getPoder());
	}
}