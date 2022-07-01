package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		try {
			boolean flag = true;
			do {
				int key;
				System.out.println("Ciao, benvenuto nella piattaforma del Gestore Utenti!");
				System.out.println("Inserisci 1 per inserire un nuovo evento e 2 per uscire.");
				key = Integer.parseInt(scan.nextLine());
				switch (key) {
				case 1:
					System.out.println("Benvenuto nella sezione creazione eventi!");
					System.out.print("Inserisci il titolo dell'evento: ");
					String titolo = scan.nextLine();
					boolean giornoErrato = true;
					int giornoEvento;
					do {
						System.out.println("Inserisci il giorno dell'evento (1-31): ");
						giornoEvento = Integer.parseInt(scan.nextLine());
						if (giornoEvento >= 1 && giornoEvento <= 31) {
							giornoErrato = false;
						} else {
							System.out.println("Hai inserito un giorno non valido! Inserisci un numero tra 1 e 31!");

						}
					} while (giornoErrato);
					boolean meseErrato = true;
					int meseEvento;

					do {
						System.out.println("Inserisci il mese dell'evento (1-12): ");
						meseEvento = Integer.parseInt(scan.nextLine());
						if (meseEvento >= 1 && meseEvento <= 12) {
							meseErrato = false;
						} else {
							System.out.println("Hai inserito un mese non valido! Inserisci un numero tra 1 e 12!");

						}
					} while (meseErrato);
					boolean annoErrato = true;
					int annoEvento;

					do {
						System.out.println("Inserisci l'anno dell'evento (min 2022 - max 2072): ");
						annoEvento = Integer.parseInt(scan.nextLine());
						if (annoEvento >= 2022 && annoEvento <= 2072) {
							annoErrato = false;
						} else {
							System.out.println(
									"Hai inserito un anno non valido! Non puoi creare un evento nel passato o superiore a 50 anni!");

						}
					} while (annoErrato);

					LocalDate data = LocalDate.of(annoEvento, meseEvento, giornoEvento);

					System.out.println("Inserisci il numero di posti totali: ");
					int postiTotali = Integer.parseInt(scan.nextLine());
					Evento nuovoEvento = new Evento(titolo, data, postiTotali);
					System.out.println("Complimenti hai appena creato un nuovo evento: " + nuovoEvento);

					boolean nuovaOperazione = true;
					do {
						boolean sceltaErrata = true;
						int key2;
						do {
							System.out.println(
									" Desideri inserire prenotazioni per questo evento? Digita 1 per inserire prenotazioni - 2 per disdire prenotazioni - 3 per uscire.");

							key2 = Integer.parseInt(scan.nextLine());
							if (key2 >= 1 && key <= 3) {
								sceltaErrata = false;
							}
						} while (sceltaErrata);
						switch (key2) {
						case 1:
							boolean numeroErrato = true;

							do {
								try {
									System.out.println("Quanti posti vuoi prenotare? ");
									nuovoEvento.prenota(Integer.parseInt(scan.nextLine()));
									;
									System.out.println("Ecco il numero finale di persone prenotate per l'evento è di: "
											+ nuovoEvento.getNumeroPostiPrenotati()
											+ ". I posti rimanenti disponibili sono: "
											+ nuovoEvento.postiDisponibili());
									numeroErrato = false;
								} catch (NumberFormatException nfe) {
									System.out.println("Hai inserito un carattere non valido, Inserisci solo numeri!");
									System.out.println(nfe.getMessage());
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							} while (numeroErrato);
							System.out.println("Vuoi inserire o togliere altri prenotati? Digita solo Si o No");
							String scelta = scan.nextLine();
							if (scelta.equalsIgnoreCase("No")) {
								nuovaOperazione = false;
							}
							break;

						case 2:
							boolean numeroErrato2 = true;
							do {
								try {
									System.out.println("Quanti posti vuoi disdire? ");
									nuovoEvento.disdici(Integer.parseInt(scan.nextLine()));
									System.out.println("Ecco il numero finale di persone prenotate per l'evento è di: "
											+ nuovoEvento.getNumeroPostiPrenotati()
											+ ". I posti rimanenti disponibili sono: "
											+ nuovoEvento.postiDisponibili());

									numeroErrato2 = false;

								} catch (NumberFormatException nfe) {
									System.out.println("Hai inserito un carattere non valido, Inserisci solo numeri!");
									System.out.println(nfe.getMessage());
								} catch (Exception e) {
									System.out.println(e.getMessage());

								}
							} while (numeroErrato2);
							System.out.println("Vuoi inserire o togliere altri prenotati? Digita solo Si o No");
							String scelta2 = scan.nextLine();
							if (scelta2.equalsIgnoreCase("No")) {
								nuovaOperazione = false;
							}

						default:
							System.out.println("Ecco il numero finale di persone prenotate per l'evento è di"
									+ nuovoEvento.getNumeroPostiPrenotati() + "I posti rimanenti disponibili sono:"
									+ nuovoEvento.postiDisponibili());

							break;
						}

					} while (nuovaOperazione);
					break;
				default:
					System.out.println("Grazie per aver utulizzato la piattaforma del Gestore Utenti, alla prossima!");
					flag = false;
					break;
				}
			} while (flag);

		} catch (NumberFormatException nfe) {
			System.out.println("Hai inserito un carattere non valido, Inserisci solo numeri!");
			System.out.println(nfe.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		scan.close();
	}

}
