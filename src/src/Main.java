import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Biblioteca biblioteca = Biblioteca.getInstance();
        System.out.println("Introduceti comanda:");
        String comanda;

        MyThread myThread = new MyThread();
        myThread.start();

        while(true){
            comanda = scanner.nextLine();
            String [] cuvinte = comanda.split("\\s+");

            switch (cuvinte[0]){
                case "EXIT":
                    myThread.interrupt();
                    if(myThread.isAlive()){
                        myThread.setShouldExit(true);
                    }
                    return;

                case "ADAUGA_ABONAT":
                    biblioteca.adaugaAbonat(new Abonat(cuvinte[1]));
                    break;

                case "ADAUGA_CARTE":
                    switch (cuvinte[1].toLowerCase()){
                        case "poezii":
                            System.out.println("Introduceti numele cartii, numele autorului si numarul de poezii:");
                            String comanda2 = scanner.nextLine();
                            String [] cuvinte2 = comanda2.split("\\s+");
                            biblioteca.adaugaCarte(new CartePoezii(cuvinte2[0], cuvinte2[1], Integer.parseInt(cuvinte2[2])));
                            break;

                        case "povestiri":
                            System.out.println("Introduceti numele cartii, numele autorului si numarul de povestiri:");
                            String comanda3 = scanner.nextLine();
                            String [] cuvinte3 = comanda3.split("\\s+");
                            biblioteca.adaugaCarte(new CartePovestiri(cuvinte3[0], cuvinte3[1], Integer.parseInt(cuvinte3[2])));
                            break;

                        case "roman":
                            System.out.println("Introduceti numele cartii, numele autorului si tipul romanului:");
                            String comanda4 = scanner.nextLine();
                            String [] cuvinte4 = comanda4.split("\\s+");
                            biblioteca.adaugaCarte(new CarteRoman(cuvinte4[0],cuvinte4[1],cuvinte4[2]));
                            break;

                        default:
                            System.out.println("Tipul cartii este gresit!");
                    }
                    break;

                case"STERGE_CARTE":
                    if(biblioteca.stergeCarte(cuvinte[1])){
                        System.out.println("Cartea a fost stearsa!");
                    } else {
                        System.out.println("Eroare la stergerea cartii!");
                    }
                    break;

                case"IMPRUMUTA_CARTE":
                    try {
                        if(biblioteca.imprumutaCarte(cuvinte[1], cuvinte[2], Integer.parseInt(cuvinte[3]))){
                            System.out.println("Cartea a fost imprumutata cu succes!");
                        } else{
                            System.out.println("Imprumut nereusit!");
                        }
                    } catch (AbonatInexistentException e){
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException | IndexOutOfBoundsException e){
                        e.printStackTrace();
                    }

                    break;

                case"RETURNEAZA_CARTE":
                    try{
                        if(biblioteca.returneazaCarte(cuvinte[1],cuvinte[2])){
                            System.out.println("Returnare efectuata cu succes!");
                        } else{
                            System.out.println("Eroare la returnare!");
                        }
                    } catch (AbonatInexistentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case"RETURNEAZA_TOATE_CARTILE":
                    try{
                        biblioteca.returnToateCartile(cuvinte[1]);
                    } catch (AbonatInexistentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case"AFISARE_CARTI":
                    try{
                        biblioteca.afisareCartiAbonat(cuvinte[1]);
                    } catch (AbonatInexistentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case"AFISARE_CARTI_DISPONIBILE":
                    biblioteca.afisareCartiDisponibile();
                    break;

                case"AFISARE_COMPLETA":
                    biblioteca.afisareCompleta();
                    break;

                default:
                    System.out.println("Comanda gresita.Try again");
            }
        }
    }
}