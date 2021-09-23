package gb;

public class User {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / KB);
        System.out.printf("Total: %d%n", totalMemory / KB);
        System.out.printf("Max: %d%n", maxMemory / KB);
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

    public static void main(String[] args) {
        System.out.println("Before");
        info();
        User vasili = new User(25, "Vasili");
        User alex = new User(34, "Alex");
        User ivan = new User(35, "Ivan");
        System.out.println("After");
        info();
        System.gc();
    }
}

/**

 * Создать несколько объектов User и руками рассчитать сколько они будет занимать памяти. Запрещено использовать библиотеку carrotsearch. Рассчитать надо теоретически.
 *v
 * Нужно найти информацию. Сколько памяти занимает пустой объект без полей.
 *
 * Добиться состояния, когда виртуальная машины вызывает сборщик мусора самостоятельно. За счет ключей xmx.
 *
 * Объяснить поведение программы в текстовом файле.

64bit OpenJDK VM
new User(25, "Vasili"); //age(int), name(String)

Заголовок: 16 байт

 Поле инт: 4 байт

 =================
 Заголовок: 16 байт
 Поля инт: 4*3 = 12 байт
 Ссылка на символьный массив: 4 байт
 Итого: 32 байт

    new char[6]
    Заголовок: 8 байт
    Длинна массива: 4 байт
    Символы: 2 * 6 = 12 байт
    Итого: 24 байт
 =================
Поле стринг Vasili: 56 байт

 4 байта для крастности

 Итого юзер Василий стоит: 80 байт





 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
