public abstract class Carte {
    private String nume;
    private String autor;
    private int lunaReturnare;

    public Carte(String nume, String autor) {
        this.nume = nume;
        this.autor = autor;
    }

    // afisareCarte() folosita pentru afisarea cartilor fara termenul de returnare
    abstract void afisareCarte();

    public String getNume() {
        return nume;
    }

    public String getAutor() {
        return autor;
    }

    public void setLunaReturnare(int lunaReturnare) {
        this.lunaReturnare = lunaReturnare;
    }

    public int getLunaReturnare() {
        return lunaReturnare;
    }
}
