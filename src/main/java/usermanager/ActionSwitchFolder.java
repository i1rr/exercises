package usermanager;

import java.util.ArrayList;

public class ActionSwitchFolder implements ActionLogic {
    private final Output out;

    public ActionSwitchFolder(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Change folder";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printAllFolders();
        int folderIndex = input.askInt(System.lineSeparator()
                + "Enter folder number: ");
        ArrayList<Folder> folderList = Logic.getFolderList();
        // within folderList check
        if (folderIndex >= folderList.size() || folderIndex < 0) {
            out.println(System.lineSeparator()
                    + "Enter valid number"
                    + System.lineSeparator());
        } else {
            Folder folder = Logic.getFolderList().get(folderIndex);
            if (folder != null) {
                logic.setFolder(folder);
            } else {
                out.println(System.lineSeparator()
                        + "You entered wrong number."
                        + System.lineSeparator());
            }
        }
        return true;
    }
}
