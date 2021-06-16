package usermanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Folder {
    private final HashMap<User, ArrayList<String>> folder = new HashMap<>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public HashMap<User, ArrayList<String>> getFolder() {
        return folder;
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
        Folder folder = (Folder) o;
        return Objects.equals(this.folder, folder.folder) && Objects.equals(this.name, folder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folder, name);
    }
}
