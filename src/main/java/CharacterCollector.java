import java.util.List;
import java.util.stream.Collectors;


public class CharacterCollector {

    public static List<Character> format(String line){
        return split(
                prepare(line));
    }

    public static List<Character> split(String line){
        return line
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    public static String prepare(String line){
        return line
                .trim()
                .toUpperCase();
    }

    public static String merge(List<Character> characters){
        StringBuilder lineBuilder = new StringBuilder();
        for(Character character : characters){
            lineBuilder.append(character);
        }
        return lineBuilder.toString();
    }
}
