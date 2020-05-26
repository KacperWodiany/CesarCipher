import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shifter {

    private static <T> int adjust(int shift, int size){
        int adjustedShift;
        if(shift >= 0){
            adjustedShift =  shift % size;
        } else {
            adjustedShift =
                    size + (shift % size);
        }
        return adjustedShift;
    }

    public static <T> List<T> shift(List<T> list, int shift) {
        List<T> shiftedList = new ArrayList<>(list);
        Collections
                .rotate(shiftedList,
                        adjust(shift, list.size()));
        return shiftedList;
    }




}
