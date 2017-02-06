package cn.imeixi.java.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by zhengaihua on 2017/2/4.
 */



//从CSV文件中读取每行中前2个逗号分割的中文词作为搜索框中输入的搜索关键词
//断言搜索结果页面是否包含CSV文件中每行的最后一个词汇的关键字
public class selenuimTest {
    private static WebDriver driver;
    @DataProvider(name="searchData")
    public static Object[][] data() throws IOException
    {
        return getSearchData("resources\\testData.csv");//获取CSV文件的测试数据
    }

    @Test(dataProvider="searchData",groups = "UItest")
    public void testSearch(String searchdata1,String searchdata2,String searchResult) {
        System.out.println("selenuimTest ***********");
        //打开sogou首页
        driver.get("http://www.sogou.com/");
        //输入搜索条件
        //从CSV文件中读取每行中前2个逗号分割的中文词作为搜索框中输入的搜索关键词,在两个搜索词中间增加一个空格
        driver.findElement(By.id("query")).sendKeys(searchdata1+" "+searchdata2);
        driver.findElement(By.id("query")).sendKeys(Keys.SHIFT,"webdriver");
        //单击搜索按钮
        driver.findElement(By.id("stb")).click();

        //使用显式等待方式，确认页面已经加载完成，页面底部的关键字"搜索帮助"已经显示在页面上
        (new WebDriverWait(driver,3)).until(new ExpectedCondition<Boolean>(){

            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("sogou_webhelp")).getText().contains("搜索帮助");
            }});

        //断言搜索结果页面是否包含CSV文件中每行的最后一个词汇的关键字
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }
    @BeforeMethod(groups = "UItest")
    public void beforeMethod() {
        //若无法打开Firefox浏览器，可设定Firefox浏览器的安装路径
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //打开Firefox浏览器
        driver=new FirefoxDriver();
        //设定等待时间为5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //打印当前编码格式
//      System.out.println("__________##########____________");
//      System.out.println(System.getProperty("file.encoding"));

    }

    @AfterMethod(groups = "UItest")
    public void afterMethod() {
        //关闭打开的浏览器
        driver.quit();
    }
    //读取CSV文件的静态方法，使用CSV文件的绝对文件路径作为函数参数
    public static Object[][] getSearchData(String FileNameroot) throws IOException{
        List<Object[]> records=new ArrayList<Object[]>();
        String record;
        //设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
        BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(FileNameroot),"UTF-8"));
        //忽略读取CSV文件的标题行（第一行）
        file.readLine();
        //遍历读取文件中除第一行外的其他所有内容并存储在名为records的ArrayList中，每一行records中存储的对象为一个String数组
        while((record=file.readLine())!=null){
            String fields[]=record.split(",");
            records.add(fields);
        }
        //关闭文件对象
        file.close();
        //将存储测试数据的List转换为一个Object的二维数组
        Object[][] results=new Object[records.size()][];
        //设置二位数组每行的值，每行是一个Object对象
        for(int i=0;i<records.size();i++){
            results[i]=records.get(i);
        }
        return results;
    }
}