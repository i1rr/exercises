package usermanager;

public class ActionAddEmail implements ActionLogic {
    private final Output out;

    public ActionAddEmail(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " - Add e-mail to existing user.";
    }

    @Override
    public boolean execute(Input input, Logic logic) {
        logic.printAllUsers();
        String user = input.askStr(System.lineSeparator()
                + "Enter username: ");
        if (logic.isUserExist(user)) {
            String email = input.askStr(System.lineSeparator()
                    + "Enter extra e-mail: ");
            User usrByEmail = logic.findByEmail(email);
            if (usrByEmail == null) {
                logic.addExtraEmail(email, user);
                logic.printOut();
            } else {
                out.println(System.lineSeparator()
                        + "Unsuccessful. This e-mail already belongs to \""
                        + usrByEmail.getName()
                        + "\""
                + System.lineSeparator());
            }
        } else {
            System.out.println(System.lineSeparator()
                    + "User not found."
                    + System.lineSeparator());
        }
        return true;
    }
}