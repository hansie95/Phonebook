package Udemy;

import java.util.Scanner;
import java.text.Normalizer;

public class Prints extends Person {



    public Prints(String vezeteknev, String keresztnev, String telefonszam) {
        super(vezeteknev, keresztnev, telefonszam);
    }

    /** Menü kiírása */
    public static void menuScreen() {
        System.out.println("Kérem írja be a kívánt parancs számát!\n");
        System.out.println("(1) Új névjegy létrehozása");
        System.out.println("(2) Névjegy keresése");
        System.out.println("(3) Névjegy törlése");
        System.out.println("(4) Névjegyek listázása");
        System.out.println("(5) Kilépés");
    }

    /** Ékezetes Stringek ékezet mentessé alakítása, külső forrássból */
    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static Person twoArgumentsPerson(){
        Scanner be = new Scanner(System.in);
        System.out.println("Kérem adja meg a keresett személy vezetéknevét");
        String vezeteknev = unaccent(be.nextLine().toLowerCase());
        System.out.println("Kérem adja meg a keresett személy keresztnevét");
        String keresztnev = unaccent(be.nextLine().toLowerCase());
        return new Person(vezeteknev,keresztnev);
    }

    public static Person threeArgumentsPerson(){
        Scanner be = new Scanner(System.in);
        System.out.println("Kérem adja meg a vezetéknevet:");
        String vezeteknev = be.nextLine();
        System.out.println("Kérem adja meg a keresztnevet:");
        String keresztnev = be.nextLine();
        System.out.println("Kérem adja meg a telefonszámot:");
        String telefonszam = be.nextLine();
        return new Person(vezeteknev, keresztnev, telefonszam);
    }

    public static Person twoArgumentsForDelete(){
        Scanner be = new Scanner(System.in);
        System.out.println("Kérem adja meg a vezetéknevet:");
        String vezeteknev = be.nextLine();
        System.out.println("Kérem adja meg a keresztnevet:");
        String keresztnev = be.nextLine();
        return new Person(vezeteknev,keresztnev);
    }
}