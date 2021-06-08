package usermanager;

public class ActionExit implements ActionLogic {
    private final Output out;

    public ActionExit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Exit.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        return false;
    }
}
