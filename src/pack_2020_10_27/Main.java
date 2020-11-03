package pack_2020_10_27;

public class Main {

    public static void main(String[] args) {
        new Window();
    }

    public void example(){
        MultiThreadInput input = new MultiThreadInput();
        input.start();
        input.interrupt();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
