package usermanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Database database = (Database) o;
        return Objects.equals(dataBase, database.dataBase) && Objects.equals(name, database.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataBase, name);
    }
}
