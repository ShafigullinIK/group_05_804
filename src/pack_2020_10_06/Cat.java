package pack_2020_10_06;

public class Cat extends Pet {

    public Cat(String name) {
        // skd
        // jfhskjfbh
        this(name, -1);
    }

    @Override
    public void meetFriend() {
        System.out.println("Я мурчу");
    }

    public Cat(String name, double weight) {
        super(name, weight);
        this.noise = "Мяу-мяу-мяу";
        super.petType = "котик";
    }

}
