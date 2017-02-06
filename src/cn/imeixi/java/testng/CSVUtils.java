package cn.imeixi.java.testng;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengaihua on 2017/2/4.
 */
public class CSVUtils {
    //读取CSV文件的静态方法，使用CSV文件的绝对文件路径作为函数参数
    public static Object[][] getDataProvider(String csvFilePath) {
        List<Object[]> record = new ArrayList<>();
        String line;
        BufferedReader bufferedReader = null;
        try {
            //设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath),"UTF-8"));

            //忽略第一行
            bufferedReader.readLine();
            //遍历读取文件中除第一行外的其他所有内容并存储在名为records的ArrayList中，每一行records中存储的对象为一个String数组
            while ((line = bufferedReader.readLine()) != null) {
                String[] field = line.split(",");
                record.add(field);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件对象
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //将存储测试数据的List转换为一个Object的二维数组
        Object[][] results = new Object[record.size()][];
        for(int i = 0; i < results.length; i++){
            results[i] = record.get(i);
        }

        return results;
    }

    public static void writeToCSV(){
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testData.csv"), "UTF-8"));
            bufferedWriter.write("name");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
