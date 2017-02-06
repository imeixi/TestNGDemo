package cn.imeixi.java.testng;

import org.testng.annotations.Test;

/**
 * Created by zhengaihua on 2017/2/3.
 */
public class DependsTest {
    @Test
    public void stepOne(){
        System.out.println("this is step one,others must depend on this");
    }

    @Test
    public void stepTwo(){
        System.out.println("this is step Two");
    }

    @Test(dependsOnMethods = {"stepOne","stepTwo"})
    public void testMessage(){
        System.out.println("this is test message");
    }
}
