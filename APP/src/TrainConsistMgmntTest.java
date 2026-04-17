import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class TrainConsistMgmntTest {

    private boolean binarySearch(String[] ids, String key) {

        Arrays.sort(ids);

        int low = 0;
        int high = ids.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(ids[mid]);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(ids, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(binarySearch(ids, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(ids, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] ids = {};
        assertFalse(binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] ids = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(binarySearch(ids, "BG205"));
    }
}