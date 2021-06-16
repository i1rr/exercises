package usermanager;

public class ActionPrintFolder implements ActionLogic {
    private final Output out;

    public ActionPrintFolder(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Show users in current folder.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printOut();
        return true;
    }
}
