package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {
    /**
     * Henter ut hele cd arkivet
     * @return en liste over CD-er
     */
    CD[] hentCdTabell();

    /**
     * Legger til en ny cd i arkivet
     * @param cd cd-objektet som skal legges til
     */
    void leggTil(CD cd);

    /**
     * Sletter en cd fra arkivet
     * @param id id til den cd som skal slettes fra arkivet
     */

    void slettCD(int id);

    /**
     * Finner alle cd-er med en viss delstreng i tittelen
     * @param delstreng delstrengen som skal søkes med
     * @return en liste over alle cd-er med delstrengen i tittelen
     */
    CD[] finnCD(String delstreng);

    /**
     * Finner alle cd-er laget av artister som har en viss delstreng i navnet
     * @param delstreng delstrengen som skal søkes etter
     * @return en liste over alle cd-er som matcher søket
     */

    CD[] finnArtist(String delstreng);

    /**
     * Henter ut antallet cd-er på lageret
     * @return en Integer som representerer hvor mange cd-er som er på lager
     */

    int antallCD();

    /**
     * Henter ut antallet cd-er som matcher en gitt sjanger
     * @param sjanger Sjangeren som alle cd-ene som returneres skal matche
     * @return antallet cd-er som matches sjangeren
     */

    int hentAntall(Sjanger sjanger);
}
