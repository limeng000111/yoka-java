package com.example.demo.controller.exercise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataProviderTest {

    /**
     * 利用@DataProvider传递参数
     */
    @DataProvider(name = "range-provider")
    public Object[][] rangeData(){
        int lower = 5;
        int upper = 10;
        
        return new Object[][]{
                {lower-1,lower,upper,false},
                {lower,lower,upper,true},
                {lower+1,lower,upper,true},
        };
    }

    @Test(dataProvider = "range-provider")
    public static void testIsBetWeen(int n, int lower, int upper, boolean expected){
    
        assertEquals(expected, isBetween(n, lower, upper));
    }

    private static boolean isBetween(int n, int lower, int upper) {
        if ( lower < n && n < upper){
            return true;
        }
        return false;
    }

    @BeforeClass(groups = "jms")
    public void setupActiveMQ(){
//        BrokerService brokerService = new BrokerService();
    }
}
