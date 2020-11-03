package pack_2020_11_03_multithreading;

import java.util.Random;

public class Main {

    private static final int MAX = 10_000_000;
    private static final int N = 100_000;

    public static void main(String[] args) {
        int[] array = generate(N);

        long start = System.currentTimeMillis();
        int[] left = new int[N/2];
        int[] right = new int[N - N/2];
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                left[i] = array[i];
            } else {
                right[i - array.length / 2] = array[i];
            }
        }

        Sorter sorterLeft = new Sorter(left);
        Sorter sorterRight = new Sorter(right);

        sorterLeft.start();
        sorterRight.start();

        // сюрприз
        try {
            sorterLeft.join();
            sorterRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        int[] array2 = merge(left, right);
        long finish = System.currentTimeMillis();
        System.out.println(isSorted(array2));
        System.out.println(finish - start + " ms");




        start = System.currentTimeMillis();
        int[] sortedArray = bubbleSort(array);
        finish = System.currentTimeMillis();

        System.out.println(isSorted(sortedArray));
        System.out.println(finish - start + " ms");
    }

    public static int[] generate(int n) {
        Random r = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(MAX);
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
        return array;
    }

    public static boolean isSorted(int[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]){
                sorted = false;
            }
        }
        return sorted;
    }

    public static int[] merge(int[] left, int[] right) {
        int leftInd = 0;
        int rightInd = 0;
        int[] newArray = new int[left.length + right.length];
        for (int i = 0; i < newArray.length; i++) {
            if (leftInd >= left.length || rightInd >= right.length) {
                break;
            }
            if (left[leftInd] < right[rightInd]) {
                newArray[i] = left[leftInd];
                leftInd++;
            } else {
                newArray[i] = right[rightInd];
                rightInd++;
            }
        }
        if (leftInd == left.length) {
            for (int i = rightInd; i < right.length; i++) {
                newArray[leftInd + i] = right[i];
            }
        } else {
            for (int i = leftInd; i < left.length; i++) {
                newArray[rightInd + i] = left[i];
            }
        }
        return newArray;
    }

}


