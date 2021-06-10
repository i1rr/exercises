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
        System.out.println(System.lineSeparator());
        logic.printAllDbs();
        out.println(System.lineSeparator()
                + "WARNING! Merged database will be deleted!"
        + System.lineSeparator());
        int db = input.askInt("Enter the dataBase number you willing to merge: "
        + System.lineSeparator());
        Database dBase = StartUI.getList().get(db);
        if  (dBase != null && !dBase.equals(logic.getDataBase())) {
            logic.mapMerge(dBase);
            StartUI.getList().remove(db);
        } else if (dBase != null && dBase.equals(logic.getDataBase())) {
            out.println("You can not merge current DB into itself.");
        } else {
            out.println(System.lineSeparator()
                    + "Such dataBase doesn't exists."
            + System.lineSeparator());
        }
        return true;
    }
}
