package cn.imeixi.java.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by zhengaihua on 2017/2/3.
 */
public class ParameterTest {

    @Test(enabled = false)
    @Parameters("username")
    public void testParameters(String username){
        System.out.println("this is use parameters annotation");
        System.out.println("username: " + username);
    }

    @Test
    @Parameters({"username","password"})
    public void testParameters(String args1,String args2){
        System.out.println("this is use parameters annotation");
        System.out.println("username: " + args1);
        System.out.println("password: " + args2);
    }

    @DataProvider(name = "user")
    public Object[][] Users(){
        return new Object[][]{
                {"xiaoming",12,"male","student"},
                {"laowang",42,"male","driver"},
                {"xiaoling",21,"female","waiter"},
                {"xiaoli",32,"female","officer"},
        };
    }

    @Test(dataProvider = "user",groups = "UItest")
    public void userInfo(String name,int age,String sex,String profession ){
        System.out.println("parameterTest **************");
        System.out.println("Name: " + name + " age: " + age + " sex: " + sex + " profession: " + profession );
    }

    @Test(dataProvider = "datafromcsv",dataProviderClass = DataProviderByCSV.class)
    public void dataFromCsv(String name,String age,String sex,String profession ){
        System.out.println("Name: " + name + " age: " + age + " sex: " + sex + " profession: " + profession );
    }


}
