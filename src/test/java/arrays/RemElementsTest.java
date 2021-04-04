package arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemElementsTest {
    @Test
    public void collectNewArray() {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[] rsl = RemElements.collectNewArray(data, 3);
        int[] expected = {1, 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 16};
        assertThat(rsl, is(expected));
    }
}