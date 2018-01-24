package no.hvl.dat102;

public enum Sjanger{
    POP(1), ROCK(2), OPERA(3), KLASSISK(4);

    private int nr;

    private Sjanger(int n){
        this.nr = n;
    }
}
