package Advent_Coding.DAY5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String name = "cargoLoading.txt";
        File file = new File(name);
        String nameFile = "cargoLoadingHorizontal.txt";
        File fileHorizontal = new File(nameFile);
        Scanner scanner = new Scanner(fileHorizontal);
        String text;
        String[] list1;
        String[] list2;
        String[] list3;
        String[] list4;
        String[] list5;
        String[] list6;
        String[] list7;
        String[] list8;
        String[] list9;
        int counter = 1;
        HashMap<Integer, String[]> map = new HashMap<>();
        while (scanner.hasNext()) {
            text = scanner.nextLine();
            if (counter == 1) {
                list1 = text.split("");
                map.put(counter, list1);
                counter++;
            } else if (counter == 2) {
                list2 = text.split("");
                map.put(counter, list2);
                counter++;
            } else if (counter == 3) {
                list3 = text.split("");
                map.put(counter, list3);
                counter++;
            } else if (counter == 4) {
                list4 = text.split("");
                map.put(counter, list4);
                counter++;

            } else if (counter == 5) {
                list5 = text.split("");
                map.put(counter, list5);
                counter++;

            } else if (counter == 6) {
                list6 = text.split("");
                map.put(counter, list6);
                counter++;

            } else if (counter == 7) {
                list7 = text.split("");
                map.put(counter, list7);
                counter++;

            } else if (counter == 8) {
                list8 = text.split("");
                map.put(counter, list8);
                counter++;

            } else if (counter == 9) {
                list9 = text.split("");
                map.put(counter, list9);
            }
        }
        Scanner scanner1 = new Scanner(file);
        String direction;
        String[] tabOfDirections;
        int howMuch = 0;
        int numberFirstTab = 0;
        int numberSecondTab = 0;
        String[] tab;
        String[] tab2;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();
        while (scanner1.hasNext()) {
            direction = scanner1.nextLine();
            tabOfDirections = direction.split(" ");
            for (int i = 0; i < 1; i++) {
                howMuch = Integer.parseInt(tabOfDirections[1]);
                numberFirstTab = Integer.parseInt(tabOfDirections[3]);
                numberSecondTab = Integer.parseInt(tabOfDirections[tabOfDirections.length - 1]);
                tab = map.get(numberFirstTab);
                tab2 = map.get(numberSecondTab);
                Collections.addAll(arrayList, tab);
                Collections.addAll(arrayList1, tab2);
            }
            int partTwoCounter = howMuch;

            for (int i = 0; i < howMuch; i++) {
//                ------------------part1
//                arrayList1.add(arrayList.get(arrayList.size() - 1));
//                arrayList.remove(arrayList.size() - 1);
//                -----------------part1
//                ---------------part2
                arrayList1.add(arrayList.get(arrayList.size() - partTwoCounter));
                arrayList.remove(arrayList.size() - partTwoCounter);
                partTwoCounter--;
//                -------------part2
            }
            String[] changedTab = new String[arrayList.size()];
            String[] changedTab1 = new String[arrayList1.size()];

            for (int i = 0; i < changedTab.length; i++) {
                changedTab[i] = arrayList.get(i);
            }
            map.replace(numberFirstTab, changedTab);
            arrayList.clear();

            for (int i = 0; i < changedTab1.length; i++) {
                changedTab1[i] = arrayList1.get(i);
            }
            map.replace(numberSecondTab, changedTab1);
            arrayList1.clear();
        }
        for (int i = 1; i < map.size() + 1; i++) {
            System.out.println(Arrays.toString(map.get(i)));
        }
    }
}

