import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShifterTest {

    // TODO: Write tests using generics

    private final static int SHIFT_ONE = 1;
    private final static int SHIFT_MINUS_ONE = -1;

    @Test
    public void shouldShift123To312WhenShiftIsOne() {
        List<Integer> collection = Arrays.asList(1, 2, 3);

        List<Integer> shiftedCollection =
                Shifter.getShiftedList(collection, SHIFT_ONE);

        assertThat(shiftedCollection, is(equalTo(Arrays.asList(3, 1, 2))));
    }

    @Test
    public void shouldShift123To231WhenShiftIsMinusOne() {
        List<Integer> collection = Arrays.asList(1, 2, 3);

        List<Integer> shiftedCollection =
                Shifter.getShiftedList(collection, SHIFT_MINUS_ONE);

        assertThat(shiftedCollection, is(equalTo(Arrays.asList(2, 3, 1))));
    }

}