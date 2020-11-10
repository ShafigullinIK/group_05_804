package pack_2020_11_10;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        int[] array = {0};
        Example example1 = new Example(array, true);
        Example example2 = new Example(array, false);
        example1.start();
        System.out.println(array[0]);
        example2.start();
        example1.join();
        example2.join();
        System.out.println(array[0]);

    }
}
