package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class ProgrammEventi {

	public static void main(String[] args) throws Exception {
		LocalDate data = LocalDate.of(2025, 01, 28);
		LocalDate data2 = LocalDate.of(2026, 03, 26);
		LocalDate data3 = LocalDate.of(2028, 01, 21);
		LocalDate data4 = LocalDate.of(2028, 01, 21);
		LocalDate data5 = LocalDate.of(2028, 01, 21);
		LocalDate data6 = LocalDate.of(2025, 03, 27);
		LocalDate data7 = LocalDate.of(2023, 04, 18);

		// Formattatore data
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<Evento> listaDiEventi = new ArrayList<Evento>();

		Evento evento1 = new Evento("Concerto Vasco Rossi", data, 1500);
		Evento evento2 = new Evento("Concerto Tiziano Ferro", data2, 1800);
		Evento evento3 = new Evento("Teatro Pinocchio", data3, 1000);
		Evento evento4 = new Evento("Concerto Guns'n Roses", data4, 1500);
		Evento evento5 = new Evento("Concerto Vasco Rossi", data5, 1500);
		Evento evento6 = new Evento("Pizza Village", data6, 4000);
		Evento evento7 = new Evento("Sagra della Porchetta", data7, 800);

		listaDiEventi.add(evento1);
		listaDiEventi.add(evento2);
		listaDiEventi.add(evento3);
		listaDiEventi.add(evento4);
		listaDiEventi.add(evento5);
		listaDiEventi.add(evento6);
		listaDiEventi.add(evento7);

		System.out.println(listaDiEventi);
		Collections.sort(listaDiEventi);

		for (Evento current : listaDiEventi) {
			System.out.println(current);
		}
	}

}
