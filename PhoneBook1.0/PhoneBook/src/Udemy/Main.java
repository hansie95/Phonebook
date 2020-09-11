package Udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner be = new Scanner(System.in);

        do {
            Prints.menuScreen();
            try {
                int szam = be.nextInt();
                BasicMethods.chooseCommandInBasic(szam);
                System.out.println("Szeretne új parancsot indítani? I/N");
                if (!be.next().toLowerCase().equals("i")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Hibás parancs");
                break;
            }
        } while (true);

    }
}


