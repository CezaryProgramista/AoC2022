package Advent_Coding.DAY10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Cezary\\IdeaProjects\\AoC2022\\inputFileDay10.txt");
        int cycles;
        int actualValue = 1;
        int finalCycles = 0;
        //part1
//        int finalValue;
        int value = 0;
        int circleToSum = 40;
        int pixelWrite = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            if (text.contains("addx")) {
                value = Integer.parseInt(text.substring(5));
                cycles = 2;
            } else {
                cycles = 1;
            }
            for (int i = 0; i < cycles; i++) {
                finalCycles++;
                //part1
//                if (finalCycles == 20 || finalCycles == circleToSum) {
//                    circleToSum = finalCycles + 40;
//                    finalValue = finalCycles * actualValue;
//                    System.out.println(finalCycles + ": " + finalValue);
//                }
                //======================part2
                if (pixelWrite == actualValue || pixelWrite - 1 == actualValue || pixelWrite + 1 == actualValue) {
                    System.out.print("#");
                    pixelWrite++;
                } else {
                    System.out.print(".");
                    pixelWrite++;
                }
                if (finalCycles == circleToSum) {
                    System.out.println();
                    circleToSum += 40;
                    pixelWrite = 0;
                }
                //====================part2
                if (i == 1) {
                    actualValue = value + actualValue;

                }
            }
        }
    }
}
