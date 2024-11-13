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
