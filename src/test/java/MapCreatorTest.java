import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MapCreatorTest {

    private static Object keyOne;
    private static Object keyTwo;
    private static List<Object> keys;

    private static Object valueOne;
    private static Object valueTwo;
    private static List<Object> values;

    @BeforeClass
    public static void beforeClass(){
        keyOne = new Object();
        keyTwo = new Object();
        keys = Arrays.asList(keyOne,keyTwo);

        valueOne = new Object();
        valueTwo = new Object();
        values = Arrays.asList(valueOne, valueTwo);
    }

    @Test
    public void shouldHandleZippingListOfObjects() {
        Map<Object, Object> resultMap = MapCreator.zipToMap(keys, values);

        final Map<Object, Object> correctResultMap = new HashMap<>();
        correctResultMap.put(keyOne, valueOne);
        correctResultMap.put(keyTwo, valueTwo);
        assertThat(resultMap, is(equalTo(correctResultMap)));
    }


}