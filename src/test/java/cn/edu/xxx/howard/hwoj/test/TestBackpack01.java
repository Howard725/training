package cn.edu.xxx.howard.hwoj.test;

import cn.edu.xxx.howard.hwoj.Backpack01Resolver;
import cn.edu.xxx.howard.hwoj.GoodsItem;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class TestBackpack01 {

    private static Backpack01Resolver resolver;
    private static List<GoodsItem> goodsItems;

    @BeforeClass
    public static void setUpBeforeClass() {
        resolver = new Backpack01Resolver();
        goodsItems = new ArrayList<GoodsItem>() {{
            add(new GoodsItem("a", 2, 6));
            add(new GoodsItem("b", 2, 3));
            add(new GoodsItem("c", 6, 5));
            add(new GoodsItem("d", 5, 4));
            add(new GoodsItem("e", 4, 6));
        }};
    }

    @Test
    public void testCase00() {
        Assert.assertEquals(15, resolver.getMaxValue(goodsItems, 10));
        Assert.assertEquals(15, resolver.getMaxValue(goodsItems, 9));
        Assert.assertEquals(12, resolver.getMaxValue(goodsItems, 7));
    }

}
