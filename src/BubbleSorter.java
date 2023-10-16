import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Інтерфейс сортувальників
interface Sorter {
    ArrayList<Integer> sort(ArrayList<Integer> input);
}

// Реалізація сортування бульбашкою
class BubbleSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>(input);
        int n = result.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result.get(j) > result.get(j + 1)) {
                    // Swap
                    Collections.swap(result, j, j + 1);
                }
            }
        }
        return result;
    }
}