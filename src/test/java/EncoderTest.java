import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class EncoderTest {
    private final static int SHIFT = 3;
    private static final Dictionary DICTIONARY = new Dictionary('A', 'Z');
    private static Encoder encoder;

    @BeforeClass
    public static void beforeClass(){
        encoder = new Encoder(SHIFT, DICTIONARY);
    }

    @Test
    public void shouldEncodeAtoD(){
        char testCharacter = 'A';

        char encodedCharacter =
                encoder.encode(testCharacter);

        assertThat(encodedCharacter, is(equalTo('D')));
    }

    @Test
    public void shouldEncodeZToC(){
        char testCharacter = 'Z';

        char encodedCharacter =
                encoder.encode(testCharacter);

        assertThat(encodedCharacter, is(equalTo('C')));
    }

    @Test
    public void shouldEncodeAbcToDEF(){
        String testLine = "Abc";

        String encodedLine = encoder.encode(testLine);

        assertThat(encodedLine, is(equalTo("DEF")));
    }

    @Test
    public void shouldEncodexyzToCBD(){
        String testLine = "xyz";

        String encodedLine = encoder.encode(testLine);

        assertThat(encodedLine, is(equalTo("ABC")));
    }

    @Test
    public void shouldNotEncodeInterpunctionAndSpaces(){
        String testLine = "!@#$%^&*()_- ?/>.<,';:{}[]";

        String encodedLine = encoder.encode(testLine);

        assertThat(encodedLine, is(equalTo(testLine)));
    }

}