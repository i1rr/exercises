package usermanager;

public class ActionSwitchDb implements ActionLogic {
    private final Output out;

    public ActionSwitchDb(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Jump to another database";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printAllDbs();
        int dbIndex = input.askInt(System.lineSeparator()
                + "Enter database number: ");
        Database db = StartUI.getList().get(dbIndex);
        if (db != null) {
            logic.setDataBase(db);
        } else {
            out.println(System.lineSeparator()
                    + "You entered wrong number.");
        }
        return true;
    }
}
