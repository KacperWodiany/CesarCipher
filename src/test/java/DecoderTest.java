import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DecoderTest {
    private static final int SHIFT = 3;
    private static Decoder decoder;

    @BeforeClass
    public static void beforeClass(){
        CodingDictionary dictionary = new CodingDictionary();
        decoder = new Decoder(dictionary, SHIFT);
    }

    @Test
    public void shouldDecodeDToAWhenShiftIsEqualToThree() {
        char testCharacter = 'D';

        char resultChar = decoder.code(testCharacter);

        assertThat(resultChar, is(equalTo('A')));
    }

    @Test
    public void shouldDecodeCToZWhenShiftIsEqualToThree() {
        char testCharacter = 'C';

        char resultChar = decoder.code(testCharacter);

        assertThat(resultChar, is(equalTo('Z')));
    }

    @Test
    public void shouldOnlyEncodeLetters() {
        String testLine = "~`!@#$%^&*()_ +-=1234567890{}[]:;'<,>.?/|";

        String resultLine = decoder.code(testLine);

        assertThat(resultLine, is(equalTo(testLine)));
    }

    @Test
    public void shouldDecodeZruogToWORLDWhenShiftIsEqualToThree() {
        String testLine = "Zruog";

        String resultLine = decoder.code(testLine);

        assertThat(resultLine, is(equalTo("WORLD")));
    }

}