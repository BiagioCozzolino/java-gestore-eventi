package jana60;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ProgrammEventi {

	public static void main(String[] args) throws Exception {
		LocalDate data = LocalDate.of(2022, 7, 28);
		LocalDate data2 = LocalDate.of(2022, 8, 1);
		LocalDate data3 = LocalDate.of(2028, 1, 21);
		LocalDate data4 = LocalDate.of(2028, 1, 21);
		LocalDate data5 = LocalDate.of(2028, 1, 21);
		LocalDate data6 = LocalDate.of(2025, 3, 27);
		LocalDate data7 = LocalDate.of(2022, 9, 18);

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

		Collections.sort(listaDiEventi);
		for (Evento current : listaDiEventi) {
			System.out.println(current);
		}

		// Divisione in altre due liste Recenti e Futuri con Interator

		// Dichiaro le due liste
		ArrayList<Evento> prossimiEventi = new ArrayList<Evento>();
		ArrayList<Evento> eventiFuturi = new ArrayList<Evento>();

		LocalDate today = LocalDate.now();
		Iterator<Evento> EventiIterator = listaDiEventi.iterator();
		while (EventiIterator.hasNext()) {
			Evento eventoCorrente = EventiIterator.next();
			if (eventoCorrente.getData().getYear() == today.getYear()) {
				if (eventoCorrente.getData().getMonthValue() == today.getMonthValue()) {
					prossimiEventi.add(eventoCorrente);
				} else if ((today.getMonthValue() + 1) == eventoCorrente.getData().getMonthValue()) {
					if (eventoCorrente.getData().getDayOfMonth() <= today.getDayOfMonth()) {
						prossimiEventi.add(eventoCorrente);
					}

				} else {
					eventiFuturi.add(eventoCorrente);
				}

			} else {
				eventiFuturi.add(eventoCorrente);
			}

		}
		System.out.println("Ecco la lista degli eventi Prossimi (Entro 1 mese): ");
		for (Evento recenti : prossimiEventi) {
			System.out.println(recenti);
		}
		System.out.println("Ecco la lista degli eventi Futuri (Oltre 1 mese): ");
		for (Evento futuri : eventiFuturi) {

			System.out.println(futuri);
		}
	}
}
