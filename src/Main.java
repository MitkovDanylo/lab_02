import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println("Number of elements: " + count);
            ArrayList<Integer> input = generateRandomArray(count);
            for (SortingType type : SortingType.values()) {
                System.out.println("Sorting type: " + type);
                Sorter sorter = SorterFactory.getSorter(type);
                measureTimeAndPrintResult(input, sorter);
            }
        }
    }

    private static ArrayList<Integer> generateRandomArray(int count) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            array.add(random.nextInt(count));
        }
        return array;
    }

    private static void measureTimeAndPrintResult(ArrayList<Integer> input, Sorter sorter) {
        long startTime = System.nanoTime();
        ArrayList<Integer> sorted = sorter.sort(new ArrayList<>(input));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("Time taken: " + duration + " ms");
        System.out.println("Sorted array (first 50 elements): " + sorted.subList(0, Math.min(50, sorted.size())));
    }
}