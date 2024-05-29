package app;

import java.util.Scanner;

import modelo.HayBlackJackException;
import modelo.Mano;
import modelo.Masde21Exception;
import modelo.Mazo;
import modelo.NohayMasCartasException;

public class Juego {

	public static void main(String[] args) {
		// Creamos una baraja con todas las cartas
		Mazo baraja = new Mazo();
		
		//Barajamos las cartas
		baraja.barajar();
		// Creamos la mano de cartas para el jugador
		Mano jugador = new Mano();
		
		// Creamos la mano de cartas para la banca
		Mano banca = new Mano();
		
		System.out.println("Comenznado el juego. Repartiendo una carta...");
		
		try {
			System.out.println("Repartiendo cartas");
			banca.pedirCarta(baraja);
			jugador.pedirCarta(baraja);
			
			
			try {
				banca.pedirCarta(baraja);
			} catch (HayBlackJackException e){
			}
			jugador.pedirCarta(baraja);
			
			
			System.out.println("Jugador tu mano es: "+jugador);
			
			
		} catch(HayBlackJackException e) {
			
			System.out.println("Has conseguido el BlackJack. Ganas la ronda.");
			System.out.println(jugador);
		}catch (Exception e) {
		}
		
		Scanner teclado = new Scanner(System.in);
		String opcion;
		try {	
			if (!jugador.finDeJuego()) {
				do {
					System.out.println("Quiere otra carta? S/N");
					opcion = teclado.nextLine();
					
					if(opcion.equalsIgnoreCase("S")) {
						jugador.pedirCarta(baraja);
						System.out.println("Jugador tu mano es: "+jugador);
					}

				} while (opcion.equalsIgnoreCase("S"));
				System.out.println("Te has plantado");
			} 
				
		
		} catch (NohayMasCartasException e) {
			e.printStackTrace();
		} catch (Masde21Exception e) {
			System.out.println("Tienes más de 21, has perdido");
			System.out.println("Jugador tu mano es: "+jugador);
			System.out.println("Banca tu mano es: "+banca);
			return;
		} catch (HayBlackJackException e) {
			System.out.println("Tienes BlackJack, has ganado");
		}
		
		
		// Juega la banca, debe pedir carta hasta conseguir al menos 16 pts.
		
		
			try {
				while (banca.valorMano()<=16) {
					banca.pedirCarta(baraja);
				}	
			}catch (NohayMasCartasException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}catch (Masde21Exception e) {
				System.out.println("Banca tu mano es: "+banca);
				System.out.println("Banca, tienes más de 21, has perdido");
				
				if (jugador.valorMano()<=21) {
					System.out.println("Gana jugador");
				} else {
					System.out.println("No gana nadie");
				}
				return;
				
			}catch (HayBlackJackException e) {
				if (jugador.valorMano()<21 || jugador.valorMano()>21) {
					System.out.println("Tienes BlackJack, gana la banca");
				} else {
					System.out.println("Empate, nadie gana");
				}
				return;
				
			}
			if (jugador.valorMano()<=banca.valorMano()){
				System.out.println("Jugador tu mano es: "+jugador);
				System.out.println("Banca tu mano es: "+banca);
				System.out.println("Gana la banca");
			} else {
				System.out.println("Jugador tu mano es: "+jugador);
				System.out.println("Banca tu mano es: "+banca);
				System.out.println("Gana el jugador");
			}
			
		}
	
	}
	

