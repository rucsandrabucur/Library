public class CartePovestiri {
    private int numarPovestiri;

    public CartePovestiri(String nume, String autor, int numarPovestiri) {
        super(nume, autor);
        this.numarPovestiri = numarPovestiri;
    }

    @Override
    public String toString() {
        return this.getNume() + " : " + this.getAutor() + " : " + this.numarPovestiri + " povestiri." +
                " Returnare in luna a " + this.getLunaReturnare() + " a.";
    }

    @Override
    public void afisareCarte() {
        System.out.println(this.getNume() + " : " + this.getAutor() + " : " + this.numarPovestiri + " povestiri.");
    }
}
