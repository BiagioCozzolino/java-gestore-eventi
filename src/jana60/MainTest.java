package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		// Inizializzo lo Scanner
		Scanner scan = new Scanner(System.in);

		try {
			// Creo la prima flag che tramite un doo while mi darà la possibilità di
			// inserire più eventi cominciando da capo
			boolean flag = true;
			do {
				int key;
				System.out.println("Ciao, benvenuto nella piattaforma del Gestore Utenti!");
				System.out.println("Inserisci 1 per inserire un nuovo evento e 2 per uscire.");
				// Prendo la scelta dell'utente e la metto nella key
				key = Integer.parseInt(scan.nextLine());
				switch (key) {

				// Caso 1 creazione nuovo evento
				case 1:
					System.out.println("Benvenuto nella sezione creazione eventi!");
					System.out.print("Inserisci il titolo dell'evento: ");
					String titolo = scan.nextLine();
					boolean giornoErrato = true;
					int giornoEvento;
					// Inserisco un do while per non farmi cominciare da capo nel caso sbagli ad
					// inserire un campo, effettuato anche per mese e anno
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

					// Solo se i dati sono tutti esatti allora si crea la mia data;

					LocalDate data = LocalDate.of(annoEvento, meseEvento, giornoEvento);

					// Chiedo i posti massimi dell'evento
					System.out.println("Inserisci il numero di posti totali: ");
					int postiTotali = Integer.parseInt(scan.nextLine());

					// Creo il mio nuovo evento di classe Evento
					Evento nuovoEvento = new Evento(titolo, data, postiTotali);
					// Stampo il risultato di tutti i dati inseriti dall'utente
					System.out.println("Complimenti hai appena creato un nuovo evento: " + nuovoEvento);

					// Chiedo se è una conferenza oppure no
					System.out.println("L'evento appena creato è una Conferenza? digita solo Si o No: ");
					String sceltaConferenza = scan.nextLine();
					// Se scegli SI allora entra nell'if dove fa inserire tutti i campi della classe
					// Conferenza
					if (sceltaConferenza.equalsIgnoreCase("Si")) {
						System.out.println("Inserire l'argomento della conferenza: ");
						String argomento = scan.nextLine();
						System.out.println("Inserisci ora i dati dell'oratore:");
						System.out.println("Nome dell'oratore: ");
						String nome = scan.nextLine();
						System.out.println("Cognome dell'oratore: ");
						String cognome = scan.nextLine();
						System.out.println("Titolo dell'oratore: ");
						String titolooratore = scan.nextLine();

						// Infine creo prima il nuovo oratore di classe Oratore
						Oratore nuovoOratore = new Oratore(nome, cognome, titolooratore);

						// Poi creo la nuova Conferenza grazie a Oratore e i dati precedenti
						Conferenza nuovaConferenza = new Conferenza(titolo, data, postiTotali, argomento, nuovoOratore);
						System.out.println(nuovaConferenza);
					}

					boolean nuovaOperazione = true;
					do {
						boolean sceltaErrata = true;
						int key2;

						// Chiedo all'utente se desidera inserire prenotazioni all'evento, disdire o
						// uscire tramite uno swich case verificando con opportuni do while che non
						// passino valori errati
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
