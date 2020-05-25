public class Encoder extends Coder{

    public Encoder(CodingDictionary dictionary, int shift) {
        super.dictionary = dictionary;
        super.codingMap = dictionary.createCodingMap(shift);
    }
}
