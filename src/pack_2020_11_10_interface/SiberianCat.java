package pack_2020_11_10_interface;

public class SiberianCat extends Cat implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.makeSomeNoise();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Всё-всё, я всё понял, больше не мяукаю");
                break;
            }
        }
    }
}
