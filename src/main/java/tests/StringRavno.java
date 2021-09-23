package tests;

public class StringRavno {
    public static void main(String[] args) {
        String one = "297";
        String two = "297";
        System.out.println(one == two);
        for (int i = 0; i < 1000000; i++) {
             new StringBuilder("asdas" + i);
        }
    }
}
