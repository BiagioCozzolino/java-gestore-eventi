package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento {

	// Attributi

	private String argomento;
	private Oratore oratore;

	// Costruttore
	public Conferenza(String titolo, LocalDate data, int numeroPostiTotali, String argomento, Oratore oratore)
			throws Exception {
		super(titolo, data, numeroPostiTotali);
		this.argomento = argomento;
		this.oratore = oratore;

	}

	@Override
	public String toString() {

		return super.toString() + " Questo evento è una conferenza con Argomento: " + argomento + ", l'oratore è : "
				+ oratore.getNome() + " " + oratore.getCognome() + ", con il titolo di: " + oratore.getTitolo();
	}

}
