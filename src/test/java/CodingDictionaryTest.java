
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CodingDictionaryTest {

    private static final char FIRST_CHARACTER = 'A';
    private static final char LAST_CHARACTER = 'C';
    private static final int SHIFT_ONE = 1;
    private static final int SHIFT_MINUS_ONE = -1;
    private static final int SHIFT_ZERO = 0;

    @Test
    public void setABCShouldContainA(){
        CodingDictionary codingDictionary =
                new CodingDictionary(FIRST_CHARACTER, LAST_CHARACTER);

        boolean result = codingDictionary.contains('A');

        assertThat(result, is(true));
    }

    @Test
    public void shouldMapABCToCABWhenShiftIsEqualToOne(){
        CodingDictionary codingDictionary =
                new CodingDictionary(FIRST_CHARACTER, LAST_CHARACTER);
        Map<Character, Character> correctCodingMap = new HashMap<>();
        correctCodingMap.put('A', 'C');
        correctCodingMap.put('B', 'A');
        correctCodingMap.put('C', 'B');

        Map<Character, Character> resultMap = codingDictionary.createCodingMap(SHIFT_ONE);

        assertThat(resultMap, is(equalTo(correctCodingMap)));
    }

    @Test
    public void shouldMapABCToBCAWhenShiftIsEqualToOne(){
        CodingDictionary codingDictionary =
                new CodingDictionary(FIRST_CHARACTER, LAST_CHARACTER);
        Map<Character, Character> correctCodingMap = new HashMap<>();
        correctCodingMap.put('A', 'B');
        correctCodingMap.put('B', 'C');
        correctCodingMap.put('C', 'A');

        Map<Character, Character> resultMap = codingDictionary.createCodingMap(SHIFT_MINUS_ONE);

        assertThat(resultMap, is(equalTo(correctCodingMap)));
    }
}