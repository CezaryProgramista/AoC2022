package Advent_Coding.DAY9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Cezary\\IdeaProjects\\AoC2022\\inputFileDay9.txt");
        ArrayList<String> movesDirection = new ArrayList<>();
        ArrayList<Integer> movesValue = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            movesDirection.add(text.substring(0, 1));
            movesValue.add(Integer.valueOf(text.substring(2)));
        }
        for (int i = 0; i < movesDirection.size(); i++) {
            System.out.println(movesDirection.get(i)+movesValue.get(i));
        }
        System.out.println();


        ArrayList knots = new ArrayList<>();

        int tab[][] = new int[50][50];
        int actualPositionHeadX = tab.length / 2;
        int actualPositionHeadY = tab.length / 2;
        for (int i = 0; i < movesDirection.size(); i++) {
            for (int x = 0; x < movesValue.get(x); x++) {
            }
        }
    }
}