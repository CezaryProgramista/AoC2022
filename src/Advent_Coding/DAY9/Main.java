package Advent_Coding.DAY9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String name = "inputFileDay9.txt";
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        HashMap<Integer, String> map = new HashMap<>();

        int right;
        int left;
        int down;
        int up;
        int movesDone = 1;
        //                      i   y
//        rozmiar tab 620
        int[][] tab = new int[620][620];
        int head = 9;
        int tail = 5;
        int moves = 0;
        String valueMap;
        int mapKey = 0;
        int actualPositionY = tab.length / 2;
        int actualPositionI = tab.length / 2;
        int positionTailY = tab.length / 2;
        int positionTailI = tab.length / 2;
        boolean firstRound = true;
        String text;
        while (scanner.hasNext()) {
            if (firstRound) {
                tab[actualPositionI][actualPositionY] = head;
                tab[positionTailI][positionTailY] = tail;
                valueMap = ("I :" + positionTailI + " Y :" + positionTailY);
                map.put(mapKey, valueMap);
                mapKey++;
                moves++;
                firstRound = false;
            }

            text = scanner.nextLine();
            if (text.contains("R")) {
                right = Integer.parseInt(text.substring(2));
                for (int j = 0; j < right; j++) {

                    actualPositionY += movesDone;
                    tab[actualPositionI][actualPositionY] = head;

                    if (positionTailY - actualPositionY == 2 || actualPositionY - positionTailY == 2) {
                        positionTailY = actualPositionY - 1;
                        positionTailI = actualPositionI;
                        tab[positionTailI][positionTailY] = tail;
                        valueMap = ("I :" + positionTailI + " Y :" + positionTailY);
                        if (!map.containsValue(valueMap)) {
                            map.put(mapKey, valueMap);
                            moves++;
                            mapKey++;

                        }
                    }
                }
            }
            if (text.contains("L")) {
                left = Integer.parseInt(text.substring(2));
                for (int j = 0; j < left; j++) {

                    actualPositionY -= movesDone;
                    tab[actualPositionI][actualPositionY] = head;

                    if (positionTailY - actualPositionY == 2 || actualPositionY - positionTailY == 2) {
                        positionTailY = actualPositionY + 1;
                        positionTailI = actualPositionI;
                        tab[positionTailI][positionTailY] = tail;
                        valueMap = ("I :" + positionTailI + " Y :" + positionTailY);
                        if (!map.containsValue(valueMap)) {
                            map.put(mapKey, valueMap);
                            moves++;
                            mapKey++;
                        }
                    }
                }
            }
            if (text.contains("U")) {
                up = Integer.parseInt(text.substring(2));
                for (int i = up; i > 0; i--) {

                    actualPositionI -= movesDone;
                    tab[actualPositionI][actualPositionY] = head;

                    if (actualPositionI - positionTailI == 2 || positionTailI - actualPositionI == 2) {
                        positionTailI = actualPositionI + 1;
                        positionTailY = actualPositionY;
                        tab[positionTailI][positionTailY] = tail;
                        valueMap = ("I :" + positionTailI + " Y :" + positionTailY);
                        if (!map.containsValue(valueMap)) {
                            map.put(mapKey, valueMap);
                            moves++;
                            mapKey++;
                        }
                    }
                }
            }
            if (text.contains("D")) {
                down = Integer.parseInt(text.substring(2));
                for (int i = 0; i < down; i++) {

                    actualPositionI += movesDone;
                    tab[actualPositionI][actualPositionY] = head;
                    if (actualPositionI - positionTailI == 2 || positionTailI - actualPositionI == 2) {
                        positionTailI = actualPositionI - 1;
                        positionTailY = actualPositionY;
                        tab[positionTailI][positionTailY] = tail;
                        valueMap = ("I :" + positionTailI + "Y :" + positionTailY);
                        if (!map.containsValue(valueMap)) {
                            map.put(mapKey, valueMap);
                            moves++;
                            mapKey++;
                        }
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

                }
            }
        }
        System.out.println(moves);
    }
}
