package usermanager;

public class ActionShowUsers implements ActionLogic {
    private final Output out;

    public ActionShowUsers(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Show all users in current DB.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printAllUsers();
        return true;
    }
}
