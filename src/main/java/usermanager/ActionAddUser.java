package usermanager;

public class ActionAddUser implements ActionLogic {
    private final Output out;

    public ActionAddUser(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Create new user";
    }

    @Override
    public boolean execute(Input input, Logic logic) {

        String email = input.askStr(System.lineSeparator()
                + "Enter e-mail: "
        + System.lineSeparator());
        User keyUser = logic.findByEmail(email);
        if (keyUser == null) {
            String name = input.askStr("Name: ");
            if (!logic.isUserExist(name)) {
                User newUser = new User(name);
                logic.add(newUser, email);
                logic.printOut();
            } else {
                out.println(System.lineSeparator()
                        + "Unsuccessful. User already exists."
                + System.lineSeparator());
            }
        } else {
            out.println(System.lineSeparator()
                    + "This e-mail already in use."
                   + System.lineSeparator());
        }
        return true;
    }
}
