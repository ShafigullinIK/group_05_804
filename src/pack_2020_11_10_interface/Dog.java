package pack_2020_11_10_interface;

public class Dog implements IAnimal {

    public void sayHi(){
        System.out.println("Виляю хвостом");
    }

    public void makeSomeNoise() {
        System.out.println("Гав-гав-гав");
    }
}
