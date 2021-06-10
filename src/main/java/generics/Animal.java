package generics;

public class Animal {
    private int id;

    public Animal() {
    }

    public Animal(int id) {
        this.id = id;
    }

    public void eat() {
        System.out.println("Animals is eating...");
    }

    public String toString() {
        return String.valueOf(id);
    }
}
