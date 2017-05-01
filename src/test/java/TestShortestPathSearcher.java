import cn.edu.xxx.howard.traning.DijkstraSearcher;
import cn.edu.xxx.howard.traning.ShortestPathSearcher;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by wanghoward on 17/4/30.
 */
public class TestShortestPathSearcher {

    private static Table<String, String, Integer> distances = null;

    @BeforeClass
    public static void initDistances() {

        distances = HashBasedTable.create();

        //Line 0
        distances.put("S0", "S1", 800);
        distances.put("S1", "S2", 2168);
        distances.put("S2", "S3", 2098);
        distances.put("S3", "S4", 2165);
        distances.put("S4", "S5", 1500);
        distances.put("S5", "S6", 1345);
        distances.put("S6", "S7", 1567);
        distances.put("S7", "S8", 1897);

        distances.put("S1", "S0", 800);
        distances.put("S2", "S1", 2168);
        distances.put("S3", "S2", 2098);
        distances.put("S4", "S3", 2165);
        distances.put("S5", "S4", 1500);
        distances.put("S6", "S5", 1345);
        distances.put("S7", "S6", 1567);
        distances.put("S8", "S7", 1897);

        //Line 1
        distances.put("S10", "S11", 900);
        distances.put("S11", "S12", 1168);
        distances.put("S12", "S5", 2198);
        distances.put("S5", "S14", 2000);
        distances.put("S14", "S15", 1600);
        distances.put("S15", "S16", 1485);
        distances.put("S16", "S17", 1600);
        distances.put("S17", "S18", 1888);

        distances.put("S18", "S17", 1888);
        distances.put("S17", "S16", 1600);
        distances.put("S16", "S15", 1485);
        distances.put("S15", "S14", 1600);
        distances.put("S14", "S5", 2000);
        distances.put("S5", "S12", 2198);
        distances.put("S12", "S11", 1168);
        distances.put("S11", "S10", 900);

        //Line 2
        distances.put("S20", "S21", 1100);
        distances.put("S21", "S22", 1238);
        distances.put("S22", "S23", 1998);
        distances.put("S23", "S15", 1800);
        distances.put("S15", "S25", 1700);
        distances.put("S25", "S26", 1585);
        distances.put("S26", "S27", 1405);
        distances.put("S27", "S28", 1822);

        distances.put("S28", "S27", 1822);
        distances.put("S27", "S26", 1405);
        distances.put("S26", "S25", 1585);
        distances.put("S25", "S15", 1700);
        distances.put("S15", "S23", 1800);
        distances.put("S23", "S22", 1998);
        distances.put("S22", "S21", 1238);
        distances.put("S21", "S20", 1100);

        //Line 3
        distances.put("S30", "S31", 1110);
        distances.put("S31", "S32", 1338);
        distances.put("S32", "S2", 1568);
        distances.put("S2", "S22", 1450);
        distances.put("S22", "S35", 1680);
        distances.put("S35", "S36", 1345);
        distances.put("S36", "S37", 1555);
        distances.put("S37", "S38", 1682);
        distances.put("S37", "S39", 1682);

        distances.put("S39", "S38", 1682);
        distances.put("S38", "S37", 1682);
        distances.put("S37", "S36", 1555);
        distances.put("S36", "S35", 1345);
        distances.put("S35", "S22", 1680);
        distances.put("S22", "S2", 1450);
        distances.put("S2", "S32", 1568);
        distances.put("S32", "S31", 1338);
        distances.put("S31", "S30", 1110);

    }

    @Test
    public void testDijkstraSearcher() {
        ShortestPathSearcher searcher = new DijkstraSearcher();
//        Assert.assertEquals(5248, searcher.getShortestDistance(distances, "S2", "S15"));
        Assert.assertEquals(9264, searcher.getShortestDistance(distances, "S30", "S15"));
//        Assert.assertEquals( 8154, searcher.getShortestDistance(distances, "S31", "S15"));

    }

}
