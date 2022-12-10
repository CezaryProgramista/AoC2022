package Advent_Coding.DAY9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String name = "inputFileDay9.txt";
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        int right;
        int left;
        int down;
        int up;
        int movesDone = 1;
        int[][] tab = new int[620][620];
        int head = 9;
        int tail = 5;
        int actualPositionY = tab.length / 2;
        int actualPositionI = tab.length / 2;
        int positionTailY = actualPositionY;
        int positionTailI = actualPositionI;
        boolean firstRound = true;
        String text;
        int licznik = 0;
        while (scanner.hasNext()) {
            text = scanner.nextLine();
            if (firstRound) {
                tab[actualPositionI][actualPositionY] = head;
                tab[positionTailI][positionTailY] = tail;
                firstRound = false;
            }
            if (text.contains("R")) {
                right = Integer.parseInt(text.substring(2));
                for (int j = 0; j < right; j++) {
                    actualPositionY += movesDone;
                    if (tab == null) {
                        tab[actualPositionI][actualPositionY] = head;
                    }
                    if (positionTailY - actualPositionY > 1 || actualPositionY - positionTailY > 1) {
                        positionTailY = actualPositionY - 1;
                        positionTailI = actualPositionI;
                        tab[positionTailI][positionTailY] = tail;
                    }
                }
            } else if (text.contains("L")) {
                left = Integer.parseInt(text.substring(2));
                for (int j = 0; j < left; j++) {
                    actualPositionY -= movesDone;
                    if (tab == null) {
                        tab[actualPositionI][actualPositionY] = head;
                    }
                    if (positionTailY - actualPositionY > 1 || actualPositionY - positionTailY > 1) {
                        positionTailY = actualPositionY + 1;
                        positionTailI = actualPositionI;
                        tab[positionTailI][positionTailY] = tail;
                    }
                }
            } else if (text.contains("U")) {
                up = Integer.parseInt(text.substring(2));
                for (int i = up; i > 0; i--) {
                    actualPositionI -= movesDone;
                    if (tab == null) {
                        tab[actualPositionI][actualPositionY] = head;
                    }
                    if (actualPositionI - positionTailI > 1 || positionTailI - actualPositionI > 1) {
                        positionTailI = actualPositionI + 1;
                        positionTailY = actualPositionY;
                        tab[positionTailI][positionTailY] = tail;
                    }
                }
            } else if (text.contains("D")) {
                down = Integer.parseInt(text.substring(2));
                for (int i = 0; i < down; i++) {

                    actualPositionI += movesDone;
                    if (tab == null) {
                        tab[actualPositionI][actualPositionY] = head;
                    }
                    if (actualPositionI - positionTailI > 1 || positionTailI - actualPositionI > 1) {
                        positionTailI = actualPositionI - 1;
                        positionTailY = actualPositionY;
                        tab[positionTailI][positionTailY] = tail;
                    }
                }
            }
        }
        for (int[] ints : tab) {
            System.out.println();
            for (int j = 0; j < tab.length; j++) {
                if (ints[j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(ints[j]);
                    licznik++;
                }
            }
        }
        System.out.println(licznik);
    }
}
