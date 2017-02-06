package cn.imeixi.java.testng;

import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengaihua on 2017/2/4.
 */
public class CSVUtils2Test {
    /**
     * CSV导出
     *
     * @throws Exception
     */
    @Test
    public void exportCsv() {
        List<String> dataList = new ArrayList<String>();
        dataList.add("1,张三,男");
        dataList.add("2,李四,男");
        dataList.add("3,小红,女");
        boolean isSuccess = CSVUtils2.exportCsv(new File("resources\\csvUtils1.csv"), dataList);
        System.out.println(isSuccess);
    }

    /**
     * CSV导出
     *
     * @throws Exception
     */
    @Test
    public void importCsv() {
        List<String> dataList = CSVUtils2.importCsv(new File("resources\\csvUtils1.csv"));
        if (dataList != null && !dataList.isEmpty()) {
            for (String data : dataList) {
                System.out.println(data);
            }
        }
    }
}
