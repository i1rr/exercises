package usermanager;

public class OutputConsole implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
