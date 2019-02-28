package by.spurky.progression;

import by.spurky.Util;

import java.util.Arrays;

public class TestPerfomance {
    public static void main(String[] args) {
        new TestPerfomance().start();
    }

    public void start() {
        int size = 1_000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (i + 1) * 2;
        }

        Util.shuffle(array);

        int[] cloneArray = array.clone();


        print(array);
        System.out.println("Start sort by Arrays.sort()");
        long start = System.nanoTime();
        Arrays.sort(array);;
        System.out.println("Sort along for " + (System.nanoTime() - start) + "ns");
        print(array);

        System.out.println();

        print(cloneArray);
        System.out.println("Start sort by mySort()");
        start = System.nanoTime();
        mySort(cloneArray);
        System.out.println("Sort along for " + (System.nanoTime() - start) + "ns");
        print(cloneArray);
    }

    public void mySort(int[] array) {

        int delta = 2;
        int a1 = 2;

        int number;
        int index = 0;
        int buffer = array[0];


        for (int i = 0; i < array.length; i++) { //an = a1 + d * (n - 1) || -d * (n - 1) = a1 - an || d * (n - 1) = an - a1 || n - 1 = (an - a1) / d || n = (an - a1) / d - 1
            int trueIndex = (array[i] - a1) / delta;
            if (trueIndex != i) {
                buffer = array[trueIndex]; //забираем число, сидящее не на своём месте
                array[trueIndex] = number; //кладём правильное число
            } else {
                buffer = array[++index];
            }
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < 100; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }



}

