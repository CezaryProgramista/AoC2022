package Advent_Coding.DAY6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile = "inputFileDay6.txt";
        File file = new File(nameFile);
        FileReader reader = new FileReader(file);
        int r;
        int counter = 0;
        int mainCounter = 0;
        String text = "";
        String ch1;
        String[] tab2;
        while ((r = reader.read()) != -1) {
            mainCounter++;
            if (mainCounter <= 14 ) {
                ch1 = String.valueOf((char) r);
                text = text.concat(ch1);
            }
            if (mainCounter > 14 ) {
                tab2 = text.split("");
                for (String s : tab2) {
                    for (String value : tab2) {
                        if (s.equals(value)) {
                            counter++;
                        }
                    }
                }
                if ( counter < 15) {
                    mainCounter -= 1;
                    System.out.println("this is main counter : " + mainCounter);
                    break;
                }
                ch1 = String.valueOf((char) r);
                text = text.substring(1);
                text = text.concat(ch1);
                counter = 0;
            }
        }
    }
}
//dla pierwszej czêœci zadania odejmij w ifach 10;