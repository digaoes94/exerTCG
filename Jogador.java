package jogador;

import jogador.interfaces.Jogavel;

public class Jogador implements Jogavel {
	private String nome;
	private int vida, def;
	
	public Jogador(String nome) {
		this.nome = nome;
		this.vida = 2;
		this.def = 50;
	}

	public String getNome() {
		return nome;
	}
	public int getVida() {
		return vida;
	}
	public int getDef() {
		return def;
	}

	@Override
	public String toString() {
		return String.format("%s - VIDA: %d | DEF: %d", this.nome, this.vida, this.def);
	}

	@Override
	public void atacar(int poder) {
		int aux = this.def - poder;
		
		if(aux > 0) {
			this.def = aux;
		}
		else if(aux == 0) {
			this.vida--;
			this.def = 100;
		}
		else {
			this.vida--;
			this.def = 100 + aux;
		}
	}

	@Override
	public void defender(int poder) {
		int aux = this.def + poder;
		
		if(aux > 100) {
			this.def = 100;
		}
		else {
			this.def = aux;
		}
	}

	@Override
	public boolean estaVivo() {
		if(this.vida > 0 && this.def > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}