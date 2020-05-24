import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodingDictionary {
    private final List<Character> content =
            new ArrayList<>();

    public CodingDictionary(char firstCharacter, char lastCharacter) {
        char currentCharacter = firstCharacter;

        while(currentCharacter <= lastCharacter){
            content.add(currentCharacter++);
        }
    }

    public boolean contains(char character){
        return content
                .contains(character);
    }

    public Map<Character, Character> createCodingMap(int shift){
        List<Character> shiftedContent = Shifter.getShiftedList(content, shift);
        return MapCreator.zipToMap(content, shiftedContent);
    }
}
