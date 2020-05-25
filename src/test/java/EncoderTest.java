import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EncoderTest {
    private static final int SHIFT = 3;
    private static Encoder encoder;

    @BeforeClass
    public static void beforeClass(){
        CodingDictionary dictionary = new CodingDictionary();
        encoder = new Encoder(dictionary, SHIFT);
    }

    @Test
    public void shouldEncodeAToDWhenShiftIsEqualToThree() {
        char testCharacter = 'A';

        char resultChar = encoder.code(testCharacter);

        assertThat(resultChar, is(equalTo('D')));
    }

    @Test
    public void shouldEncodeZToCWhenShiftIsEqualToThree() {
        char testCharacter = 'Z';

        char resultChar = encoder.code(testCharacter);

        assertThat(resultChar, is(equalTo('C')));
    }

    @Test
    public void shouldOnlyEncodeLetters() {
        String testLine = "~`!@#$%^&*()_ +-=1234567890{}[]:;'<,>.?/|";

        String resultLine = encoder.code(testLine);

        assertThat(resultLine, is(equalTo(testLine)));
    }

    @Test
    public void shouldEncodeWorldToZRUOGWhenShiftIsEqualToThree() {
        String testLine = "World";

        String resultLine = encoder.code(testLine);

        assertThat(resultLine, is(equalTo("ZRUOG")));
    }
}