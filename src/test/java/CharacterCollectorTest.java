import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class CharacterCollectorTest {

    @Test
    public void shouldReturnSentenceInUpperCase() {
        String testLine = "TestLine";

        String resultLine = CharacterCollector.prepare(testLine);

        assertThat(resultLine, is(equalTo("TESTLINE")));
    }

    @Test
    public void shouldRemoveLeadingAndTrailingWhitespaces(){
        String testLine = "    TESTLINE    ";

        String resultLine = CharacterCollector.prepare(testLine);

        assertThat(resultLine, is(equalTo("TESTLINE")));
    }

    @Test
    public void shouldSplitLineToCollectionOfCharacters(){
        String testLine = "abc";

        List<Character> resultCollection =
                CharacterCollector.split(testLine);

        assertThat(resultCollection,
                is(equalTo(Arrays.asList('a', 'b', 'c'))));
    }

    @Test
    public void shouldMergeCollectionsOfCharactersToWholeLine(){
        List<Character> testCharacters =
                new ArrayList<>(Arrays.asList('a', 'b', 'c'));

        String resultLine = CharacterCollector.merge(testCharacters);

        assertThat(resultLine, is(equalTo("abc")));
    }

}