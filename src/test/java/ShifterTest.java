import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShifterTest {

    private final static int SHIFT_ONE = 1;
    private final static int SHIFT_MINUS_ONE = -1;
    private static List<Integer> collection;

    @BeforeClass
    public static void beforeClass(){
        collection = Arrays.asList(1, 2, 3);
    }

    @Test
    public void shouldShift123To312WhenShiftIsOne() {
        List<Integer> shiftedCollection =
                Shifter.shift(collection, SHIFT_ONE);

        assertThat(shiftedCollection, is(equalTo(Arrays.asList(3, 1, 2))));
    }

    @Test
    public void shouldShift123To231WhenShiftIsMinusOne() {
        List<Integer> shiftedCollection =
                Shifter.shift(collection, SHIFT_MINUS_ONE);

        assertThat(shiftedCollection, is(equalTo(Arrays.asList(2, 3, 1))));
    }
}