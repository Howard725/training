package cn.edu.xxx.howard.hwoj.test;

import cn.edu.xxx.howard.hwoj.LongestIncreasingSequenceResolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/2.
 */
public class TestLongestIncreasingSequenceResolver {

    @Test
    public void testCase00() {
        LongestIncreasingSequenceResolver sequence = new LongestIncreasingSequenceResolver();
//        int[] input = new int[]{1, 11, 3, 13, 5, 15, 7, 27, 9};
        int[] input = new int[]{5, 6, 7, 1, 2, 8};
        Assert.assertEquals(4, sequence.getLengthOfSequence(input));
    }
}
