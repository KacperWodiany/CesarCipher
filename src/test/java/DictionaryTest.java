
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class DictionaryTest {

    private static final char FIRST_CHARACTER = 'A';
    private static final char LAST_CHARACTER = 'Z';
    private static Dictionary dictionary;

    @BeforeClass
    public static void beforeClass(){
        dictionary = new Dictionary(FIRST_CHARACTER, LAST_CHARACTER);
    }

    private List<Integer> getCorrectCodes(){
        return IntStream
                .rangeClosed(0,LAST_CHARACTER - FIRST_CHARACTER)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> getAllCodesFromCharacters(){
        final List<Integer> codes = new ArrayList<>();
        final List<Character> characters = dictionary.getContent();

        for(Character character : characters){
            codes.add(dictionary.getCodeOf(character));
        }

        return codes;
    }

    private List<Character> getAllCharactersFromCodes(){
        final List<Character> characters = new ArrayList<>();
        final List<Integer> correctCodes = getCorrectCodes();

        for(Integer code : correctCodes){
            characters.add(dictionary.getCharacterFrom(code));
        }

        return characters;
    }

    @Test
    public void codesShouldMatchCharactersIndexesInDictionary(){
        final List<Integer> expectedCodes = getCorrectCodes();

        final List<Integer> resultCodes = getAllCodesFromCharacters();

        assertThat(resultCodes, is(equalTo(expectedCodes)));
    }

    @Test
    public void charactersShouldMatchCharactersInDictionary(){
        final List<Character> expectedCharacters = dictionary.getContent();

        final List<Character> resultCharacters = getAllCharactersFromCodes();

        assertThat(resultCharacters, is(equalTo(expectedCharacters)));
    }




}