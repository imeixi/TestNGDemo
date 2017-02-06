package cn.imeixi.java.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by zhengaihua on 2017/2/4.
 */
public class DataProviderByCSV {

    @DataProvider(name = "datafromcsv")
    public static Object[][] data() {
//        return getDataProvider("d:\\workspace\\data.csv");
        return CSVUtils.getDataProvider("resources\\data.csv");
    }

    @Test(dataProvider = "datafromcsv")
    public void dataFromCsv(String name,String age,String sex,String profession ){
        System.out.println("Name: " + name + " age: " + age + " sex: " + sex + " profession: " + profession );
    }
}
