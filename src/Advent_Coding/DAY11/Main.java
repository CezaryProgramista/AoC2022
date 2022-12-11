package Advent_Coding.DAY11;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<BigInteger> monkey0 = new ArrayList<>() {{
            add(BigInteger.valueOf(66));
            add(BigInteger.valueOf(71));
            add(BigInteger.valueOf(94));
        }};
        ArrayList<BigInteger> monkey1 = new ArrayList<>() {{
            add(BigInteger.valueOf(70));
        }};
        ArrayList<BigInteger> monkey2 = new ArrayList<>() {{
            add(BigInteger.valueOf(62));
            add(BigInteger.valueOf(68));
            add(BigInteger.valueOf(56));
            add(BigInteger.valueOf(65));
            add(BigInteger.valueOf(94));
            add(BigInteger.valueOf(78));
        }};
        ArrayList<BigInteger> monkey3 = new ArrayList<>() {{
            add(BigInteger.valueOf(89));
            add(BigInteger.valueOf(94));
            add(BigInteger.valueOf(94));
            add(BigInteger.valueOf(67));
        }};
        ArrayList<BigInteger> monkey4 = new ArrayList<>() {{
            add(BigInteger.valueOf(71));
            add(BigInteger.valueOf(61));
            add(BigInteger.valueOf(73));
            add(BigInteger.valueOf(65));
            add(BigInteger.valueOf(98));
            add(BigInteger.valueOf(98));
            add(BigInteger.valueOf(63));
        }};

        ArrayList<BigInteger> monkey5 = new ArrayList<>() {{
            add(BigInteger.valueOf(55));
            add(BigInteger.valueOf(62));
            add(BigInteger.valueOf(68));
            add(BigInteger.valueOf(61));
            add(BigInteger.valueOf(60));
        }};
        ArrayList<BigInteger> monkey6 = new ArrayList<>() {{
            add(BigInteger.valueOf(93));
            add(BigInteger.valueOf(91));
            add(BigInteger.valueOf(69));
            add(BigInteger.valueOf(64));
            add(BigInteger.valueOf(72));
            add(BigInteger.valueOf(89));
            add(BigInteger.valueOf(50));
            add(BigInteger.valueOf(71));
        }};
        ArrayList<BigInteger> monkey7 = new ArrayList<>() {{
            add(BigInteger.valueOf(76));
            add(BigInteger.valueOf(50));
        }};
        BigInteger operationByMonkey;
        HashMap<Integer, BigInteger> operation = new HashMap<>();
        operation.put(0, BigInteger.valueOf(5));
        operation.put(1, BigInteger.valueOf(6));
        operation.put(2, BigInteger.valueOf(5));
        operation.put(3, BigInteger.valueOf(2));
        operation.put(4, BigInteger.valueOf(7));
        operation.put(5, BigInteger.valueOf(7));
        operation.put(6, BigInteger.valueOf(1));
        HashMap<Integer, BigInteger> test = new HashMap<>();
        //test operation divine by value
        test.put(0, BigInteger.valueOf(3));
        test.put(1, BigInteger.valueOf(17));
        test.put(2, BigInteger.valueOf(2));
        test.put(3, BigInteger.valueOf(19));
        test.put(4, BigInteger.valueOf(11));
        test.put(5, BigInteger.valueOf(5));
        test.put(6, BigInteger.valueOf(13));
        test.put(7, BigInteger.valueOf(7));
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        //sum of multiply each of tests because they are "first numbers"
        BigInteger w = BigInteger.valueOf(9699690);
        BigInteger rest;

        for (int i = 0; i < 10000; i++) {
            ///-------------------MONKEY0
            for (int j = 0; j < monkey0.size(); j++) {
                //counting inspection
                counter0++;
                //operation
                rest = monkey0.get(j).remainder(w);
                operationByMonkey = rest.multiply(operation.get(0));
                //monkey gets bored
//                operationByMonkey = operationByMonkey.divide(BigInteger.valueOf(3));
                //throwing to another monkey
                if (operationByMonkey.mod(test.get(0)).equals(BigInteger.valueOf(0))) {
                    monkey7.add(operationByMonkey);
                } else {
                    monkey4.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey0.clear();
            ///------------------MONKEY1
            for (int j = 0; j < monkey1.size(); j++) {
                //counting inspection
                counter1++;
                //operation
                rest = monkey1.get(j).remainder(w);
                operationByMonkey = rest.add(operation.get(1));

                //monkey gets bored
//                operationByMonkey = operationByMonkey.divide(BigInteger.valueOf(3));
                //throwing to another monkey
                if (operationByMonkey.mod(test.get(1)).equals(BigInteger.valueOf(0))) {
                    monkey3.add(operationByMonkey);
                } else {
                    monkey0.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey1.clear();

            ////--------------------------MONKEY2
            for (int j = 0; j < monkey2.size(); j++) {
                //counting inspection
                counter2++;
                //operation
                rest = monkey2.get(j).remainder(w);
                operationByMonkey = rest.add(operation.get(2));
                //monkey gets bored
//                operationByMonkey = operationByMonkey.divide(BigInteger.valueOf(3));
                //throwing to another monkey
                if (operationByMonkey.remainder(test.get(2)).equals(BigInteger.valueOf(0))) {
                    monkey3.add(operationByMonkey);
                } else {
                    monkey1.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey2.clear();
            ////---------------------------------MONKEY3
            for (int j = 0; j < monkey3.size(); j++) {
                //counting inspection
                counter3++;
                //operation
                rest = monkey3.get(j).remainder(w);
                operationByMonkey = rest.add(operation.get(3));
                //monkey gets bored
//                operationByMonkey = operationByMonkey.divide(BigInteger.valueOf(3));
                //throwing to another monkey
                if (operationByMonkey.remainder(test.get(3)).equals(BigInteger.valueOf(0))) {
                    monkey7.add(operationByMonkey);
                } else {
                    monkey0.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey3.clear();
            //---------------------------------MONKEY4
            for (int j = 0; j < monkey4.size(); j++) {
                //counting inspection
                counter4++;
                //operation
                rest = monkey4.get(j).remainder(w);
                operationByMonkey = rest.multiply(operation.get(4));
                //monkey gets bored
//                operationByMonkey = operationByMonkey / 3;
                //throwing to another monkey
                if (operationByMonkey.remainder(test.get(4)).equals(BigInteger.valueOf(0))) {
                    monkey5.add(operationByMonkey);
                } else {
                    monkey6.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey4.clear();
            ////---------------------------------MONKEY5
            for (int j = 0; j < monkey5.size(); j++) {
                //counting inspection
                counter5++;
                //operation
                rest = monkey5.get(j).remainder(w);
                operationByMonkey = rest.add(operation.get(5));
                //monkey gets bored
//                operationByMonkey = operationByMonkey / 3;
                //throwing to another monkey
                if (operationByMonkey.remainder(test.get(5)).equals(BigInteger.valueOf(0))) {
                    monkey2.add(operationByMonkey);
                } else {
                    monkey1.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey5.clear();
            ////---------------------------------MONKEY6
            for (int j = 0; j < monkey6.size(); j++) {
                //counting inspection
                counter6++;
                //operation
                rest = monkey6.get(j).remainder(w);
                operationByMonkey = rest.add(operation.get(6));
                //monkey gets bored
//                operationByMonkey = operationByMonkey / 3;
                //throwing to another monkey
                if (operationByMonkey.remainder(test.get(6)).equals(BigInteger.valueOf(0))) {
                    monkey5.add(operationByMonkey);
                } else {
                    monkey2.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey6.clear();
            ////---------------------------------MONKEY7
            for (int j = 0; j < monkey7.size(); j++) {
                //counting inspection
                counter7++;
                //operation
                rest = monkey7.get(j).remainder(w);
                operationByMonkey = rest.multiply(rest);
                //monkey gets bored
//                operationByMonkey = operationByMonkey / 3;
                //throwing to another monkey
                if (operationByMonkey.remainder(test.get(7)).equals(BigInteger.valueOf(0))) {
                    monkey4.add(operationByMonkey);
                } else {
                    monkey6.add(operationByMonkey);
                }
            }
            //remove item for actual monkey
            monkey7.clear();
        }
        System.out.println(counter0);
        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println(counter3);
        System.out.println(counter4);
        System.out.println(counter5);
        System.out.println(counter6);
        System.out.println(counter7);
    }
}
