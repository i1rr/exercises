package usermanager;

public class ActionNewDb implements ActionLogic {
    private final Output out;

    public ActionNewDb(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Create new database";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        String name = input.askStr(System.lineSeparator()
                + "Enter database name: "
        + System.lineSeparator());
        if (logic.findDbByName(name) == null) {
            Database newOne = new Database(name);
            StartUI.getList().add(newOne);
            logic.setDataBase(newOne);
        }
        return true;
    }
}
