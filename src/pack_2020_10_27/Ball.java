package pack_2020_10_27;

public class Ball extends Thread {

    private int diam;
    private int x;
    private int y;
    private int border;
    private int sign = 1;
    private int step = 5;

    public Ball(int diam, int x, int y, int border) {
        this.diam = diam;
        this.x = x;
        this.y = y;
        this.border = border;
    }

    public void makeMove() {
        x += sign * step;
        if (x >= border - diam) {
            sign *= -1;
        }
        if (x <= diam) {
            sign *= -1;
        }
    }

    public int getDiam() {
        return diam;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        while (true) {
            makeMove();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
