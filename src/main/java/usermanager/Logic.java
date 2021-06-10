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

    //add an email to existing user
    public void addExtraEmail(String email, String user) {
        for (Map.Entry<User, ArrayList<String>> entry : dataBase.getDataBase().entrySet()) {
            User usr = entry.getKey();
            if (usr.getName().equals(user)) {
                entry.getValue().add(email);
            }
        }
    }

    //print all users
    public void printAllUsers() {
        System.out.println(System.lineSeparator());
        for (Map.Entry<User, ArrayList<String>> entry : dataBase.getDataBase().entrySet()) {
            System.out.println("- " + entry.getKey().toString());
        }
        System.out.println(System.lineSeparator());
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

    //addNewUser
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
            copy = false;
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

    //checkIfUserExist
    public boolean isUserExist(String name) {
        for (Map.Entry<User, ArrayList<String>> entry : dataBase.getDataBase().entrySet()) {
            User usr = entry.getKey();
            if (usr.getName().equals(name)) {
                return true;
            }
        }
        return false;
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
