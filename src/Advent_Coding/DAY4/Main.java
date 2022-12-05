package Advent_Coding.DAY4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String nameFile = "campCleanup.txt";
        File file = new File(nameFile);
        Scanner scanner = new Scanner(file);
        String text;
        int space;
        String text1;
        String text2;
        String[] tab;
        String[] tab1;
        int counter = 0;
        int notOverlap = 0;
        int inputSize = 0;

        while (scanner.hasNext()) {
            inputSize++;
            text = scanner.nextLine();
            space = text.indexOf(",");
            text1 = text.substring(0, space);
            text2 = text.substring(space + 1);
            tab = text1.split("-");
            tab1 = text2.split("-");
            int first = 0;
            int second = 0;
            int equals = 0;
            int maxFirst = 0;
            int minFirst = 0;
            int maxSecond = 0;
            int minSecond = 0;

            for (int i = 0; i < 2; i++) {
                int firstTab = Integer.parseInt(tab[i]);
                int secondTab = Integer.parseInt(tab1[i]);
                if (i == 0) {
                    minFirst = firstTab;
                    minSecond = secondTab;
                    if (firstTab == secondTab) {
                        equals++;
                    }
                    if (firstTab < secondTab) {
                        first++;
                    } else if (firstTab > secondTab) {
                        second++;
                    }
                }
                if (i == 1) {
                    maxFirst = firstTab;
                    maxSecond = secondTab;
                    if (firstTab == secondTab) {
                        equals++;
                    }
                    if (firstTab > secondTab) {
                        first++;
                    } else if (firstTab < secondTab) {
                        second++;
                    }
                }
                if (i == 1) {
                    if (first == 2 || second == 2 || first == 1 && equals == 1 || second == 1 && equals == 1 || equals == 2) {
                        counter++;
                    }
//                    ----------part2-----------------
                    if (maxFirst < minSecond || minFirst > maxSecond) {
                        notOverlap++;
                    }
                }
            }
        }
        System.out.println(counter);
        System.out.println(inputSize - notOverlap);
    }
}


