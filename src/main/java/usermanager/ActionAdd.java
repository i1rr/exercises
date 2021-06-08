package usermanager;

public class ActionAdd implements ActionLogic {
    private final Output out;

    public ActionAdd(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Create new user";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        String email = input.askStr("Enter e-mail: ");
        System.out.println();
        User keyUser = logic.findByEmail(email);
        if (keyUser == null) {
            String name = input.askStr("Name: ");
            User newUser = new User(name);
            logic.add(newUser, email);
        } else {
            out.println("This e-mail already in use.");
        }
        return true;
    }
}
