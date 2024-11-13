package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return url;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE\n" + innleggToString() + getTekst() + "\n" + url + "\n"; 
		//Går det an å bruke toString metoda til Innlegg direkte? Måten eg brukar er litt tungvindt.

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
