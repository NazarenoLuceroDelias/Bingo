Spackage FINAL;

import java.util.ArrayList;

public class Bingo {

	static final int PARTICIPANTES_MINIMOS = 5;
	static final int PARTICIPANTES_MAXIMOS = 100;

	private Bolillero bolillero;
	private ArrayList<Participante> participantes;

	public Bingo() {}

	/**
	 * Este método recibe un numero de participantes y hace lo siguiente:
	 * 1- Inicializa los elementos del juego
	 * 2- Genera a los participantes
	 * 3- Simula una ronda entera, hasta encontrar un ganador
	 */
	public void simularRonda(int cantidadDeParticipantes) {
		/* Inicializo los elementos del juego */
		this.bolillero = new Bolillero();
		this.participantes = new ArrayList<>();

		/* Genero a los participantes */
		if (cantidadDeParticipantes < PARTICIPANTES_MINIMOS || cantidadDeParticipantes > PARTICIPANTES_MAXIMOS) {
			return;
		}
		for (int i = 0; i < cantidadDeParticipantes; i++) {
			this.participantes.add(new Participante(i, this.bolillero.getNumeros()));
		}

		/* Simulo la ronda */
		ArrayList<Participante> ganadores = new ArrayList<>();
		System.out.println("*************************************************");
		System.out.printf("*** Arranca la ronda con %d participantes!! ***\n", cantidadDeParticipantes);
		while (this.bolillero.tieneNumeros()) {
			int numero = this.bolillero.sacarNumero();

			for (Participante participante : this.participantes) {
				boolean bingo = participante.verificarNumero(numero);
				if (bingo) {
					ganadores.add(participante);
					System.out.printf("---> El participante %d canto BINGO con el numero %d !!!%n", participante.getId(), numero);
				}
			}

			if (!ganadores.isEmpty()) {
				break;
			}
		}

		System.out.printf("*** Se tiraron %d numeros antes de conocer a el o los ganadores!! ***\n", this.bolillero.getNumerosEmitidos());
		System.out.println("Demos paso a los ganadores y sus cartones:");

		for (Participante ganador : ganadores) {
			System.out.println(ganador.toString());
		}
	}
}
