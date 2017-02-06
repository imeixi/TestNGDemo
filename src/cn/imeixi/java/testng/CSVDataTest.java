package cn.imeixi.java.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhengaihua on 2017/2/4.
 */
public class CSVDataTest {
    @DataProvider(name="num")
    public Iterator<Object[]> Numbers() throws IOException {
        return new CSVData("add.csv");
    }

    @Test (dataProvider="num")
    public void testAdd(Map<String, String> data){
        float num1=Float.parseFloat(data.get("n1"));
        float num2=Float.parseFloat(data.get("n2"));
        float expectedResult=Float.parseFloat(data.get("r1"));
        Float actual=num1 + num2;
        Assert.assertEquals(actual, expectedResult);
    }
}
