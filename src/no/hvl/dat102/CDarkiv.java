package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {
    private CD[] samling;
    private int antall;

    public CDarkiv(int plasser){
        samling = new CD[plasser];
        antall = 0;
    }

    @Override
    public CD[] hentCdTabell() {
        return samling;
    }

    private int finnCD(int id){
       for (int i = 0; i < antall; i++){
           if(samling[i].getId() == id){
               return i;
           }
       }
       return -1;
    }


    private void utvidKapasitet(){
        CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 * samling.length)];
        for (int i = 0; i < samling.length; i++){
            hjelpetabell[i] = samling[i];
        }
        samling = hjelpetabell;
    }

    @Override
    public void leggTil(CD cd) {
        int plass = finnCD(cd.getId());
        if (plass >= 0){
            System.out.println("CD-en fantes fra før av, så den ble ikke lagt til");
        }
        else {
            if (antall == samling.length){
                System.out.println("Utvider kapasiteten..");
                utvidKapasitet();
            }
            System.out.println("Legger til platen: " + cd.getTittel());
            samling[antall] = cd;
            antall++;
        }
    }

    @Override
    public void slettCD(int id) {
        int plass = finnCD(id);
        if (plass < 0){
            System.out.println("Fant ikke CD-en, så slettet ikke noe");
        }
        else {
            samling[plass] = samling[antall - 1];
            samling[antall - 1] = null;
            antall--;
        }

    }

    private int finnAntall(int valg, String delstreng){
        int teller = 0;
        if (valg == 1){
            for (int i = 0; i < antall; i++){
                if (samling[i].getTittel().contains(delstreng)){
                    teller++;
                }
            }
            return teller;
        }else {
            for (int i = 0; i < antall; i++){
                if (samling[i].getNavn().contains(delstreng)){
                    teller++;
                }
            }
            return teller;
        }
    }

    @Override
    public CD[] finnCD(String delstreng) {
        int mengde = finnAntall(1, delstreng);

        CD[] tittelCD = new CD[mengde];
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (samling[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())){
                tittelCD[teller] = samling[i];
                teller++;
            }
        }
        return tittelCD;
    }

    @Override
    public CD[] finnArtist(String delstreng) {
        int mengde = finnAntall(2, delstreng);

        CD[] artistCD = new CD[mengde];
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (samling[i].getNavn().toLowerCase().contains(delstreng.toLowerCase())){
                artistCD[teller] = samling[i];
                teller++;
            }
        }
        return artistCD;
    }

    @Override
    public int antallCD() {
        return antall;
    }

    @Override
    public int hentAntall(Sjanger sjanger) {
        int teller = 0;
        for (CD c : samling){
            if (c == null){
            }
            else if (c.getSjanger() == sjanger){
                teller++;
            }
        }
        return teller;
    }

}
