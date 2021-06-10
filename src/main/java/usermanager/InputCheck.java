package usermanager;

public class InputCheck implements Input {
    private final Input in;
    private final Output out;

    public InputCheck(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nFe) {
                out.println(System.lineSeparator()
                + "Please enter valid number"
                + System.lineSeparator());
            }
        } while (invalid);
        return value;
    }
}
