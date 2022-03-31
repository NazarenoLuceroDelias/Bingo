Spackage FINAL;

import java.util.ArrayList;

public class Carton {

	static int CANTIDAD_NUMEROS = 15;
	private int restantes;
	private ArrayList<Integer> numeros;

	/**
	 * Cuando se crea uyn carton, se deben elegir al azar 15 numeros (CANTIDAD_NUMEROS) que va a contener.
	 * Los numeros que va a contener deben estar dentro del bolillero (o nunca se podria llenar el carton).
	 */
	public Carton(ArrayList<Integer> numerosBolillero) {
		this.numeros = new ArrayList<>();
		asignarNumeros(numerosBolillero);
		this.restantes = CANTIDAD_NUMEROS;
	}

	/**
	 * Verifica si el numero que salia del bolillero esta en el carton.
	 * Si el carton esta completo (salieron todos los numeros que contiene), devuelve true.
	 */
	public boolean buscarNumero(int num) {
		if (this.numeros.contains(num)) {
			this.restantes--;
		}
		return this.restantes == 0;
	}

	@Override
	public String toString() {
		return "Carton [restantes=" + restantes + ", numeros=" + numeros.toString() + "]";
	}

	private void asignarNumeros(ArrayList<Integer> numerosBolillero) {
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			int random = (int) Math.floor(Math.random()*numerosBolillero.size());
			// OJO: Se usa clone en Bolillero para evitar que este remove() elimine numeros dentro de Bolillero.
			this.numeros.add(numerosBolillero.remove(random));
		}
	}

}
