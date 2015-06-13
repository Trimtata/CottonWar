package de.dataport.cottonwar.savegame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import de.dataport.cottonwar.gui.WorldHandler;


public class Main{
	
	
	static int exp;
	static int exp2;
	static int gold;
	static int gold2;
	static int lp;
	static int lp2;
	
	
	public static void speichern() {
		try
		{
			exp = WorldHandler.exp;
			exp2 = WorldHandler.exp2;
			gold2 = WorldHandler.gold2;
			gold = WorldHandler.gold;
			lp = WorldHandler.lp;
			lp2 = WorldHandler.lp2;
			
			File file = new File("D:\\Speicherstand\\CottonWar\\bin\\test.log");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			bw.write(exp+ "");
			bw.newLine();
			bw.write(exp2+"");
			bw.newLine();
			bw.write(gold+"");
			bw.newLine();
			bw.write(gold2+"");
			bw.newLine();
			bw.write(lp+"");
			bw.newLine();
			bw.write(lp2+"");
			bw.flush();
			bw.close();
			
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}
	
	public static void laden() {
		 // Datei-Reader initialisieren
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("D:\\Speicherstand\\CottonWar\\bin\\test.log")));
        } catch(FileNotFoundException e) {
            // Falls es ein Problem beim Erzeugen des Readers gab ...
            e.printStackTrace();
            System.err.println("Fehler beim Öffnen der Datei!");
            return;
        }
 
        // Ab hier kann mit dem Datei-Reader gearbeitet werden
        /*
         * Hier werden wir eine Datei einlesen und ihren Inhalt Zeile für Zeile
         * einlesen und jede Zeile in einer Liste speichern, um mit ihnen später
         * weiterarbeiten zu können.
         */
        LinkedList<String> rows = new LinkedList<String>();
        try {
            for(String tmp = null; (tmp = reader.readLine()) != null;) {
                rows.add(tmp);
            }
        } catch(IOException e) {
            // Falls einen Fehler beim Einlesen gab ...
            e.printStackTrace();
            close(reader);
            return;
        }
 
        // Den Datei-Reader wieder sauber schließen
        close(reader);
 
        /*
         * Nun haben wir alle Zeilen in einer Liste gespeichert und können auf
         * diese zugreifen. In diesem Beispiel sind in jeder Zeile einfach nur
         * Zahlen eingetragen, also werden wir diese auch in solche parsen und
         * mit ihnen rechnen.
         */

        try {
        WorldHandler.exp = Integer.parseInt(rows.get(0));
        WorldHandler.exp2 = Integer.parseInt(rows.get(1));
        WorldHandler.gold = Integer.parseInt(rows.get(2));
        WorldHandler.gold2 = Integer.parseInt(rows.get(3));
        WorldHandler.lp = Integer.parseInt(rows.get(4));
        WorldHandler.lp2 = Integer.parseInt(rows.get(5));
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        	System.err.println("Fehler!");
        }
	}
    private static void close(Reader r) {
        try {
            r.close();
        } catch(IOException e) {
            // Falls es einen Fehler beim Schließen gab ...
            e.printStackTrace();
            System.err.println("Fehler beim Schließen des Readers!");
        }
    }
	

}