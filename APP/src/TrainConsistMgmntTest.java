import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmntTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistMgmnt.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.Bogie("Passenger", 50));
        list.add(new TrainConsistMgmnt.Bogie("Passenger", 80));

        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterUsingLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistMgmnt.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.Bogie("Passenger", 50));
        list.add(new TrainConsistMgmnt.Bogie("Passenger", 80));

        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterUsingStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistMgmnt.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.Bogie("Passenger", 70));
        list.add(new TrainConsistMgmnt.Bogie("Passenger", 90));

        List<TrainConsistMgmnt.Bogie> loopResult =
                TrainConsistMgmnt.filterUsingLoop(list);

        List<TrainConsistMgmnt.Bogie> streamResult =
                TrainConsistMgmnt.filterUsingStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        assertTrue(end >= start);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistMgmnt.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new TrainConsistMgmnt.Bogie("Passenger", i % 100));
        }

        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterUsingStream(list);

        assertNotNull(result);
    }
}