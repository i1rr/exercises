package usermanager;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void whenAddThenMergeAndFind() {
        Logic logic = Logic.getInstance();
        logic.add(new User("Test"), "test@test.ru");
        logic.addExtraEmail("test2@test.ru", logic.findByEmail("test@test.ru").getName());
        logic.add(new User("Test3"), "test3@test.ru");
        Folder folder = new Folder("Test");
        Logic.getFolderList().add(folder);
        logic.setFolder(folder);
        logic.add(new User("Gosha"), "gosha@yandex.ru");
        logic.addExtraEmail("test@test.ru", logic.findByEmail("gosha@yandex.ru").getName());
        logic.addExtraEmail("test3@test.ru", logic.findByEmail("gosha@yandex.ru").getName());
        logic.add(new User("OtherOne"), "other1@one.com");
        logic.addExtraEmail("other2@one.com", logic.findByEmail("other1@one.com").getName());
        logic.mapMerge(Logic.getFolderList().get(0));
        logic.printOut();
        assertThat(logic.findByEmail("test@test.ru").getName(), is("Gosha"));
        assertThat(logic.findByEmail("test2@test.ru").getName(), is("Gosha"));
        assertThat(logic.findByEmail("test3@test.ru").getName(), is("Gosha"));
    }
}