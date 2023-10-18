import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        int pivotIndex = input.size() / 2;
        int pivot = input.get(pivotIndex);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (i == pivotIndex) {
                equal.add(input.get(i));
            } else if (input.get(i) < pivot) {
                less.add(input.get(i));
            } else {
                greater.add(input.get(i));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(sort(less));
        result.addAll(equal);
        result.addAll(sort(greater));

        return result;
    }
}
