package com.example.demo.controller.exercise;

//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.*;

@Test(groups = "Yoka")
public class TestngGroups {
    @BeforeSuite
    public void bfSuite(){
        System.out.println("beforeSuite is running...");
    }

    @BeforeClass
    public void bfClass(){
        System.out.println("beforeClass is running...");
    }

    @BeforeTest(dependsOnGroups = "bfSuite")
    public void bfTest(){
        System.out.println("BeforeTest is running...");
    }

    @BeforeGroups
    public void bfGroups(){
        System.out.println("BeforeGroups is running...");
    }

    @BeforeMethod(alwaysRun = true,dependsOnGroups  = "bfSuite")
    public void bfMethod(){
        System.out.println("BeforeMethod is running...");
    }

    @Test
    public int helloWorldTest(){
        System.out.println("TestNGHelloWorld Test!");
        return 111;
    }


//    @DataProviderTest(name = "data")
    public Object[][] creatData(){
        return new Object[][]{
                {"xiaozheng",new Integer(24)},
                {"xiaoli",new Integer(25)}
        };
    }

    @Test(dataProvider = "data")
    public void verifyData(String n1,Integer n2){
        System.out.println("姓名："+ n1 + " 年龄："+ n2);
    }
    @Test
    @Parameters(value = "Java")
    public void helloWorldTest1(String str){

        System.out.println("TestNGHelloWorld Test1!" + str);
    }

    @AfterSuite
    public void afSuite(){
        System.out.println("AfterSuite is running...");
    }

    @AfterClass
    public void afClass(){
        System.out.println("AfterClass is running...");
    }

    @AfterTest
    public void afTest(){
        System.out.println("AfterTest is running...");
    }

    @AfterGroups
    public void afGroups(){
        System.out.println("AfterGroups is running...");
    }

    @AfterMethod
    public void afMethod(){
        System.out.println("AfterMethod is running...");
    }



}
