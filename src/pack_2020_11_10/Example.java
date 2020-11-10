package pack_2020_11_10;

public class Example extends Thread {

    int[] array;
    boolean sign;

    public Example(int[] array, boolean sign) {
        this.array = array;
        this.sign = sign;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000_000; i++) {
            if(sign) {
                array[0] += 1;
            } else {
                array[0] -= 1;
            }
        }
    }
}
