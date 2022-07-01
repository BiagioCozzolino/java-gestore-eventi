package jana60;

public class Oratore {

	// Attributi
	private String nome;
	private String cognome;
	private String titolo;

	// Costruttore
	public Oratore(String name, String cognome, String titolo) {
		super();
		this.nome = name;
		this.cognome = cognome;
		this.titolo = titolo;

	}

	// getter and setters

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTitolo() {
		return titolo;
	}
}
