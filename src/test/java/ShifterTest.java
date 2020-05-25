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
    private static Object objectOne;
    private static Object objectTwo;
    private static Object objectThree;
    private static List<Object> objects;

    @BeforeClass
    public static void beforeClass(){
        collection = Arrays.asList(1, 2, 3);

        objectOne = new Object();
        objectTwo = new Object();
        objectThree = new Object();
        objects =
                Arrays.asList(objectOne, objectTwo, objectThree);
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

    @Test
    public void shouldHandleShiftToTheRightForListOfObjects(){
        List<Object> shiftedObjects =
                Shifter.shift(objects, SHIFT_ONE);

        assertThat(shiftedObjects, is(equalTo(Arrays.asList(objectThree, objectOne, objectTwo))));
    }

    @Test
    public void shouldHandleShiftToTheLeftForListOfObjects(){
        List<Object> shiftedObjects =
                Shifter.shift(objects, SHIFT_MINUS_ONE);

        assertThat(shiftedObjects, is(equalTo(Arrays.asList(objectTwo, objectThree, objectOne))));
    }

}