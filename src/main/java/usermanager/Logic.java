package usermanager;

import java.util.ArrayList;
import java.util.Map;

public class Logic {
    private static Logic instance = null;
    private Database dataBase;

    public Logic() {
        this.dataBase = new Database("default");
        StartUI.getList().add(dataBase);
    }

    public Database getDataBase() {
        return dataBase;
    }

    public void setDataBase(Database dataBase) {
        this.dataBase = dataBase;
    }

    public static Logic getInstance() {
        return instance == null ? new Logic() : instance;
    }

    //print DBs
    public void printAllDbs() {
        for (int i = 0; i < StartUI.getList().size(); i++) {
            System.out.println(i + ". " + StartUI.getList().get(i));
        }

    }

    //findByEmail
    public User findByEmail(String email) {
        for (Map.Entry<User, ArrayList<String>> entry : dataBase.getDataBase().entrySet()) {
            ArrayList<String> emails = entry.getValue();
            if (emails.contains(email)) {
                return entry.getKey();
            }
        }
        return null;
    }

    //add
    public boolean add(User user, String email) {
            ArrayList<String> newOne = new ArrayList<>();
            newOne.add(email);
            dataBase.getDataBase().put(user, newOne);
            return true;
    }

    //merger (HashMap to dataBase)
    public void mapMerge(Database db) {
        boolean copy = false;
        for (Map.Entry<User, ArrayList<String>> entry : db.getDataBase().entrySet()) {
            User userName = entry.getKey();
            ArrayList<String> emails = entry.getValue();
            for (int i = 0; i < emails.size(); i++) {
                User keyUser = findByEmail(emails.get(i));
                if (keyUser != null) {
                    removeDuplicates(emails, dataBase.getDataBase().get(keyUser));
                    System.out.println("Something has been copied");
                    copy = true;
                    break;
                }
            }
            if (!copy) {
                dataBase.getDataBase().put(userName, emails);
            }
        }
    }

    //printer
    public void printOut() {
        for (Map.Entry<User, ArrayList<String>> entry : dataBase.getDataBase().entrySet()) {
            System.out.println(entry);
        }
    }

    //find DB by name
    public Database findDbByName(String name) {
        for (Database db : StartUI.getList()) {
            if (db.getName().equals(name)) {
                return db;
            }
        }
        return null;
    }

    //copy arrays without duplicates
    private void removeDuplicates(ArrayList<String> first, ArrayList<String> second) {
        for (String email : first) {
            if (!second.contains(email)) {
                second.add(email);
            }
        }
    }
}
