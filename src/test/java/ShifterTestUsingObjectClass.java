import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShifterTestUsingObjectClass {

    private final static int SHIFT_ONE = 1;
    private final static int SHIFT_MINUS_ONE = -1;
    private static Object objectOne;
    private static Object objectTwo;
    private static Object objectThree;
    private static List<Object> objects;

    @BeforeClass
    public static void beforeClass(){
        objectOne = new Object();
        objectTwo = new Object();
        objectThree = new Object();
        objects = Arrays.asList(
                objectOne, objectTwo, objectThree);
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