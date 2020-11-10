package pack_2020_11_10_interface;

public class Main {

    public static void main(String[] args) {
        SiberianCat cat = new SiberianCat();
        Thread t = new Thread(cat);
        t.start();
//        new Thread(cat).start();
        Dog dog = new Dog();
        dog.makeSomeNoise();
        cat.makeSomeNoise();
        noise(dog);
        noise(dog);
        noise(dog);
        noise(dog);
        noise(cat);
        noise(cat);
        noise(cat);
        System.out.println("=================");
        t.interrupt();
    }

    public static void noise(IAnimal a) {
        a.makeSomeNoise();
        a.sayHi();
    }
}
