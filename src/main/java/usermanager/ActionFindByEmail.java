package usermanager;

public class ActionFindByEmail implements ActionLogic {
    private final Output out;

    public ActionFindByEmail(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Find a user by e-mail";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        String email = input.askStr("e-mail: ");
        User usr = logic.findByEmail(email);
        if (usr != null) {
            out.println("\n " + usr + "\n");
        } else {
            out.println("No user with such email exist.");
        }
        return true;
    }
}
