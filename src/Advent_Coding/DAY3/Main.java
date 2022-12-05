package Advent_Coding.DAY3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String nameFile = "plecaki.txt";
        File file = new File(nameFile);
        Scanner scanner = new Scanner(file);
        HashMap<Character, Integer> map = new HashMap<>();
        char a = 97;
        int value = 1;
        String znak;
        for (int i = 0; i < 57; i++) {
            map.put(a, value);
//            wywo³uje klucz printuje mi wartosc
            a++;
            value++;

            if (a == 123) {
                a = 65;
            }
            if (a > 64 && a < 91) {
                map.put(a, value);
            }
        }
        String text;
        String text1;
        String text2;
        int suma = 0;
        while (scanner.hasNext()) {
            text = scanner.nextLine();
            int half = text.length() / 2;
            text1 = text.substring(0, half);
            text2 = text.substring(half);
            String[] tab1;
            for (int i = 0; i < text2.length(); i++) {
                tab1 = text2.split("");

                if (text1.contains(tab1[i])) {
                    znak = tab1[i];
                    char znak1 = znak.charAt(0);

                    for (int k = 0; k < map.size(); k++) {
                        if (map.containsKey(znak1)) {
                            suma = suma + map.get(znak1);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(suma);
    }
}

