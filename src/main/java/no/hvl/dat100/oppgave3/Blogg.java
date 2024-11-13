package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}	
		return -1;
		
	}

	public boolean finnes(Innlegg innlegg) {
		
		boolean finnast = false;
		
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				finnast = true;
			}
		}
		return finnast;
	}

	public boolean ledigPlass() {
		
		boolean ledig = false;
		
		if (innleggtabell.length > nesteledig) {
			ledig = true;
		}
		return ledig;
	}

	
	public boolean leggTil(Innlegg innlegg) {
		
		boolean til = false;
		
		if (innleggtabell.length <= nesteledig) {
			return til;
		} 
		
		if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			til = true;
		}
		
		return til;
	}
	
	public String toString() {
		
		String to = String.valueOf(innleggtabell.length) + "\n";
		
		for (int i = 0; i < innleggtabell.length; i++) {
			to += innleggtabell[i].toString();
		}
		return to;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] ny = new Innlegg[innleggtabell.length*2];
		
		for (int i = 0; i < innleggtabell.length; i++) {
			ny[i] = innleggtabell[i];
		}
		innleggtabell = ny; //What happens here exactly?
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		if (finnes(innlegg)) {
			return false;
		}
		
		if (innleggtabell.length <= nesteledig) {
			utvid();
		}
		
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int tal = finnInnlegg(innlegg);
		
		if (tal == -1) {
			return false;
		}
		
		for (int i = tal; i < innleggtabell.length-1; i++) {
			innleggtabell[i] = innleggtabell[i+1];
		}
		
		innleggtabell[nesteledig-1] = null;
			
		nesteledig--;
		return true;

	}
	
	public int[] search(String keyword) { //Er dette rett måte å gjere det på?
		
		int lengd = 0;
		
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i] instanceof Tekst) {	
				if (((Tekst) innleggtabell[i]).getTekst().contains(keyword)) {
					lengd++;
				}
			}
		}
		
		int[] resultat = new int[lengd];
		
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].getClass() == Tekst.class) {	//getclass i staden for intanceof
				if (((Tekst) innleggtabell[i]).getTekst().contains(keyword)) { //innleggtabell er i dette tilfellet
					resultat[i] = innleggtabell[i].getId();                    // i typa blogg, noko som gjer at vi
				}															   // må endre den og sjekke om det er tekst.
			}																   // Difor må vi ta inn (Tekst).
		}
		// Metodar å kunne utanat til eksamen: tostring, equals, systemoutprint, max/min metodar
		return resultat;
	}
}