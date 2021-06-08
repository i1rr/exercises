package usermanager;

public interface ActionLogic {
    String name();

    boolean execute(Input input, Logic logic);
}
