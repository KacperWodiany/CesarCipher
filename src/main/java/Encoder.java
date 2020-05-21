import java.util.ArrayList;
import java.util.List;

public class Encoder{

    private final static int SHIFT = 3;
    private final Dictionary dictionary;

    public Encoder(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public char encode(char character){
        char encodedCharacter;

        if(!isEncodable(character)) {
            encodedCharacter = character;
        } else {
            encodedCharacter = shift(character);
        }

        return encodedCharacter;
    }

    public String encode(String line){
        List<Character> originalCharacters =
                prepareCharCollectionForCoding(line);
        List<Character> encodedCharacters = new ArrayList<>();

        for(Character character : originalCharacters){
            encodedCharacters
                    .add(encode(character));
        }

        return LineReader.merge(encodedCharacters);
    }

    public boolean isEncodable(char character){
        return dictionary
                .getContent()
                .contains(character);
    }

    private char shift(char character){
        int characterCode = dictionary.getCodeOf(character) + SHIFT;
        characterCode %= dictionary.getSize();
        return dictionary.getCharacterFrom(characterCode);
    }

    private List<Character> prepareCharCollectionForCoding(String line){
        String preparedLine = LineReader.prepare(line);
        return LineReader.split(preparedLine);
    }
}
