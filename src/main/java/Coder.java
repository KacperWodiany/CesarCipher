import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Coder {

    protected CodingDictionary dictionary;
    protected Map<Character, Character> codingMap;

    public char code(char character){
        char encodedCharacter;

        if(!dictionary.contains(character)) {
            encodedCharacter = character;
        } else {
            encodedCharacter =
                    codingMap.get(character);
        }

        return encodedCharacter;
    }

    public String code(String line){
        String preparedLine = LineReader.prepare(line);
        List<Character> originalCharacters =
                LineReader.split(preparedLine);

        List<Character> encodedCharacters = new ArrayList<>();

        for(Character character : originalCharacters){
            encodedCharacters
                    .add(code(character));
        }

        return LineReader.merge(encodedCharacters);
    }
}
