package pack_2020_10_06;

public abstract class Pet {

    private String name;
    private double weight;
    protected String noise = "some noise";
    protected String petType = "домашнее животное";

    public Pet(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Pet(String name) {
        this.name = name;
        weight = -1;
    }

    public abstract void meetFriend();

    public void makeSomeNoise(){
        System.out.println(name + ": " + noise);
    }

    @Override
    public String toString(){
        return "Я " + petType + ", меня зовут " + name;
    }
}
