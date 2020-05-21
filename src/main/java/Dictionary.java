import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private final char firstCharacter;
    private final char lastCharacter;

    public Dictionary(char firstCharacter, char lastCharacter) {
        this.firstCharacter = firstCharacter;
        this.lastCharacter = lastCharacter;
    }

    public List<Character> getContent(){
        List<Character> dictionary = new ArrayList<>();
        char currentCharacter = firstCharacter;

        while(currentCharacter <= lastCharacter){
            dictionary.add(currentCharacter++);
        }

        return dictionary;
    }

    public int getSize(){
        return lastCharacter - firstCharacter + 1;
    }

    public int getCodeOf(char character){
        return  character - firstCharacter;
    }

    public char getCharacterFrom(int code){
        return (char) (code + firstCharacter);
    }


}
