package cn.edu.xxx.howard.traning;

import com.google.common.collect.Table;

/**
 * Created by wanghoward on 17/4/30.
 */
public interface ShortestPathSearcher {
    int getShortestDistance(Table<String, String, Integer> distances, String start, String end);
}
