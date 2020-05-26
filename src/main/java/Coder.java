import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Coder {

    protected CodingDictionary dictionary;
    protected Map<Character, Character> codingMap;

    public String code(String line){
        List<Character> characters =
                CharacterCollector.format(line);
        List<Character> encodedCharacters = new ArrayList<>();
        for(Character character : characters){
            encodedCharacters
                    .add(code(character));
        }
        return CharacterCollector.merge(encodedCharacters);
    }

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


}
