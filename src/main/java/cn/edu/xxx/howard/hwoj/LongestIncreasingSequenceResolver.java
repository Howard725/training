package cn.edu.xxx.howard.hwoj;

/**
 * Created by Administrator on 2017/5/2.
 */
public class LongestIncreasingSequenceResolver {

    private int[] lengthOfSequence;

    public int getLengthOfSequence(int[] data) {
        initRecords(data.length);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] >= data[j]) {
                    lengthOfSequence[i] = max(lengthOfSequence[j] + 1, lengthOfSequence[i]);
                }
            }
        }

        return lengthOfSequence[data.length - 1];
    }

    private int max(int value0, int value1) {
        return value0 > value1 ? value0 : value1;
    }

    private void initRecords(int length) {
        lengthOfSequence = new int[length];
        for (int i = 0; i < length; i++) {
            lengthOfSequence[i] = 1;
        }
    }
}
