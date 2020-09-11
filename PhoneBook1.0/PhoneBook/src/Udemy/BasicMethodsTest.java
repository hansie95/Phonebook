package Udemy;

import org.junit.Test;
import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BasicMethodsTest {

    Person person = new Person("Sánta","Donát", "21345678");
    Person person2 = new Person("Kolompár","Fatima", "9872234567");

    @Test
    public void newContact() throws IOException {
        Person personTest = new Person("Kocsis","Olivér","123456789");
        newContact(personTest);
        assertTrue(search(personTest));
    }

    @Test
    public void search() throws FileNotFoundException {
        assertEquals(true, search(person));
    }

    @Test
    public void deleteContact() throws IOException {
        Person personTest = new Person ("Bor","Béla","2345678");
        newContact(personTest);
        deleteContact(personTest);
        assertFalse(search(personTest));
    }

    @Test
    public void listOfContact() {



    }

    @Test
    public void chooseCommandInBasic(){
        String valasz = chooseCommandInBasic(1);
        String valasz2 = "newContact(Prints.threeArgumentsPerson()";
        assertTrue(valasz.equals(valasz2));

    }

    public static boolean search(Person person) throws FileNotFoundException {
        Scanner allLinesOfFile = new Scanner(new File("Contacts.txt"));
        String[] inFile;
        boolean areSame = false;

        while (allLinesOfFile.hasNextLine()) {
            inFile = allLinesOfFile.nextLine().split(",");
                if (!Prints.unaccent(inFile[0].toLowerCase()).equals(person.getVezeteknev()) || !Prints.unaccent(inFile[1].toLowerCase()).equals(person.getKeresztnev())) {
                    areSame = true;
                } else {
                    areSame = false;
                }
            }
        return areSame;
        }


        public static void deleteContact(Person person) throws IOException {
        String filePath = "Contacts.txt";
        String tempFile = "TempContacts.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String currentLine;
        String[] data;

        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while ((currentLine = br.readLine()) != null) {
            data = currentLine.split(",");
            if (!data[0].equalsIgnoreCase(person.getVezeteknev()) || !data[1].equalsIgnoreCase(person.getKeresztnev())) {
                pw.println((currentLine));
            }
        }

        pw.close();
        pw.flush();
        fr.close();
        br.close();
        bw.close();
        fw.close();

        oldFile.delete();
        File dump = new File(filePath);
        newFile.renameTo(dump);
    }

    public static void newContact(Person person) throws IOException {
        Scanner allLinesOfFile = new Scanner(new File("Contacts.txt"));
        String[] inFile;
        boolean areSame = false;

        while (allLinesOfFile.hasNextLine()) {
            inFile = allLinesOfFile.nextLine().split(",");
            if (person.getVezeteknev().equals(inFile[0]) && person.getKeresztnev().equals(inFile[1])) {
                areSame = true;
            }
        }
        if (!areSame) {
            person.saveContact();
        }
    }

    public  String chooseCommandInBasic(int szam) {
        if (szam == 1) {
            return "newContact(Prints.threeArgumentsPerson()";
        } else if (szam == 2) {
            return "search(Prints.twoArgumentsPerson()";
        } else if (szam == 3) {
            return "deleteContact(Prints.twoArgumentsForDelete()";
        } else if (szam == 4) {
            return "listOfContact()";
        } else if (szam == 5) {
            return "System.exit(0)";
        } else {
            return "Helytelen parancs";
        }
    }
}