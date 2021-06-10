package usermanager;

public class ActionMerge implements ActionLogic {
    private final Output out;

    public ActionMerge(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Merge databases.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printAllDbs();
        out.println("WARNING! Merged database will be deleted!");
        int db = input.askInt("Enter the dataBase number you willing to merge: ");
        Database dBase = StartUI.getList().get(db);
        if (dBase != null) {
            logic.mapMerge(dBase);
            StartUI.getList().remove(db);
        } else {
            out.println("Such dataBase doesn't exist.");
        }
        return true;
    }
}
