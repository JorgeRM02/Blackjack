package modelo;

import java.util.ArrayList
;
import java.util.Collections;

import modelo.Carta.Palo;

public class Mazo {
	
	//Variables miembro
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
		//Creamos la lista de cartas vacias
		this.cartas= new ArrayList<Carta>();
		
		//El primer buclde recorre la lista de palos. El segundo anidado recorre los valores de las cartas
		for (Palo p: Palo.values()) {
			for (int i= 1; i<=13; i++) {
				Carta carta = new Carta(i,p);
				this.cartas.add(carta);
			}
		}
		
	}

	@Override
	public String toString() {
		return "Mazo cartas=" + cartas ;
	}
	
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	public Carta solicitarCarta() throws NohayMasCartasException {
		if (this.cartas.size()==0) {
			throw new NohayMasCartasException();
		} 
		// Recogemos la primera carta del mazo
		Carta c = this.cartas.get(0);
		// Eliminamos esa carta del mazo
		this.cartas.remove(0);
		//Devolvemos la carta
		return c;
	}
	
}
