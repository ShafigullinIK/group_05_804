package pack_2020_09_15;

import java.util.Random;

public class First {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, 9, 0, 8, 4, 4};
        int[] left = {1, 3, 6, 9};
        int[] right = {0, 4, 4, 8};
//        printArray(merge(left, right));
        printArray(mergeSort(array));
    }

    public static int[] createArray(int n) {
        int[] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - array.length / 2];
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                left[i] = array[i];
            } else {
                right[i - array.length / 2] = array[i];
            }
        }
//        printArray(left);
//        printArray(right);
        mergeSort(left);
        mergeSort(right);
        return merge(left, right);
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
