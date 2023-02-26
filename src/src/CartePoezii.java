public class CartePoezii {
    private int numarPoezii;

    public CartePoezii(String nume, String autor, int numarPoezii) {
        super(nume, autor);
        this.numarPoezii = numarPoezii;
    }

    @Override
    public String toString() {
        return this.getNume() + " : " + this.getAutor() + " : " + this.numarPoezii + " poezii. " + "Returnare in luna a " +
                this.getLunaReturnare() + " a.";
    }

    @Override
    public void afisareCarte() {
        System.out.println(this.getNume() + " : " + this.getAutor() + " : " + this.numarPoezii + " poezii. ");
    }
}
