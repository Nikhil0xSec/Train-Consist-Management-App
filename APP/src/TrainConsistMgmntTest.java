import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistMgmntTest {

    private boolean searchBogie(String[] bogieIds, String searchId) {

        if (bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }

        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] ids = {};
        assertThrows(IllegalStateException.class,
                () -> searchBogie(ids, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101", "BG205"};
        assertDoesNotThrow(() -> searchBogie(ids, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(searchBogie(ids, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertFalse(searchBogie(ids, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};
        assertTrue(searchBogie(ids, "BG101"));
    }
}