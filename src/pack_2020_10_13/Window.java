package pack_2020_10_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Window extends JFrame {

    int counter = 0;
    Random r = new Random();
    int x0, y0, x1, y1;

    public Window() {
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setSize(800, 600);
        this.setBounds(500, 100, 800, 600);
        this.setLayout(null);

        JButton button = new JButton();
        button.setText("Нажми, чтобы сдать экзамен");
        button.setBounds(200, 100, 250, 50);
        this.add(button);
        Graphics g = this.getGraphics();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int width = 10;
                g.drawOval(e.getX() - width/2,
                        e.getY()-width/2,
                        width,
                        width);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x0 = e.getX();
                y0 = e.getY();
                System.out.println("x0 = " + x0 + " | y0 = " + y0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();

                g.drawRect(Math.min(x0, x1),
                        Math.min(y0, y1),
                        Math.abs(x1 - x0),
                        Math.abs(y1 - y0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawRect(g);
            }
        });


    }

    public void drawRect(Graphics graphics) {
        graphics.drawRect(50, 50, 100, 100);
    }
}
