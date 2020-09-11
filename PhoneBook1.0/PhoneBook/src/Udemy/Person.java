package Udemy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Person {
    private String vezeteknev;
    private String keresztnev;
    private String telefonszam;
    private String monogram;

    /** Konstruktor, ami saját maga generálja a névjegy monogramját */
    public Person(String vezeteknev, String keresztnev, String telefonszam) {
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.telefonszam = telefonszam;
        this.monogram = vezeteknev.toUpperCase().substring(0,1) + keresztnev.toUpperCase().substring(0,1);
    }

    public Person(String vezeteknev, String keresztnev) {
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
    }


    public String getMonogram() {
        return monogram;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public String getTelefonszam() {
        return telefonszam;
    }
    /** Névjegy mentése a Contacts.txt fájlba  */
    public void saveContact() throws IOException {
        PrintWriter save = new PrintWriter((new FileWriter("Contacts.txt", true)));
        save.println(this.vezeteknev +  "," + this.keresztnev + "," + this.telefonszam + "," + this.monogram);
        save.close();
    }
}
