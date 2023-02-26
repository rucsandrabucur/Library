import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    List<Carte> listaCarti = new ArrayList<>();
    List<Abonat> listaAbonati = new ArrayList<>();

    private Biblioteca(){
    }

    private static final class SingletonHolder{
        private static final Biblioteca SINGLETON = new Biblioteca();
    }

    public static Biblioteca getInstance(){
        return SingletonHolder.SINGLETON;
    }

    public void adaugaAbonat(Abonat abonat){
        for(Abonat a: listaAbonati){
            if(a.getNume().equals(abonat.getNume())){
                System.out.println("Abonatul este deja adaugat!");
                return;
            }
        }
        listaAbonati.add(abonat);
    }

    public void adaugaCarte(Carte carte){
        listaCarti.add(carte);
    }

    public boolean stergeCarte(String nume){
        Carte carte;
        for (Iterator<Carte> iterator = listaCarti.iterator(); iterator.hasNext();){
            carte = iterator.next();
            if(carte.getNume().equals(nume)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean imprumutaCarte(String numeAbonat, String numeCarte, int luna) throws AbonatInexistentException {

        if (!verificaExistentaAbonat(numeAbonat)) {
            throw new AbonatInexistentException("Abonatul nu exista!");
        }
        Carte carte;
        for (Abonat abonat : listaAbonati) {
            if (abonat.getNume().equals(numeAbonat)) {
                for (Iterator<Carte> iterator = listaCarti.iterator(); iterator.hasNext();) {
                    carte = iterator.next();
                    if(carte.getNume().equals(numeCarte)){
                        carte.setLunaReturnare(carte instanceof CartePoezii ? 12: luna);
                        abonat.cartiImprumutate.add(carte);
                        iterator.remove();
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean verificaExistentaAbonat(String nume){
        for(Abonat a: listaAbonati){
            if(a.getNume().equals(nume)){
                return true;
            }
        }
        return false;
    }

    public boolean returneazaCarte(String numeAbonat, String numeCarte) throws AbonatInexistentException{
        if(! verificaExistentaAbonat(numeAbonat)){
            throw new AbonatInexistentException("Abonatul nu exista!");
        }

        for(Abonat a: listaAbonati){
            if (a.getNume().equals(numeAbonat)){
                for (Iterator<Carte> iterator = a.cartiImprumutate.iterator(); iterator.hasNext(); ) {
                    Carte carte = iterator.next();
                    if (carte.getNume().equals(numeCarte)){
                        listaCarti.add(carte);
                        iterator.remove();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void returnToateCartile(String numeAbonat) throws AbonatInexistentException{
        if(! verificaExistentaAbonat(numeAbonat)){
            throw new AbonatInexistentException("Abonatul nu exista!");
        }
        for(Abonat a: listaAbonati){
            if(a.getNume().equals(numeAbonat)){
                //adaug cartile returnate de abonat in biblioteca
                listaCarti.addAll(a.cartiImprumutate);
                a.cartiImprumutate.clear();
            }
        }
    }

    public void afisareCartiAbonat(String numeAbonat) throws AbonatInexistentException{
        if(! verificaExistentaAbonat(numeAbonat)){
            throw new AbonatInexistentException("Abonatul nu exista!");
        }
        System.out.println("Cartile abonatului " + numeAbonat + " sunt:");
        for(Abonat a : listaAbonati){
            if(a.getNume().equals(numeAbonat)){
                a.cartiImprumutate.stream().forEach(System.out::println);
            }
        }
    }

    public void afisareCartiDisponibile(){
        if (listaCarti.isEmpty()){
            System.out.println("Nu exista carti in biblioteca!");
            return;
        }
        listaCarti.sort(Comparator.comparing(Carte::getNume));
        listaCarti.stream().forEach(x->x.afisareCarte());
    }


    public void afisareCompleta(){
        if (listaAbonati.isEmpty()){
            System.out.println("Nu exista abonati!");
            return;
        }
        //sortare abonati alfabetic
        listaAbonati.sort(Comparator.comparing(Abonat::getNume));
        for(Abonat a: listaAbonati){
            System.out.println("Carti abonatul " + a.getNume() + " :");

            // sortare carti abonati alfabetic
            a.cartiImprumutate.sort(Comparator.comparing(Carte::getNume));
            a.cartiImprumutate.stream().forEach(System.out::println);
        }
    }
}
