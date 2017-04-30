import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by wanghoward on 17/4/30.
 */
public class TestShortestPathSearcher {

    private Table<String, String, Integer> distances = null;

    @BeforeClass
    public void initDistances() {

        distances = HashBasedTable.create();

        distances.put("S0", "S1", 800);
        distances.put("S1", "S2", 2168);
        distances.put("S2", "S3", 2098);
        distances.put("S3", "S4", 2165);
        distances.put("S4", "S5", 1500);
        distances.put("S5", "S6", 1345);
        distances.put("S6", "S7", 1567);
        distances.put("S7", "S8", 1897);

    }

    @Test
    public void testDijkstraSearcher() {

    }

}
