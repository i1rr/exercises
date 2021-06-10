package usermanager;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void whenAndMergeAndPrintOut() {
        Logic mer = new Logic();
        mer.add(new User("Vasja"), "vasja@gmail.com");
        mer.add(new User("Kolja"), "kolja@gmail.com");
        mer.add(new User("Gleb"), "glebushka@job4j.ru");
        ArrayList<String> emails = new ArrayList<>();
        emails.add("kuniKing@gmail.com");
        emails.add("vasja@gmail.com");
        emails.add("basta@yandex.ru");
        ArrayList<String> emails2 = new ArrayList<>();
        emails2.add("kolja@gmail.com");
        emails2.add("kolombo@yandex.ru");
        emails2.add("boss@gmail.com");
        ArrayList<String> emails3 = new ArrayList<>();
        HashMap<User, ArrayList<String>> test = new HashMap<>();
        test.put(new User("Gogol"), emails);
        HashMap<User, ArrayList<String>> test2 = new HashMap<>();
        test2.put(new User("Batja"), emails2);

       // mer.mapMerge(test);
        //mer.mapMerge(test2);

        mer.printOut();
    }

//    @Test
//    public void whenAddToDataBaseAndFind() {
//        Logic mer = new Logic();
//        mer.add(new User("Vasja"), "vasja@gmail.com");
//        mer.add(new User("Kolja"), "kolja@gmail.com");
//        mer.add(new User("Gleb"), "glebushka@job4j.ru");
//        assertThat(mer.findByEmail("kolja@gmail.com"), is("Kolja"));
//    }
}