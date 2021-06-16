package usermanager;

import java.util.*;

public class Logic {
    private final static ArrayList<Folder> LIST = new ArrayList<>();
    private static Logic instance = null;
    private Folder folder;

    public Logic() {
        this.folder = new Folder("default");
        getFolderList().add(folder);
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public static Logic getInstance() {
        return instance == null ? new Logic() : instance;
    }

    //add email to existing user
    public void addExtraEmail(String email, String user) {
        for (Map.Entry<User, ArrayList<String>> entry : folder.getFolder().entrySet()) {
            User usr = entry.getKey();
            if (usr.getName().equals(user)) {
                entry.getValue().add(email);
            }
        }
    }

    //print all users out
    public void printAllUsers() {
        System.out.println(System.lineSeparator());
        for (Map.Entry<User, ArrayList<String>> entry : folder.getFolder().entrySet()) {
            System.out.println("- " + entry.getKey().toString());
        }
        System.out.println(System.lineSeparator());
    }

    //print folder out
    public void printAllFolders() {
        for (int i = 0; i < getFolderList().size(); i++) {
            System.out.println(i + ". " + getFolderList().get(i));
        }
    }

    //findByEmail
    public User findByEmail(String email) {
        for (Map.Entry<User, ArrayList<String>> entry : folder.getFolder().entrySet()) {
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
            folder.getFolder().put(user, newOne);
            return true;
    }

    //merger (Folder<HashMap> to this.folder)
    public void mapMerge(Folder folder) {
        boolean copy = false;

        if (folder.getFolder().size() < 1 || this.folder.getFolder().size() < 1) {
            this.folder.getFolder().putAll(folder.getFolder());
        } else {
            for (Map.Entry<User, ArrayList<String>> entry : folder.getFolder().entrySet()) {
                User user = entry.getKey();
                ArrayList<String> userEmails = entry.getValue();
                for (int i = 0; i < userEmails.size(); i++) {
                    User keyUser = this.findByEmail(userEmails.get(i));
                    if (keyUser != null) {
                        removeDuplicates(userEmails, this.folder.getFolder().get(keyUser));
                        System.out.println("Something has been copied");
                        copy = true;
                        break;
                    }
                }
                if (!copy) {
                    this.folder.getFolder().put(user, userEmails);
                }
                copy = false;
            }
        }
    }

    //Show users and emails
    public void printOut() {
        System.out.println();
        for (Map.Entry<User, ArrayList<String>> entry : folder.getFolder().entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
    }

    //find folder by name
    public Folder findFolderByName(String name) {
        for (Folder folder : getFolderList()) {
            if (folder.getName().equals(name)) {
                return folder;
            }
        }
        return null;
    }

    //checkIfUserExist
    public boolean isUserExist(String name) {
        for (Map.Entry<User, ArrayList<String>> entry : folder.getFolder().entrySet()) {
            User usr = entry.getKey();
            if (usr.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //copy emails without duplicates
    private void removeDuplicates(ArrayList<String> emailListOne,
                                               ArrayList<String> emailListTwo) {
        for (String email : emailListOne) {
            if (!emailListTwo.contains(email)) {
                emailListTwo.add(email);
            }
        }
    }

        public static ArrayList<Folder> getFolderList() {
        return LIST;
    }
}
