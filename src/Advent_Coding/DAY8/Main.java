package Advent_Coding.DAY8;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile = "inputFileDay8.txt";
        File file = new File(nameFile);
        int r;
        int j = 0;
        int i = 0;
        int poziomnica = 1;
        int treesSee = 0;
        int insideTreesSee = 0;
        boolean plus = true;
        boolean minus = true;
        boolean plusHorizontal = true;
        boolean minusHorizontal = true;
        int[][] tab = new int[99][99];
        char ch;
        int max = 0;
        int view;

        try (FileReader reader = new FileReader(file)) {
            while ((r = reader.read()) != -1) {

                ch = (char) r;
                if (ch != 13 && ch != 10) {
                    int value = Integer.parseInt(String.valueOf(ch));
                    tab[i][j] = value;
                    j++;
                }
                if (ch == 13) {
                    i++;
                    j = 0;
                }
            }
        }
        for (i = 0; i < tab.length; i++) {
            for (j = 0; j < tab.length; j++) {
                // part one
                if (i == 0 || j == 0 || i == tab.length - 1 || j == tab.length - 1) {
                    treesSee++;
                }
                //start sprawdzania srodka.
                else if (i > 0 && j > 0) {
                    int up = 0;
                    int down = 0;
                    int left = 0;
                    int right = 0;
                    //sprawdzanie w prawo.
                    int zostaloPrzejsc = tab.length - j;
                    int zostaloPrzejscPionowo = tab.length - i;
                    for (int k = 0; k < zostaloPrzejsc - 1; k++) {
                        if (tab[i][j] > tab[i][j + poziomnica]) {
                            plus = true;
                            //part two
                            right++;
                        } else if (tab[i][j] == tab[i][j + poziomnica]) {
                            right++;
                            plus = false;
                            break;
                        } else {
                            plus = false;
                            right++;
                            break;
                        }
                        poziomnica++;
                    }
                    //sprawdzanie w lewo/
                    poziomnica = 1;
                    for (int l = j; l > 0; l--) {
                        if (tab[i][j] > tab[i][j - poziomnica]) {
                            minus = true;
                            left++;
                        } else if (tab[i][j] == tab[i][j - poziomnica]) {
                            left++;
                            minus = false;
                            break;
                        } else {
                            minus = false;
                            left++;
                            break;
                        }
                        poziomnica++;
                    }
                    //sprawdzanie w dó³
                    poziomnica = 1;
                    for (int m = 0; m < zostaloPrzejscPionowo - 1; m++) {
                        if (tab[i][j] > tab[i + poziomnica][j]) {
                            plusHorizontal = true;
                            down++;
                        } else if (tab[i][j] == tab[i + poziomnica][j]) {
                            down++;
                            plusHorizontal = false;
                            break;
                        } else {
                            plusHorizontal = false;
                            down++;
                            break;
                        }
                        poziomnica++;
                    }
                    //sprawdzenie w góre.
                    poziomnica = 1;
                    for (int z = i; z > 0; z--) {
                        if (tab[i][j] > tab[i - poziomnica][j]) {
                            minusHorizontal = true;
                            up++;
                        } else if (tab[i][j] == tab[i - poziomnica][j]) {
                            up++;
                            minusHorizontal = false;
                            break;
                        } else {
                            minusHorizontal = false;
                            up++;
                            break;
                        }
                        poziomnica++;
                    }
                    poziomnica = 1;
                    if (plus || minus || plusHorizontal || minusHorizontal) {
                        insideTreesSee++;
                    }
                    view = left * right * up * down;

                    if (i == 1 && j == 1) {
                        max = view;
                    }
                    if (view > max) {
                        max = view;
                    }
                }
            }
        }
        //part one
        int sum;
        sum = treesSee + insideTreesSee;
        System.out.println(sum);
        System.out.println(max);
    }
}

