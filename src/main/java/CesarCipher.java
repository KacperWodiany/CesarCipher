public class CesarCipher {

    public static void main(String[] args){
        final String line = "Hello world!";
        System.out.println("Original: " + line);

        final CodingDictionary dict = new CodingDictionary();
        final int shift = 3;

        final Coder encoder = new Encoder(dict, shift);
        final String encodedLine = encoder.code(line);
        System.out.println("Encoded: " + encodedLine);

        final Coder decoder = new Decoder(dict, shift);
        final String decodedLine = decoder.code(encodedLine);
        System.out.println("Decoded: " + decodedLine);
    }
}
