package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

	// Formattatore data
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Getter and Setters

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroPostiTotali() {
		return numeroPostiTotali;
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
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

	public void prenota() throws Exception {
		if (numeroPostiPrenotati == numeroPostiTotali) {
			throw new Exception(
					"Mi dispiace ma i posti disponibili per questo evento sono terminati. Scegli un altro evento!");

		} else if (data.isBefore(LocalDate.now())) {
			throw new Exception("Mi dispiace ma l'evento selezionato è già passato!");
		} else {
			numeroPostiPrenotati++;
		}
	}

	public void disdici() throws Exception {
		if (numeroPostiPrenotati == 0) {
			throw new Exception(
					"Non ci sono prenotazioni per questo evento, non è possibile disdire se non hai prenotato!");

		} else if (data.isBefore(LocalDate.now())) {
			throw new Exception("Mi dispiace ma l'evento selezionato è già passato, è troppo tardi per disdire!");
		} else {
			numeroPostiPrenotati--;
		}
	}

	public String dataFormattata() {
		return formatter.format(data);
	}

	@Override
	public String toString() {
		return "L'evento selezionato inizierà il giorno: " + dataFormattata() + ". Il titolo dell'evento è: " + titolo
				+ ". Buon divertimento!";
	}

};
