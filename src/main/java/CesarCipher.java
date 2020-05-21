public class CesarCipher {

    public static void main(String[] args){
        String line = "Hello World!";
        Dictionary dictionary = new Dictionary('A', 'Z');
        Encoder cesarEncoder = new Encoder(dictionary);
        String encodedLine = cesarEncoder.encode(line);
        System.out.println(encodedLine);
    }
}
