package Advent_Coding.DAY2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String nazwa = "kamienPapierNozyczki.txt";
        File plik = new File(nazwa);
        FileReader odczyt = new FileReader(plik);

        String kamien = "A";
        String papier = "B";
        String nozyczki = "C";
        String papierGracza = "Y";
        String kamienGracza = "X";
        String nozyczkiGracza = "Z";

        int punktyZaKamien = 1;
        int punktyZaPapier = 2;
        int punktyZaNozyczki = 3;
        int sumaWygranej = 0;
        int wygrana = 6;
        int remis = 3;
        int przegrana = 0;
        int sumaWyrganej2 = 0;
        String pierwszyZnak = "";
        String drugiZnak = "";

        boolean pierwszaRunda = true;
        boolean drugaRunda = false;
        boolean elfprzyszedl = false;
        while (odczyt.ready()) {
            int liczba = odczyt.read();
            char znak = (char) liczba;
            if (pierwszaRunda && !elfprzyszedl) {
                if (znak == 65) {
                    pierwszyZnak = kamien;
                }
                if (znak == 66) {
                    pierwszyZnak = papier;
                }
                if (znak == 67) {
                    pierwszyZnak = nozyczki;
                }
            }
            if (znak == 32 && !elfprzyszedl) {
                pierwszaRunda = false;
                drugaRunda = true;
            }
            if (drugaRunda && !elfprzyszedl) {
                if (znak == 88) {
                    drugiZnak = kamienGracza;
                    sumaWygranej = sumaWygranej + punktyZaKamien;
                }
                if (znak == 89) {
                    drugiZnak = papierGracza;
                    sumaWygranej = sumaWygranej + punktyZaPapier;
                }
                if (znak == 90) {
                    drugiZnak = nozyczkiGracza;
                    sumaWygranej = sumaWygranej + punktyZaNozyczki;
                }
            }
            if (znak == 13 && !elfprzyszedl) {
                if (pierwszyZnak.equals(papier) && drugiZnak.equals(papierGracza) || pierwszyZnak.equals(kamien) && drugiZnak.equals(kamienGracza) || pierwszyZnak.equals(nozyczki) && drugiZnak.equals(nozyczkiGracza)) {
                    sumaWygranej += remis;
                }
                if (pierwszyZnak.equals(papier) && drugiZnak.equals(nozyczkiGracza) || pierwszyZnak.equals(kamien) && drugiZnak.equals(papierGracza) || pierwszyZnak.equals(nozyczki) && drugiZnak.equals(kamienGracza)) {
                    sumaWygranej += wygrana;
                }
                if (pierwszyZnak.equals(papier) && drugiZnak.equals(kamienGracza) || pierwszyZnak.equals(kamien) && drugiZnak.equals(nozyczkiGracza) || pierwszyZnak.equals(nozyczki) && drugiZnak.equals(papierGracza)) {
                    continue;
                }
            }
            if (znak == 10 && !elfprzyszedl) {
                pierwszaRunda = true;
                drugaRunda = false;
            }
            if (znak != 32 && znak != 10 && znak != 13 && znak > 90 && znak < 65) {
                System.out.print("znak");
            }
            if (sumaWygranej == 11150) {
                elfprzyszedl = true;
//                Y1 to remis
//                X2 to przegrana
//                Y3 to wygrana
            }
            if (!elfprzyszedl) {
                if (znak > 64 && znak < 68) {
                    pierwszyZnak = String.valueOf(znak);
                }
                if (znak == 89) {
                    sumaWyrganej2 = sumaWyrganej2 + remis;
                    if (pierwszyZnak.equals(kamien)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaKamien;
                    } else if (pierwszyZnak.equals(papier)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaPapier;
                    } else if (pierwszyZnak.equals(nozyczki)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaNozyczki;
                    }
                }
                if (znak == 88) {
                    sumaWyrganej2 = sumaWyrganej2 + przegrana;
                    if (pierwszyZnak.equals(kamien)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaNozyczki;
                    } else if (pierwszyZnak.equals(papier)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaKamien;
                    } else if (pierwszyZnak.equals(nozyczki)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaPapier;
                    }
                }
                if (znak == 90) {
                    sumaWyrganej2 = sumaWyrganej2 + wygrana;
                    if (pierwszyZnak.equals(kamien)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaPapier;
                    } else if (pierwszyZnak.equals(papier)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaNozyczki;
                    } else if (pierwszyZnak.equals(nozyczki)) {
                        sumaWyrganej2 = sumaWyrganej2 + punktyZaKamien;
                    }
                }
            }

        }
        odczyt.close();
        System.out.println(sumaWygranej);
        System.out.println(sumaWyrganej2);
    }
}

