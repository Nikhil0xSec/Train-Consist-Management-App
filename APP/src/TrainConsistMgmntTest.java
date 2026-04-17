import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistMgmntTest {

    private boolean linearSearch(String[] bogieIds, String searchId) {
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(ids, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(linearSearch(ids, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(linearSearch(ids, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG550"};
        assertTrue(linearSearch(ids, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(linearSearch(ids, "BG101"));
    }
}