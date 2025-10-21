/* LPOO - EXERCÍCIO AVALIATIVO 2 - PROFª CINTHIA CALIARI
GRUPO: RODRIGO ARAUJO SCHENBERG */

package application;

import java.util.Random;
import java.util.Scanner;

import cartas.Carta;
import cartas.CartaAtaque;
import cartas.CartaDefesa;
import jogador.Jogador;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static Carta[] deck = new Carta[7];
	public static Carta cartaSacada;
	public static Jogador j1, j2, atual, inimigo;

	public static void main(String[] args) {
		System.out.println("Bem-vindos ao FaesaCG! Vamos começar?");
		setup();
		
		while(j1.estaVivo() && j2.estaVivo() && Carta.getCartasJogadas() <= 30) {
			cartaSacada = proxCarta();
			atuar(cartaSacada);
			statusPartida();
		}
		
		checaFim();
	}
	
	private static void checaFim() {
		if(j1.estaVivo() && j2.estaVivo()) {
			if(j1.getVida() > j2.getVida()) {
				System.out.println(j1.getNome() + " ganhou!");
			}
			else if(j2.getVida() > j1.getVida()) {
				System.out.println(j2.getNome() + " ganhou!");
			}
			else {
				if(j1.getDef() > j2.getDef()) {
					System.out.println(j1.getNome() + " ganhou!");
				}
				else if(j2.getDef() > j1.getDef()) {
					System.out.println(j2.getNome() + " ganhou!");
				}
				else {
					System.out.println("EMPATE!");
				}
			}
		}
		
		if(!j2.estaVivo()) {
			System.out.println(j1.getNome() + " ganhou!");
		}
		if(!j1.estaVivo()) {
			System.out.println(j2.getNome() + " ganhou!");
		}
	}
	
	private static void statusPartida() {
		System.out.println("STATUS");
		System.out.println(j1.toString());
		System.out.println(j2.toString());
		System.out.println();
	}
	
	private static void atuar(Carta carta) {
		if(Carta.getCartasJogadas()%2 == 0) {
			carta.jogar(j1, j2);
			System.out.println(j1.getNome() + carta.toString() + "\n");
		}
		else {
			carta.jogar(j2, j1);
			System.out.println(j2.getNome() + carta.toString() + "\n");
		}
	}
	
	private static Carta proxCarta() {
		Random random = new Random();
		int n = random.nextInt(6);
		return deck[n];
	}

	private static void setup() {
		System.out.print("Informe o nome do Jogador 1: ");
		j1 = new Jogador(scan.nextLine());
		
		System.out.print("Informe o nome do Jogador 2: ");
		j2 = new Jogador(scan.nextLine());
		System.out.println();
		
		deck[0] = new CartaAtaque("Ataque de Adaga", 10);
		deck[1] = new CartaAtaque("Ataque de Espada Curta", 20);
		deck[2] = new CartaAtaque("Ataque de Rapieira", 30);
		deck[3] = new CartaAtaque("Ataque de Espadão", 40);
		deck[4] = new CartaDefesa("Reação Atrasada", 10);
		deck[5] = new CartaDefesa("Bloqueio Fraco", 15);
		deck[6] = new CartaDefesa("Esquiva Total", 20);
	}
}