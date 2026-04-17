import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistMgmntTest {

    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        assertArrayEquals(expected, bubbleSort(input));
    }
}