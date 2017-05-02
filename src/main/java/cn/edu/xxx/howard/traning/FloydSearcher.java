package cn.edu.xxx.howard.traning;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by Administrator on 2017/5/2.
 */
public class FloydSearcher implements ShortestPathSearcher {

    private Table<String, String, Integer> shortestDistances = null;

    public int getShortestDistance(Table<String, String, Integer> distances, String start, String end) {
        if (null == shortestDistances) {
            //init records
            shortestDistances = HashBasedTable.create();
            for (String i : distances.rowKeySet()) {
                for (String j : distances.columnKeySet()) {
                    if (i.equals(j)) {
                        shortestDistances.put(i, j, 0);
                    } else if (null != distances.get(i, j)) {
                        shortestDistances.put(i, j, distances.get(i, j));
                    }
                }
            }

            //calculate shortestDistance
            for (String k : shortestDistances.rowKeySet()) {
                for (String i : shortestDistances.rowKeySet()) {
                    for (String j : shortestDistances.columnKeySet()) {
                        if (null != shortestDistances.get(i, k) && null != shortestDistances.get(k, j)) {
                            Integer oldDistance = shortestDistances.get(i, j);
                            Integer newDistance = shortestDistances.get(i, k) + shortestDistances.get(k, j);
                            if (oldDistance == null || newDistance < oldDistance) {
                                shortestDistances.put(i, j, newDistance);
                            }
                        }
                    }
                }
            }
        }
        return shortestDistances.get(start, end);
    }

}
