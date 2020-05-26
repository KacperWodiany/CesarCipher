import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodingDictionary {
    private final List<Character> content =
            new ArrayList<>();
    private static final char DEFAULT_FIRST_CHAR = 'A';
    private static final char DEFAULT_LAST_CHAR = 'Z';

    public CodingDictionary(char firstCharacter, char lastCharacter) {
        char currentCharacter = firstCharacter;
        while(currentCharacter <= lastCharacter){
            content.add(currentCharacter++);
        }
    }

    public CodingDictionary() {
        char currentCharacter = DEFAULT_FIRST_CHAR;
        while(currentCharacter <= DEFAULT_LAST_CHAR){
            content.add(currentCharacter++);
        }
    }

    public boolean contains(char character){
        return content
                .contains(character);
    }

    public Map<Character, Character> createCodingMap(int shift){
        List<Character> shiftedContent = Shifter.shift(content, shift);
        return MapCreator.zipToMap(shiftedContent, content);
    }
}
