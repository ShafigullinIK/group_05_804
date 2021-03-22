package pack_2020_09_15;

public class First {

    public static void main(String[] args) {
        int[] array = {1, 2 ,3, 4};
        printArray(array);
        System.out.println(array);
    }

    public static void printArray(int[] array) {
        for(int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
