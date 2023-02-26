public class CarteRoman {
    rivate String tipRoman;

    public CarteRoman(String nume, String autor, String tipRoman){
        super(nume, autor);
        this.tipRoman = tipRoman;
    }

    @Override
    public String toString() {
        return this.getNume() + " : " + this.getAutor() + " : " + ". Tip roman : " + this.tipRoman +
                ". Returnare in luna a "+  this.getLunaReturnare() + " a.";
    }

    @Override
    public void afisareCarte() {
        System.out.println(this.getNume() + " : " + this.getAutor() + " : " + "Tip roman : " + this.tipRoman + ". ");
    }
}
