package usermanager;

public class ActionAddFolder implements ActionLogic {
    private final Output out;

    public ActionAddFolder(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Create new folder";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        String name = input.askStr(System.lineSeparator()
                + "Enter folder name: "
        + System.lineSeparator());
        if (logic.findFolderByName(name) == null) {
            Folder newOne = new Folder(name);
            Logic.getFolderList().add(newOne);
            logic.setFolder(newOne);
        }
        return true;
    }
}
