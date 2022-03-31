package FINAL;

import java.util.ArrayList;

public class Participante {

	private int id;
	private Carton carton;

	/**
	 * Crea un participante con su Id y su Carton.
	 */
	public Participante(int id, ArrayList<Integer> numerosBolillero) {
		this.id = id;
		this.carton = new Carton(numerosBolillero);
	}

	public int getId() {
		return id;
	}

	/**
	 * Verifica si el numero que salió del bolillero está en el carton.
	 * Si el carton esta completo (salieron todos los números que contiene), devuelve true.
	 */
	public boolean verificarNumero(int num) {
		return carton.buscarNumero(num);
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", carton=" + carton.toString() + "]";
	}

}
