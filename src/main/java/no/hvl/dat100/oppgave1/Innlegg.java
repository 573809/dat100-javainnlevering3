package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {
	
	// TODO - deklarering av objektvariablar
	private int id;
	private String bruker;
	private String dato;
	private int likes;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
		
	}
	
	public String getBruker() {
		return bruker; 
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;
		
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;

	}
	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}
	
	public void doLike () {
		likes++;      //Kvifor kan eg ikkje skrive this.likes = likes++; ?
	}
	
	public boolean erLik(Innlegg innlegg) {
		return this.id == innlegg.id;
	}
	
	@Override
	public String toString() {
		
		return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
				
	}
	
	public String innleggToString() {
		
		return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
				
	}
	
	
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
