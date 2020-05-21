import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class LineReaderTest {

    @Test
    public void shouldReturnSentenceInUpperCase() {
        String testLine = "TestLine";

        String resultLine = LineReader.prepare(testLine);

        assertThat(resultLine, is(equalTo("TESTLINE")));
    }

    @Test
    public void shouldRemoveLeadingAndTrailingWhitespaces(){
        String testLine = "    TESTLINE    ";

        String resultLine = LineReader.prepare(testLine);

        assertThat(resultLine, is(equalTo("TESTLINE")));
    }

    @Test
    public void shouldSplitLineToCollectionOfCharacters(){
        String testLine = "abc";

        List<Character> resultCollection = LineReader.split(testLine);

        assertThat(resultCollection,
                is(equalTo(Arrays.asList('a', 'b', 'c'))));
    }

    @Test
    public void shouldMergeCollectionsOfCharactersToWholeLine(){
        List<Character> testCharacters =
                new ArrayList<>(Arrays.asList('a', 'b', 'c'));

        String resultLine = LineReader.merge(testCharacters);

        assertThat(resultLine, is(equalTo("abc")));
    }

}