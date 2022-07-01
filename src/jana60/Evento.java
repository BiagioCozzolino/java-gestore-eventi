package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento implements Comparable<Evento> {

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

	public void prenota(int num) throws Exception {
		if (postiDisponibili() < num) {
			throw new Exception(
					"Mi dispiace ma i posti disponibili per questo sono minori delle persone che vuoi prenotare. Scegli un altro evento o meno invitati (In caso di 0 posti rimanenti scegli un altro evento.");

		} else if (data.isBefore(LocalDate.now())) {
			throw new Exception("Mi dispiace ma l'evento selezionato è già passato!");
		} else {
			numeroPostiPrenotati += num;
		}
	}

	public void disdici(int num) throws Exception {
		if (num > numeroPostiPrenotati) {
			throw new Exception(
					"Non è possibile disdire il numero di posti inseriti e maggiore dei posti prenotati ovvero: "
							+ numeroPostiPrenotati);

		} else if (data.isBefore(LocalDate.now())) {
			throw new Exception("Mi dispiace ma l'evento selezionato è già passato, è troppo tardi per disdire!");
		} else {
			numeroPostiPrenotati -= num;
		}
	}

	public int postiDisponibili() {
		return numeroPostiTotali - numeroPostiPrenotati;
	}

	public String dataFormattata() {
		return formatter.format(data);
	}

	@Override
	public String toString() {
		return "L'evento selezionato inizierà il giorno: " + dataFormattata() + ". Il titolo dell'evento è: " + titolo
				+ ". Buon divertimento!";
	}

	@Override
	public int compareTo(Evento o) {
		// Inizio la comparazione dall'anno
		// Se è più piccolo ritorno -1
		if (this.data.getYear() < o.data.getYear()) {
			return -1;
		}
		// Se è uguale apro altro if per continuare a comparare ma con il mese
		else if (this.data.getYear() == o.data.getYear()) {
			if (this.data.getMonthValue() < o.data.getMonthValue()) {
				return -1;
			} else if (this.data.getMonthValue() == o.data.getMonthValue()) {
				if (this.data.getDayOfMonth() < o.data.getDayOfMonth()) {
					return -1;
				} else if (this.data.getDayOfMonth() == o.data.getDayOfMonth()) {
					return this.titolo.compareTo(o.titolo);

				} else
					return 1;

			} else {
				return 1;
			}
		}
		// se è più grande ritorno 1;
		else {
			return 1;
		}
	}

};
