package pack_2020_11_10_interface;

public class Cat implements IAnimal {

    public void sayHi(){
        System.out.println("Мурлычу");
    }

    @Override
    public void makeSomeNoise() {
        System.out.println("Мяу-мяу-мяу");
    }

}
