import java.util.ArrayList;
import java.util.List;

public class Abonat {
    private String nume;
    List<Carte> cartiImprumutate;
    private final int NUMAR_MAX_CARTI = 5;

    public Abonat(String nume) {
        this.nume = nume;
        cartiImprumutate  = new ArrayList<>();
    }

    public String getNume() {
        return this.nume;
    }

    public int numarCartiPermis(){
        String[] litere = this.nume.split("");
        if (litere[0].equals("M")){
            return NUMAR_MAX_CARTI + 1;
        }
        return NUMAR_MAX_CARTI;
    }
}
