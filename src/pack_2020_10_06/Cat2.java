package pack_2020_10_06;

public class Cat2 {

    private String name;
    private double weight;

    public Cat2(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Cat2(String name) {
        this.name = name;
        weight = -1;
    }

    public void setWeight(double weight) {
        if(weight < 0) {
            throw new NumberFormatException();
        }
        this.weight = weight;
    }

    public void makeSomeNoise() {
        System.out.println(name + ": Мяу-мяу-мяу");
    }

    @Override
    public String toString() {
        return "Я кошка, меня зовут " + name;
    }

}
