package jana60;

import java.time.LocalDate;

public class Evento {

	// Attributi
	private String titolo;
	private LocalDate data;
	private int numeroPostiTotali, numeroPostiPrenotati;

	// Costruttore
	public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws Exception {
		super();
		this.titolo = titolo;
		this.data = data;
		this.numeroPostiTotali = numeroPostiTotali;
		this.numeroPostiPrenotati = 0;

		// Validazioni del costruttore
		this.validaData();
		this.validNumPostTotali();
	}

	// Metodi
	public void validaData() throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("La data non può essere nel passato, inserisci una data valida");
		}
	};

	public void validNumPostTotali() throws Exception {
		if (numeroPostiTotali <= 0)
			throw new Exception("Puoi inserire solo un numero positivo come PostiTotali!, riprova");

	}
};
