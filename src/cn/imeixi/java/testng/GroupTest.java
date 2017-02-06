package cn.imeixi.java.testng;

import org.testng.annotations.Test;

/**
 * Created by zhengaihua on 2017/2/3.
 */
public class GroupTest {
    @Test(groups = {"systemtest"})
    public void testLogin(){
        System.out.println("this is test logIn in systemtest Group");
    }

    @Test(groups = {"functiontest"})
    public void testOpenPage(){
        System.out.println("this is test open Page in functiontest Group");
    }
}
