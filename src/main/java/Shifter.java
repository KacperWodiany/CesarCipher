import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shifter {

    public static <T> List<T> getShiftedList(List<T> originalList, int shift) {
        List<T> shiftedList = new ArrayList<>(originalList);

        Collections.rotate(shiftedList,
                adjust(shift, originalList.size()));

        return shiftedList;
    }

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


}
