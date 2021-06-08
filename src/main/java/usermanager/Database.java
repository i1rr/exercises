package usermanager;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private final HashMap<User, ArrayList<String>> dataBase = new HashMap<>();
    private String name;

    public Database(String name) {
        this.name = name;
    }

    public HashMap<User, ArrayList<String>> getDataBase() {
        return dataBase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
