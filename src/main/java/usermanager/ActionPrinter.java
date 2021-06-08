package usermanager;

public class ActionPrinter implements ActionLogic {
    private final Output out;

    public ActionPrinter(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Show database.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printOut();
        return true;
    }
}
