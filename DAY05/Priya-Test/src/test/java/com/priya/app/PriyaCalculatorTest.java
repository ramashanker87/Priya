package com.priya.app;

import org.junit.Test;

public class PriyaCalculatorTest {

    @Test
    public void testAdd() {
        PriyaCalculator cal = new PriyaCalculator();
        int result=cal.add(2,3);
        assert result==5;
    }
    @Test
    public void testSubtract() {
        PriyaCalculator cal = new PriyaCalculator();
       int result = cal.subtract(9,5);
        assert result !=5;
    }

    @Test
    public void testMultiply() {
     PriyaCalculator cal = new PriyaCalculator();
        int result= cal.Multi(3,2);
        assert result==6;
    }


    @Test
    public void testDivide() {
        PriyaCalculator cal = new PriyaCalculator();
        int result= cal.divide(3,2);
        assert result==6;
    }
}
