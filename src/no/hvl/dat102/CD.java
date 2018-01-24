package no.hvl.dat102;


public class CD {

    private int id;
    private String navn;
    private String tittel;
    private int lansert;
    private Sjanger sjanger;
    private String plateselskap;

    public CD(){
        id = -1;
        navn = "Ukjent";
        tittel = "Ukjent";
        lansert = -1;
        plateselskap = "Ukjent";
    }

    public CD(int id, String navn, String tittel, int lansert, Sjanger sjanger, String plateselskap){
        this.id = id;
        this.navn = navn;
        this.tittel = tittel;
        this.lansert = lansert;
        this.sjanger = sjanger;
        this.plateselskap = plateselskap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLansert() {
        return lansert;
    }

    public void setLansert(int lansert) {
        this.lansert = lansert;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getPlateselskap() {
        return plateselskap;
    }

    public void setPlateselskap(String plateselskap) {
        this.plateselskap = plateselskap;
    }
}
