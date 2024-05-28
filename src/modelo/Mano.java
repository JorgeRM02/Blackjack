package modelo;

import java.util.ArrayList;

public class Mano extends Mazo {
	
	public Mano() {
		this.cartas = new ArrayList<Carta>();
	}
	
	public int valorMano() {
		int valor=0;
		int numAses=0;
		for(Carta c : this.cartas) {
			if (c.getNumero()==1) {
				numAses++;
			}
			valor =  valor + c.GetValor();
		}
		// A continuacion si el numero pasa de 21 y hay ases en la mano
		if (numAses>0 && valor>21) {
			valor=valor-10;
			numAses--;
		}
		return valor;
	}
	
	// El siguiente método se comprueba si hay mas de 21 puntos en la mano e indica el fin del juego.
	public boolean finDeJuego() {
		if(valorMano()>=21) {
			return true;
		}
			return false;	
		}

	@Override
	public String toString() {
		return "Mano [cartas=" + cartas + "] Valor de la mano: " + valorMano();
	}
	
	public void pedirCarta(Mazo baraja) throws NohayMasCartasException, Masde21Exception, HayBlackJackException{
		// Recoge la carta que se encuentra en el principio del mazo
		Carta c = baraja.solicitarCarta();
		this.cartas.add(c);
		if (valorMano()>21) {
			throw new Masde21Exception();
	}
		if (valorMano()==21) {
			throw new HayBlackJackException();
		}
}
	
	
	
}

		
	
	

