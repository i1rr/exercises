package usermanager;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;

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
        int dbIndex = input.askInt("Enter the dataBase number you willing to merge: "
        + System.lineSeparator());
        ArrayList<Database> dbList = StartUI.getList();
        // within dbList check
        if (dbIndex >= dbList.size() || dbIndex < 0) {
            out.println(System.lineSeparator()
                    + "Enter valid number"
            + System.lineSeparator());
        } else {
            Database dBase = dbList.get(dbIndex);
            if (dBase != null && !dBase.equals(logic.getDataBase())) {
                logic.mapMerge(dBase);
                StartUI.getList().remove(dbIndex);
            } else if (dBase != null && dBase.equals(logic.getDataBase())) {
                out.println("You can not merge current DB into itself.");
            } else {
                out.println(System.lineSeparator()
                        + "Such dataBase doesn't exists."
                        + System.lineSeparator());
            }
        }
        return true;
    }
}
