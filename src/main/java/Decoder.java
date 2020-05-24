public class Decoder extends Coder{

    // TODO: Test Decoder class

    public Decoder(CodingDictionary dictionary, int shift) {
        super.dictionary = dictionary;
        super.codingMap = dictionary.createCodingMap(-shift);
    }
}
