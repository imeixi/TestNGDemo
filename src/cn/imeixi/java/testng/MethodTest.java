package cn.imeixi.java.testng;

import org.testng.annotations.*;

/**
 * Created by zhengaihua on 2017/2/3.
 */
public class MethodTest {

    @BeforeSuite
    public void beforeSuite(){
//      设置系统属性
//      System.setProperty("file.encoding","utf-8");
        System.out.println("this is beforeSuite");
        System.out.println(System.getProperty("file.encoding"));
    }

    @BeforeTest
    public  void beforeTest(){
        System.out.println("this is beforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("this is before class");
    }

    @BeforeGroups
    public void beforeGroup(){
        System.out.println("this is beforeGroups");
    }

    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("this is beforeMethod");
    }

    @Test
    public void TestNGLearn1(){
        System.out.println("This is TestNG test case1");
    }
    @Test
    public void TestNGLearn2(){
        System.out.println("This is TestNG test case2");
    }
    @Test
    public void TestNGLearn3(){
        System.out.println("This is TestNG test case3");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("this is afterMethod");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("this is afterGroups");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("this is afterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("this is aftersuite");
    }
}
