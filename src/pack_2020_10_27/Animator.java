package pack_2020_10_27;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Animator extends Thread {

    private Graphics g;
    private int width;
    private int height;
    private ArrayList<Ball> balls;
    BufferedImage image_cheb;
    BufferedImage image_grass;
    BufferedImage frame;
    Graphics frameGraphics;

    public Animator(Graphics g, int width, int height) {
        this.g = g;
        this.width = width;
        this.height = height;
        balls = new ArrayList<>();
        frame = new BufferedImage(width,
                height,
                BufferedImage.TYPE_INT_RGB);
        frameGraphics = frame.getGraphics();
        clear();
        try {
            image_cheb = ImageIO.read(new File("1.jpg"));
            image_grass = ImageIO.read(new File("grass.jpg"));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void clear() {
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, width, height);
//        g.setColor(Color.BLACK);
        int cell_size = 10;
        for (int i = 0; i < width/cell_size; i++) {
            for (int j = 0; j < height/cell_size; j++) {
                frameGraphics.drawImage(image_grass,
                        i*cell_size,
                        j*cell_size,
                        75,
                        75,
                        null);
            }
        }
    }



    @Override
    public void run() {
        while (true) {
            clear();
            for (Ball ball : balls) {
                frameGraphics.drawImage(image_cheb,
                        ball.getX(),
                        ball.getY(),
                        75,
                        75,
                        null);
            }
            g.drawImage(frame, 0, 0, null);
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
