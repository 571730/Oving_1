package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {

    private Scanner sc = new Scanner(System.in);

    public CD lesCD(){
        System.out.println("Hva er ID til CD-en: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Navn på Band: ");
        String navn = sc.nextLine();
        System.out.println("Tittel: ");
        String tittel = sc.nextLine();
        System.out.println("Lanseringsår: ");
        int aar = sc.nextInt();
        sc.nextLine();
        System.out.println("Velg en sjanger:");
        System.out.println("1) POP");
        System.out.println("2) ROCK");
        System.out.println("3) OPERA");
        System.out.println("4) KLASSISK");
        int valg = sc.nextInt();
        sc.nextLine();
        Sjanger sjanger = Sjanger.KLASSISK;
        if (valg == 1){
            sjanger = Sjanger.POP;
        }else if(valg == 2){
            sjanger = Sjanger.ROCK;
        }else if(valg == 3){
            sjanger = Sjanger.OPERA;
        }else if (valg == 4){
            sjanger = Sjanger.KLASSISK;
        }
        System.out.println("Plateselskap: ");
        String plateselskap = sc.nextLine();
        return new CD(id, navn, tittel, aar, sjanger, plateselskap);
    }

    private void visCD(CD cd){
        System.out.println("ID: " + cd.getId());
        System.out.println("Band " + cd.getNavn());
        System.out.println("Tittel: " + cd.getTittel());
        System.out.println("Lansert " + cd.getLansert());
        System.out.println("Sjanger: " + cd.getSjanger().toString());
        System.out.println("Plateselskap: " + cd.getPlateselskap());
        System.out.println();
    }

    public void skrivUtCdDelstrengTittel(CDarkivADT cda, String delstreng){
        CD[] cd = cda.finnCD(delstreng);
        for (CD c:cd) {
            visCD(c);
        }
    }

    public void skrivUtCdArtist(CDarkivADT cda, String delstreng){
        CD[] cd = cda.finnArtist(delstreng);
        for(CD c : cd){
            visCD(c);
        }
    }

    public void skrivUtStatistikk(CDarkivADT cda){
        int antallCD = cda.antallCD();
        System.out.println("Det er " + antallCD + " plate/plater på lageret");
        for (Sjanger s : Sjanger.values()){
            int tall = cda.hentAntall(s);
            System.out.println("Det er " + tall + " plater under sjangeren " + s.toString());
        }
    }
}
