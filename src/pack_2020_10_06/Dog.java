package pack_2020_10_06;

public class Dog extends Pet{

    public Dog(String name){
        this(name, -1);
    }

    @Override
    public void meetFriend() {
        System.out.println("Я виляю хвостом");
    }

    public Dog(String name, double weight){
        super(name, weight);
        super.noise = "Гав-гав-гав";
        super.petType = "пёсик";
    }

}
