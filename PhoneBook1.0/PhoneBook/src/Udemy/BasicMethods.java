package Udemy;

import java.io.*;
import java.util.Scanner;

public class BasicMethods extends Prints{

    public BasicMethods(String vezeteknev, String keresztnev, String telefonszam) {
        super(vezeteknev, keresztnev, telefonszam);
    }

    /** Új névjegy létrehozása */
    public static void newContact(Person person) throws IOException {
        Scanner allLinesOfFile = new Scanner(new File("Contacts.txt"));
        String[] inFile;
        boolean areSame = false;

        while (allLinesOfFile.hasNextLine()) {
            inFile = allLinesOfFile.nextLine().split(",");
            if (person.getVezeteknev().equals(inFile[0]) && person.getKeresztnev().equals(inFile[1])) {
                System.out.println("A névjegy már létezik");
                areSame = true;
            }
        }
        if (!areSame) {
            person.saveContact();
            System.out.println("\nÚj névjegy létrhozva\n");
        }
    }

    /** Keresés a Contacts.txt fájlban */
    public static void search(Person person) throws FileNotFoundException {
        Scanner allLinesOfFile = new Scanner(new File("Contacts.txt"));
        String[] inFile;
        boolean areSame = false;

        while (allLinesOfFile.hasNextLine()) {
            inFile = allLinesOfFile.nextLine().split(",");
            if (unaccent(inFile[0].toLowerCase()).equals(person.getVezeteknev()) || unaccent(inFile[1].toLowerCase()).equals(person.getKeresztnev())) {
                System.out.println("\nNév: " + inFile[0] + " " + inFile[1] +
                        "\nTelefonszám: " + inFile[2] +
                        "\nMonogram: " + inFile[3] + "\n");
                areSame = true;
            }
        }
        if (!areSame) {
            System.out.println("A keresett személy nem található");
        }

    }

    /** Törlés a Contacts.txt fájlból, új fájl generálással és átnevezéssel */
    public static void deleteContact(Person person) throws IOException {
        String filePath = "Contacts.txt";
        String tempFile = "tempContacts.txt";
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

    /** Összes névjegy kiírása a képernyőre a Contacts.txt fájlból */
    public static void listOfContact() throws FileNotFoundException {
        System.out.println("Összes névjegy: \n");
        Scanner allLinesOfFile = new Scanner(new File("Contacts.txt"));
        String[] inFile;

        while (allLinesOfFile.hasNextLine()) {
            inFile = allLinesOfFile.nextLine().split(",");
            System.out.println("Név: " + inFile[0] + " " + inFile[1] +
                    "\nTelefonszám: " + inFile[2] +
                    "\nMonogram: " + inFile[3] + "\n");
        }
    }

    /** Menühöz tartozó metódus hívó */
    public static void chooseCommandInBasic(int szam) throws Exception {
        if (szam == 1) {
            newContact(threeArgumentsPerson());
        } else if (szam == 2) {
            search(twoArgumentsPerson());
        } else if (szam == 3) {
            deleteContact(twoArgumentsForDelete());
        } else if (szam == 4) {
            listOfContact();
        } else if (szam == 5) {
            System.exit(0);
        } else {
            System.out.println("Helytelen parancs");
        }
    }

}
