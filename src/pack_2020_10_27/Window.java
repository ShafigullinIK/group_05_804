package pack_2020_10_27;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {

    Animator a;
    Graphics g;


    public Window() {
        int width = 600;
        int height = 400;
        int diam = 10;
        this.setVisible(true);
        this.setTitle("Polynomial Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, width, height);
        this.setLayout(null);

        g = this.getGraphics();
        a = new Animator(g, width, height);
        a.start();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ball ball = new Ball(diam,
                        e.getX(),
                        e.getY(),
                        width);
                a.addBall(ball);
                ball.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
