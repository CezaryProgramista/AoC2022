package Advent_Coding.DAY13;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {


        File file = new File("C:\\Users\\Cezary\\IdeaProjects\\AoC2022\\inputFIleDay13.txt");
        FileReader reader = new FileReader(file);
        ArrayList<ArrayList> listaList = new ArrayList<>();
        ArrayList<liczba> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        HashMap<Integer, ArrayList> mapLeft = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> mapRight = new HashMap<>();
        int r;
        int arraysLeft = 0;
        int arraysRight = 0;
        int key = 0;
        while (reader.ready()) {
            r = reader.read();
            String ch = String.valueOf((char) r);
            boolean first = true;
            boolean second = false;

            if (first) {
                if (ch.equals("[")) {
                   listaList.add(key,leftList);
                    key++;
                }
                if (ch.matches("[0-9]")) {
                    liczba liczba = new liczba(ch);
                    liczba.setValue(Integer.parseInt(ch));
                    leftList.add(liczba);
                }
                if (ch.matches("\n")) {
                    first = false;
                    key = 0;
                    second = true;

                }
            }
            else if (second) {
                if (ch.equals("[")) {
                    mapRight.put(key, rightList);
                }
                if (ch.matches("[0-9]")) {
                    rightList.add(Integer.valueOf(ch));
                }
                if (ch.matches("\n")) {
                    first = false;
                    key = 0;
                    second = true;
                   ;
                }
            }
        }
        for (int i=0;i<listaList.size();i++){
            System.out.println(listaList.get(i));
            System.out.println(listaList.size());
        }
    }
}
