package cn.edu.xxx.howard.traning;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by Administrator on 2017/5/2.
 */
public class FloydSearcher implements ShortestPathSearcher {

    private Table<String, String, PathRecord> shortestDistances = null;

    public int getShortestDistance(Table<String, String, Integer> distances, String start, String end) {
        if (null == shortestDistances) {
            //init records
            shortestDistances = HashBasedTable.create();
            for (String i : distances.rowKeySet()) {
                for (String j : distances.columnKeySet()) {
                    if (i.equals(j)) {
                        shortestDistances.put(i, j, new PathRecord(0, null));
                    } else if (null != distances.get(i, j)) {
                        shortestDistances.put(i, j, new PathRecord(distances.get(i, j), i));
                    }
                }
            }

            //calculate shortestDistance
            for (String k : shortestDistances.rowKeySet()) {
                for (String i : shortestDistances.rowKeySet()) {
                    for (String j : shortestDistances.columnKeySet()) {
                        if (null != shortestDistances.get(i, k) && null != shortestDistances.get(k, j)) {
                            PathRecord oldPath = shortestDistances.get(i, j);
                            Integer newDistance = shortestDistances.get(i, k).distance
                                    + shortestDistances.get(k, j).distance;
                            if (oldPath == null || newDistance < oldPath.distance) {
                                shortestDistances.put(i, j, new PathRecord(newDistance, k));
                            }
                        }
                    }
                }
            }
        }

//        System.out.println(getShortestPath(start, end));
        return shortestDistances.get(start, end).distance;
    }

    private class PathRecord {
        int distance;
        String previous;

        public PathRecord(int distance, String previous) {
            this.distance = distance;
            this.previous = previous;
        }
    }

    /*
    //最短路径打印不完整
    private String getShortestPath(String start, String end){
        StringBuilder pathBuilder = new StringBuilder();
        String name = end;

        while (null != name){
            pathBuilder.insert(0, "->" + name);
            name = shortestDistances.get(start, name).previous;
        }
        pathBuilder.delete(0, 2);

        return pathBuilder.toString();
    }
    */

}
