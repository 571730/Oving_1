package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

import java.io.*;
import java.util.Scanner;

public class Fil {

    public static void lesFraFil(CDarkivADT cdarkiv, String filnavn){
        final String SKILLE = "#";
        try{
            FileReader fil = new FileReader(filnavn);
            Scanner sc = new Scanner(fil);
            int antall = Integer.parseInt(sc.nextLine());

            while (sc.hasNextLine()){
                String linje  = sc.nextLine();
                String[] splittet = linje.split(SKILLE);
                int nr = Integer.parseInt(splittet[0]);
                String artist = splittet[1];
                String tittel = splittet[2];
                int aar = Integer.parseInt(splittet[3]);
                Sjanger sjanger = Sjanger.valueOf(splittet[4]);
                String plateselskap = splittet[5];
                cdarkiv.leggTil(new CD(nr, artist, tittel, aar, sjanger, plateselskap));
            }

        }catch (FileNotFoundException e){
            System.out.println("Finner ikkje filen! Kva er det, du har gjort?!");
        }
    }

    public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn){
        final String SKILLE = "#";
        CD[] samling = cdarkiv.hentCdTabell();

        try{
            FileWriter fil = new FileWriter(filnavn);
            PrintWriter pw = new PrintWriter(fil);
            pw.println(cdarkiv.antallCD());
            for (int i = 0; i < cdarkiv.antallCD(); i++){
                pw.print(samling[i].getId() + SKILLE + samling[i].getNavn() + SKILLE +
                samling[i].getTittel() + SKILLE + samling[i].getLansert() + SKILLE +
                samling[i].getSjanger() + SKILLE + samling[i].getPlateselskap());
                if (i < cdarkiv.antallCD() - 1){
                    pw.println();
                }
            }
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println("Noe gikk galt under filskrivning");
        }catch (IOException e){
            System.out.println("IO ex.");
        }
    }
}
