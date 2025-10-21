package cartas;

import jogador.Jogador;

public class CartaDefesa extends Carta {
	public CartaDefesa(String nome, int poder) {
		super(nome, poder);
	}

	@Override
	public void jogar(Jogador atual, Jogador adversario) {
		atual.defender(this.getPoder());
		Carta.cartasJogadas++;
	}
	
	@Override
	public String toString() {
		return String.format(" se defende com %s! Aumenta defesa em %d!", this.getNome(), this.getPoder());
	}
}