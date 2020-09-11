package Udemy;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PrintsTest {

    Person person = new Person("Karalábé","Ármin","1234567");
    Person person2 = new Person("Szabó", "László");
    String vezeteknev = "Karalábé";
    String keresztnev = "Ármin";
    String telefonszam = "12345678";

    @Test
    public void unaccent() {
        String elso = Prints.unaccent("László");
        String masodik = Prints.unaccent("Laszlo");
        assertTrue("Egyeznek-e?", elso.equals(masodik) );
    }

    @Test
    public void twoArgumentsPerson() {
        Person personTest = twoArgumentsPerson(vezeteknev,keresztnev);
        assertEquals("armin", personTest.getKeresztnev());
        assertEquals("karalabe",personTest.getVezeteknev());
    }

    @Test
    public void threeArgumentsPerson() {
        Person personTest = threeArgumentsPerson(vezeteknev,keresztnev,telefonszam);
        assertEquals(telefonszam,personTest.getTelefonszam());
    }

    @Test
    public void twoArgumentsForDelete() throws IOException {
        BasicMethods.newContact(person);

    }

    public static Person twoArgumentsPerson(String vezeteknev, String keresztnev){
        String vezeteknevAtalakitott = Prints.unaccent(vezeteknev.toLowerCase());
        String keresztnevAtalakitott = Prints.unaccent(keresztnev.toLowerCase());
        return new Person(vezeteknevAtalakitott,keresztnevAtalakitott);
    }

    public static Person threeArgumentsPerson(String vezeteknev, String keresztnev, String telefonszam){
        return new Person(vezeteknev, keresztnev, telefonszam);
    }

}