package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static javax.swing.JOptionPane.*;
import java.io.*;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
	
		BufferedWriter skrivar = null;
		try {
			String filbane = mappe + "/" + filnavn;
			skrivar = new BufferedWriter(new FileWriter(filbane));
			
			skrivar.write(String.valueOf(samling.getAntall()));
			skrivar.newLine();
			
//			for (int i = 0; i < samling.getAntall(); i++) {
				skrivar.write(samling.getSamling().toString());
				skrivar.newLine();
//			}
		return true;
		
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (skrivar != null) {
				try {
					skrivar.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
/*
For å implementere metoden `skriv` i klassen `SkrivBlogg.java`, må vi først sørge 
for at vi har tilgang til klassen `Blogg` og dens metodar. Metoden `skriv` skal ta inn 
ein instans av `Blogg`, ei mappe og eit filnamn, og skrive ut innhaldet i bloggen til den spesifiserte 
filen. Vi vil bruke ei `try-catch` blokk for å handtere eventuelle unntak i samband med filhandtering.

Her er eit eksempel på korleis metoden kan implementerast:

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnamn) {
        BufferedWriter writer = null;
        try {
            // Opprette filbane
            String filbane = mappe + "/" + filnamn;

            // Opprette BufferedWriter for å skrive til fila
            writer = new BufferedWriter(new FileWriter(filbane));

            // Skriv antall innlegg i samlinga
            writer.write(String.valueOf(samling.getAntallInnlegg()));
            writer.newLine();

            // Gå gjennom innlegga og skriv dei til fila
            for (int i = 0; i < samling.getAntallInnlegg(); i++) {
                writer.write(samling.getInnlegg(i).toString());
                writer.newLine();
            }

            // Fila blei skriven utan feil
            return true;

        } catch (IOException e) {
            // Handtere IOException
            e.printStackTrace();
            return false;

        } finally {
            // Sørge for at writer vert lukka
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

Forklaring:

1. **Importering av nødvendige bibliotek**: Vi importerer `BufferedWriter`, `FileWriter`, og 
`IOException` for å handtere skriving til filer.

2. **Metodesign**: Den statiske metoden `skriv` tek imot ein `Blogg`-instans, ein mappe, og eit filnamn.

3. **Filbane**: Vi lagar ein fullstendig filbane ved å kombinere mappa og filnamnet.

4. **Skriving til fil**: Vi opprettar ein `BufferedWriter` for å skrive til fila, skriv først talet 
på innlegg, og deretter bruker vi ei løkke for å skrive kvart innlegg, ved å kalle `toString()`-metoden 
på kvart innlegg for riktig format.

5. **Feilhåndtering**: Eventuelle unntak som vert fanga i `catch`-blokka vil skrive ut feilmeldinga, 
og metoden vil returnere `false`.

6. **Ressursfrigjering**: Uavhengig av kva som skjer, sørger vi for å lukke `BufferedWriter` i 
`finally`-blokka.

### Merk:
For at denne implementasjonen skal fungere, føreset det at `Blogg`-klassen har metodar som 
`getAntallInnlegg()` og `getInnlegg(int index)`, som muliggjør at vi kan hente antall innlegg 
og kvart innlegg i samlinga. Sørg for å implementere `toString()`-metoden i klassen `Innlegg`, 
slik at du kan 
skrive ut innhaldet som spesifisert i eksempelet. 
*/
