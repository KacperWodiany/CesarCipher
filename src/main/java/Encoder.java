public class Encoder extends Coder{

    // TODO: Test Encoder class

    public Encoder(CodingDictionary dictionary, int shift) {
        super.dictionary = dictionary;
        super.codingMap = dictionary.createCodingMap(shift);
    }
}
