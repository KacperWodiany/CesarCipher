import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MapCreatorTest {

    // TODO: Write tests using generics

    @Test
    public void zipToMap() {
        final List<Integer> keys = Arrays.asList(1,2);
        final List<Character> values = Arrays.asList('a', 'b');
        final Map<Integer, Character> correctResultMap = new HashMap<>();
        correctResultMap.put(1, 'a');
        correctResultMap.put(2, 'b');

        Map<Integer, Character> resultMap = MapCreator.zipToMap(keys, values);

        assertThat(resultMap, is(equalTo(correctResultMap)));
    }
}