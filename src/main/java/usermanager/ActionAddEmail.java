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
                + "Enter user name: ");
        if (logic.isUserExist(user)) {
            String email = input.askStr(System.lineSeparator()
                    + "Enter extra email: ");
            logic.addExtraEmail(email, user);
        } else {
            System.out.println(System.lineSeparator()
                    + "User not found."
                    + System.lineSeparator());
        }
        return true;
    }
}