package cn.imeixi.java.testng;

import org.testng.annotations.Test;

/**
 * Created by zhengaihua on 2017/2/3.
 */
public class ExceptionTest {

    @Test(expectedExceptions = IllegalArgumentException.class,expectedExceptionsMessageRegExp = "NullPoint")
    public void testException(){
        throw new IllegalArgumentException("NullPoint");
    }
}

