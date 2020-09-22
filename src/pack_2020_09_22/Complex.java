package pack_2020_09_22;

public class Complex {

    private double re;
    private double im;

    public Complex() {

    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public void setRe(double d) {
        re = d;
    }

    public void setIm(double d) {
        im = d;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public static void print(Complex c) {
        System.out.println(c.getRe() + " + " + c.getIm() + "i");
    }

    public static Complex sum(Complex a, Complex b) {
        Complex result =
                new Complex(a.getRe() + b.getRe(),
                        a.getIm() + b.getIm());
        return result;
    }

    public static Complex prod(Complex a, Complex b) {
        return new Complex(a.getRe() * b.getRe() - a.getIm() * b.getIm(),
                a.getRe() * b.getIm() + a.getIm() * b.getRe());
    }

    public static Complex prod(double d, Complex c) {
        return new Complex(d * c.getRe(), d * c.getIm());
    }

    public static Complex sub(Complex a, Complex b) {
        return sum(a, prod(-1, b));
    }

    public double module() {
        return Math.sqrt(this.re * this.re +
                this.im * this.im);
    }

    public double arg() {
        double result;
        if (this.re >= 0) {
            result = Math.atan(this.im / this.re);
        }else {
            if (this.re < 0 && this.im < 0) {
                result = Math.atan(this.im / this.re) - Math.PI;
            } else {
                result = Math.atan(this.im / this.re) + Math.PI;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return re + " + " + im + "i";
    }

}
