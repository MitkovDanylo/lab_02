import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Інтерфейс сортувальників

class ShellSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>(input);
        int n = result.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = result.get(i);
                int j;
                for (j = i; j >= gap && result.get(j - gap) > temp; j -= gap) {
                    result.set(j, result.get(j - gap));
                }
                result.set(j, temp);
            }
        }
        return result;
    }
}
