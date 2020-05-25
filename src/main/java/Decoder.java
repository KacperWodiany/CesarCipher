public class Decoder extends Coder{

    public Decoder(CodingDictionary dictionary, int shift) {
        super.dictionary = dictionary;
        super.codingMap = dictionary.createCodingMap(-shift);
    }
}
