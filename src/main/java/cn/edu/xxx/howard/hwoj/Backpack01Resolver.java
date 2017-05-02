package cn.edu.xxx.howard.hwoj;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Backpack01Resolver {

    private int[][] calculateTable = null;
    private int MIN_VALUE = Integer.MIN_VALUE;

    public int getMaxValue(List<GoodsItem> goodsList, int capacity) {
        //入参检查
        if (null == goodsList || capacity <= 0) {
            return -1;
        }

        initCalculateTable(goodsList.size(), capacity);

        for (int j = 0; j <= capacity; j++) {
            for (int i = 1; i <= goodsList.size(); i++) {
                int valueWithCurrentItem = MIN_VALUE;
                int valueWithoutCurrentItem = MIN_VALUE;

                //装入当前货物
                if (j - goodsList.get(i - 1).getWeight() >= 0) {
                    valueWithCurrentItem = calculateTable[i - 1][j - goodsList.get(i - 1).getWeight()] + goodsList.get(i - 1).getValue();
                }

                //不装入当前货物
                valueWithoutCurrentItem = calculateTable[i - 1][j];

                calculateTable[i][j] = max(valueWithCurrentItem, valueWithoutCurrentItem);
            }
        }

        return calculateTable[goodsList.size()][capacity];
    }

    private int max(int value0, int value1) {
        return value0 > value1 ? value0 : value1;
    }

    private void initCalculateTable(int countOfGoods, int capacity) {
        calculateTable = new int[countOfGoods + 1][capacity + 1];
        for (int i = 0; i < countOfGoods + 1; i++) {
            calculateTable[i][0] = 0;
        }
        for (int i = 0; i < capacity + 1; i++) {
            calculateTable[0][i] = 0;
        }
    }
}
