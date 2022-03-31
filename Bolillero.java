package FINAL;

import java.util.ArrayList;

public class Bolillero {

    static final int CANTIDAD_NUMEROS = 90;
    private ArrayList<Integer> numeros;

    /**
     * Al crear el bolillero, se deben asignar al mismo los números del 1 al 90 (CANTIDAD_NUMEROS)
     */
    public Bolillero() {
        this.numeros = new ArrayList<>();
        asignarNumeros();
    }

    /**
     * Retorna true si el bolillero contiene números que todavia no fueron elegidos.
     */
    public boolean tieneNumeros() {
        return !this.numeros.isEmpty();
    }

    /**
     * Obtiene la lista de numeros dentro del bolillero.
     */
    public ArrayList<Integer> getNumeros() {
        // OJO: Uso .clone() porque no quiero que se pueda modificar el array de números del bolillero fuera de esta clase.
        // Otra forma seria simplemente crear un NUEVO array (con igual contenido) y devolverlo.
        return (ArrayList<Integer>) this.numeros.clone();
    }

    /**
     * Elige y remueve un numero random del bolillero.
     */
    public int sacarNumero() {
        if (!tieneNumeros()) {
            return -1;
        }
        int random = (int) Math.floor(Math.random() * getNumeros().size());
        return this.numeros.remove(random);
    }

    /**
     * Devuelve la cantidad de numeros ya elegidos.
     */
    public int getNumerosEmitidos() {
        return CANTIDAD_NUMEROS - this.numeros.size();
    }

    private void asignarNumeros() {
        for (int i = 1; i <= CANTIDAD_NUMEROS; i++) {
            this.numeros.add(i);
        }
    }

}
