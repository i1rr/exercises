package usermanager;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private static ArrayList<Database> list = new ArrayList<>();
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static ArrayList<Database> getList() {
        return list;
    }

    public static void setList(ArrayList<Database> list) {
        StartUI.list = list;
    }

    private void showMenu(List<ActionLogic> actions) {
        out.println("Menu.");
        int index = 0;
        for (ActionLogic action : actions) {
            out.println(index + ". " + action.name());
            index++;
        }
    }

    public void init(Input input, Logic logic, List<ActionLogic> actions) {
        boolean run = true;
        while (run) {
            out.println("YOU ARE IN : === " + logic.getDataBase().getName() + " ===");
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println(System.lineSeparator()
                        + "No such menu exists, please try again."
                        + System.lineSeparator());
                continue;
            }
            ActionLogic action = actions.get(select);
            run = action.execute(input, logic);
        }
    }

    public static void main(String[] args) {
        Output output = new OutputConsole();
        Input input =  new InputCheck(new InputConsole(), output);
        Logic logic = Logic.getInstance();
        List<ActionLogic> actions = new ArrayList<>();
        actions.add(new ActionNewDb(output));
        actions.add(new ActionSwitchDb(output));
        actions.add(new ActionAdd(output));
        actions.add(new ActionAddEmail(output));
        actions.add(new ActionFindByEmail(output));
        actions.add(new ActionPrinter(output));
        actions.add(new ActionMerge(output));
        actions.add(new ActionExit(output));

        new StartUI(output).init(input, logic, actions);
    }
}
