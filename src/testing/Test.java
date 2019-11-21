package testing;

public class Test {

    private String breed, name;
    private int age, weight;

    public Test (String name, int age, int weight, String breed){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public Test (String name, String breed){
        this(name, 0, 0, breed);
    }
}
