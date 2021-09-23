package gb;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class GbTest {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / KB);
        System.out.printf("Total: %d%n", totalMemory / KB);
        System.out.printf("Max: %d%n", maxMemory / KB);
    }

    public static void main(String[] args) throws InterruptedException {
        info();
        System.gc();
        for (int i = 0; i < 10000; i++) {
            for (int o = 0; o < i; o++) {
                new Person(i, "Neb6ue6uytytyutyjdyjen56une65imt78,,o98om7tkirj7hgwevhe67j" + i);
            }
            Thread.sleep(200);
            System.out.println(LocalDateTime.now());
        }
        System.gc();
        info();
    }
}

class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}