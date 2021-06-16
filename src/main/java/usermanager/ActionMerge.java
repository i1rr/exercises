package usermanager;

import java.util.ArrayList;

public class ActionMerge implements ActionLogic {
    private final Output out;

    public ActionMerge(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Merge folder to existing one.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        System.out.println(System.lineSeparator());
        logic.printAllFolders();
        out.println(System.lineSeparator()
                + "WARNING! Merged folder will be permanently deleted!"
        + System.lineSeparator());
        int dbIndex = input.askInt("Enter folder number you willing to merge: "
        + System.lineSeparator());
        ArrayList<Folder> dbList = Logic.getFolderList();
        // within dbList check
        if (dbIndex >= dbList.size() || dbIndex < 0) {
            out.println(System.lineSeparator()
                    + "Enter valid number"
            + System.lineSeparator());
        } else {
            Folder dBank = dbList.get(dbIndex);
            if (dBank != null && !dBank.equals(logic.getFolder())) {
                logic.mapMerge(dBank);
                Logic.getFolderList().remove(dbIndex);
            } else if (dBank != null && dBank.equals(logic.getFolder())) {
                out.println("You can not merge current folder into itself.");
            } else {
                out.println(System.lineSeparator()
                        + "Such folder doesn't exists."
                        + System.lineSeparator());
            }
        }
        return true;
    }
}
