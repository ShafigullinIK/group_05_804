package pack_2020_10_20_milooq;

import java.awt.*;

public class Animator {

    private Graphics g;
    private int scale;
    private int len;

    public Animator(Graphics g, int scale, int len) {
        this.g = g;
        this.scale = scale;
        this.len = len;
        drawAxis();
    }

    public void drawAxis() {
        g.setColor(Color.black);

        //ось игрек
        g.drawLine(450, 0, 450, 900);
        g.drawString("Y", 460, 43);
        g.drawLine(450, 30, 440, 40);//стрелочка
        g.drawLine(450, 30, 460, 40);
        for (int i = 0; i < (int) (900 / scale); i++) {
            g.drawString("" + ((int) (900 / (2 * scale)) - i), 450 - 3 * len, scale * i - len);
            g.drawLine(450 - len, scale * i, 450 + len, scale * i); // отметка
        }

        //ось икс
        g.drawLine(0, 450, 900, 450);
        g.drawString("X", 880, 439);
        g.drawLine(880, 440, 895, 450);//стрееелочка
        g.drawLine(880, 460, 895, 450);
        for (int i = 0; i < (int) (Window.width * 1.0 / scale); i++) {
            if (((int) (Window.width * 1.0 / (2 * scale)) - i) == 0) {
                continue;
            }
            g.drawString("" + (i - (int) (900 / (2 * scale))), scale * i - 2 * len, 450 - len);
            g.drawLine(scale * i, 450 - len, scale * i, 450 + len); // отметка
        }
    }

    public void drawPolynom(Polinom poly) {
        double precision = 1e-3;
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
    }
}
