package usermanager;

public class ActionFindByEmail implements ActionLogic {
    private final Output out;

    public ActionFindByEmail(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Find user by e-mail";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        String email = input.askStr(System.lineSeparator()
                + "e-mail: "
                + System.lineSeparator());
        User usr = logic.findByEmail(email);
        if (usr != null) {
            out.println("\n " + usr + "\n");
        } else {
            out.println(System.lineSeparator()
                    + "No user with such email exists."
                    + System.lineSeparator());
        }
        return true;
    }
}
