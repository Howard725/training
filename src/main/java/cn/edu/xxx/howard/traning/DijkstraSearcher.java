package cn.edu.xxx.howard.traning;

import com.google.common.collect.Table;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;

/**
 * Created by wanghoward on 17/4/30.
 */
public class DijkstraSearcher implements ShortestPathSearcher {

    private final static int INF = Integer.MAX_VALUE;

    private Map<String, DijkstraItem> itemsMap = null;
    private Queue<DijkstraItem> itemsQueue = null;

    public int getShortestDistance(Table<String, String, Integer> distances, String start, String end) {

        initRecords(distances.rowKeySet());

        itemsMap.get(start).distance = 0;
        itemsQueue.add(itemsMap.get(start));

        for (; ; ) {
            DijkstraItem currentItem = null;
            while (!itemsQueue.isEmpty() && (currentItem == null || currentItem.known)) {
                currentItem = itemsQueue.poll();
            }
            if (null == currentItem) {
                break;
            }

            for (String neighbor : distances.row(currentItem.name).keySet()) {
                DijkstraItem neighborItem = itemsMap.get(neighbor);
                if (!neighborItem.known) {
                    int newDistance = distances.get(currentItem.name, neighbor) + currentItem.distance;
                    if (newDistance < neighborItem.distance) {
                        neighborItem.distance = newDistance;
                        itemsQueue.add(neighborItem);
                    }
                }
            }
        }

        return itemsMap.get(end).distance;
    }

    private void initRecords(Collection<String> points) {

        for (String point : points) {
            DijkstraItem item = new DijkstraItem(point);
            itemsMap.put(point, item);
            itemsQueue.add(item);
        }

    }

    private class DijkstraItem implements Comparable<DijkstraItem> {
        String name;
        boolean known;
        int distance;
        DijkstraItem previous;

        public DijkstraItem(String name) {
            this.name = name;
            known = false;
            distance = INF;
            previous = null;
        }

        public int compareTo(DijkstraItem o) {
            return this.distance < o.distance ? -1 : 1;
        }
    }
}
