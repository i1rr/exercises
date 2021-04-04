import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InitialisationTest {
  @Test
    public void justTest() {
      assertThat(new Initialisation().init(), is("Initialisation successful"));
  }
}