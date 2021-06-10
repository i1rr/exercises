package usermanager;

import java.util.ArrayList;

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
        ArrayList<Database> dbList = StartUI.getList();
        // within dbList check
        if (dbIndex >= dbList.size() || dbIndex < 0) {
            out.println(System.lineSeparator()
                    + "Enter valid number"
                    + System.lineSeparator());
        } else {
            Database db = StartUI.getList().get(dbIndex);
            if (db != null) {
                logic.setDataBase(db);
            } else {
                out.println(System.lineSeparator()
                        + "You entered wrong number."
                        + System.lineSeparator());
            }
        }
        return true;
    }
}
