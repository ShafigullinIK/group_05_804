package pack_2020_10_20_milooq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class Window extends JFrame{

    public static int width = 900;
    public static int height = 900;
    static int scale = 30;
    static int len = 5;
    int x0, y0, x1, y1;
    int index = 0;
    double[] xes = new double[20];
    double[] yes = new double[20];

    Animator a;

    public Window(){

//        Axis ax = new Axis();

        this.setVisible(true);
        this.setTitle("Polynomial Graphics");
        this.setSize(300,200);
//        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500,100, width, height);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
//      add panel to main frame

//        this.add(ax);

        Graphics g = this.getGraphics();

        a = new Animator(g, scale, len);

        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.drawAxis();

//                double x = Axis.translateX(e.getX());
//                double y = Axis.translateY(e.getY());
//                boolean flag = true;
//                for(int i = 0; i<index; i++){
//                    if(x == xes[i]){
//                        JOptionPane.showMessageDialog(null, "Молодец, ты только что разделил на нуль");
//                        flag = false;
//                        continue;
//                    }
//                }
//                if(flag) {
//                    xes[index] = x;
//                    yes[index] = y;
//                    index++;
//                }
//
//                g.clearRect(0,0,900,900); //очистить экран
////                Polinomial p = new Polinomial(Arrays.copyOfRange(xes, 0, index),Arrays.copyOfRange(yes, 0, index));
////                p.paint(g);
////                ax.paint(g); //нарисовать оси
//                int wight = 4;
//
//                System.out.printf("x = %.2f | y = %.2f\n",x, y);
//                g.setColor(Color.red);
//                for(int i=0; i < index; i++){
//                    g.fillOval(Axis.untranslateX(xes[i]) - wight/2, Axis.untranslateY(yes[i])-wight/2, wight ,wight);
//                }
//                g.setColor(Color.black);
            }

            @Override
            public void mousePressed(MouseEvent e) {

//                x0 = e.getX();
//                y0 = e.getY();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

//                x1 = e.getX();
//                y1 = e.getY();
                //g.drawRect(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1-x0), Math.abs(y1-y0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(a != null) {
            a.drawAxis();
        }
    }
}

// create a panel that you can draw on.
class Axis extends JPanel {

    static int scale = 30;
    static int len = 5;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);

        //ось игрек
        g.drawLine(450, 0, 450, 900);
        g.drawString("Y", 460, 43);
        g.drawLine(450,30,440, 40);//стрелочка
        g.drawLine(450,30,460, 40);
        for(int i = 0; i < (int)(900/scale); i++){
            g.drawString(""+((int)(900/(2*scale)) - i), 450 - 3*len, scale * i - len);
            g.drawLine(450 - len, scale * i, 450 + len, scale * i); // отметка
        }

        //ось икс
        g.drawLine(0, 450, 900, 450);
        g.drawString("X",880 , 439);
        g.drawLine(880,440,895,450);//стрееелочка
        g.drawLine(880,460,895,450);
        for(int i = 0; i < (int)(900/scale); i++){
            if(((int)(900/(2*scale)) - i) == 0){
                continue;
            }
            g.drawString(""+(i - (int)(900/(2*scale))), scale * i - 2*len, 450 - len);
            g.drawLine(scale*i, 450 - len, scale*i, 450+len); // отметка
        }

    }
    static public double translateX (int x){
        return (x - 450.0)/scale;
    }

    static public double translateY (int y){
        return -(y-450.0)/scale;
    }

    static public int untranslateX (double x){
        return (int)((x *scale) + 450);
    }

    static public int untranslateY (double y){
        return (int)(-y*scale+450);
    }
}

class Polinomial extends JPanel {
    Polinom poly;

    public void paint(Graphics g) {
        double precision = 1e-3;
        // for(double i = -10; i < 10; i+=precision){
        ///   double x = i;
        //double y = poly.getValue(i);
        //g.fillOval(Axis.untranslateX(x),Axis.untranslateY(y), 1, 1);
        // }
        double prev_x = -14;
        double prev_y = poly.getValue(-14);
        for(double i = -14; i < 14; i+=precision){
            double curr_x = i;
            double curr_y = poly.getValue(i);
            g.drawLine(Axis.untranslateX(prev_x), Axis.untranslateY(prev_y),
                    Axis.untranslateX(curr_x), Axis.untranslateY(curr_y));
            prev_x = curr_x;
            prev_y = curr_y;
        }
        System.out.println(poly);
    }

    public Polinomial(double[] x, double[] y){
        Polinom [] l = new Polinom[x.length];

        for(int i = 0; i < l.length;i++) {
            l[i] = new Polinom(new double[]{1});
            for (int j = 0; j < l.length ; j++) {
                if (i != j) {
                    l[i] = Polinom.mylty(
                            1/(x[i]-x[j]), l[i]
                    );
                    l[i] = Polinom.multiplication(
                            l[i], new Polinom(new double[]{1.0, -1 * x[j]})
                    );
                }
            }
        }

        Polinom L = new Polinom(new double[0]);

        for(int t = 0; t<l.length; t++){
            L = Polinom.sum(L, Polinom.mylty(y[t], l[t]));
        }
        this.poly = L;
    }
}