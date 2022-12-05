package Advent_Coding.DAY1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String nazwaPliku = "plik.txt";
        String text;
        File plik = new File(nazwaPliku);
        Scanner scanner = new Scanner(plik);
        int suma = 0;
        int[] tab = new int[250];
        int i = 0;
        while (scanner.hasNext()) {
            text = scanner.nextLine();
            if (text.isEmpty()) {
                text = "0";
            }
            int liczba = Integer.parseInt(text);
            suma = liczba + suma;
            if (liczba == 0) {
                tab[i] = suma;
                i++;
                suma = 0;
            }
        }
        int max = 0;
        int max2 = 0;
        int max3 = 0;

        for (int j = 0; j < tab.length; j++) {
            if (j == 0) {
                max = tab[j];
            }
            if (tab[j] > max) {
                max = tab[j];
            }

        }
        System.out.println(max);

        for (int k = 0; k < tab.length; k++) {
            if (k == 0)
                max2 = tab[k];

            if (max > tab[k] && tab[k] > max2) {
                max2 = tab[k];
            }

        }
        System.out.println(max2);
        for (int l = 0; l < tab.length; l++) {
            if (l == 0)
                max3 = tab[l];

            if (max > tab[l] && max2 > tab[l] && tab[l] > max3) {
                max3 = tab[l];
            }
        }
        System.out.println(max3);
        int sumaWszystkiego = max+max2+max3;
        System.out.println("suma wszystkiego wynosi : "+sumaWszystkiego);
    }
}

