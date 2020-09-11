package Udemy;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class PersonTest {

    Person person = new Person("Sánta","Donát", "21345678");
    Person person2 = new Person("Kolompár","Fatima", "9872234567");

    @Test
    public void getMonogram() {
    }

    @Test
    public void getVezeteknev() {
    }

    @Test
    public void getKeresztnev() {
        String keresztnev = person.getKeresztnev();
        String keresztnevTest = "Donát";
        assertTrue(keresztnev.equals(keresztnevTest));
    }

    @Test
    public void getTelefonszam() {
        String telefonszam = person.getTelefonszam();
        String telefonszam2 = "21345678";
        assertTrue(telefonszam.equals(telefonszam2));
    }

    @Test
    public void saveContact() throws IOException {
        saveContact(person);
    }

    public void saveContact(Person person) throws IOException {
        PrintWriter save = new PrintWriter((new FileWriter("Contacts.txt", true)));
        save.println(person.getVezeteknev() +  "," + person.getKeresztnev() + "," + person.getTelefonszam()+ "," + person.getMonogram());
        save.close();
    }
}