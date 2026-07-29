package com.FrameworkTest.Example;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Framework.Example.BaseClass;
import com.Framework.Example.ConcreteVolumePage;

public class ConcreteVolumeTest extends BaseClass {

    @Test
    public void calculateConcreteVolume() throws Exception {
        ConcreteVolumePage page =
                PageFactory.initElements(driver, ConcreteVolumePage.class);
        for (int i = 1; i <= 3; i++) {
            String diameter = excel.getStringData("Sheet1", i, 0);
            String depth = excel.getStringData("Sheet1", i, 1);
            String quantity = excel.getStringData("Sheet1", i, 2);
            page.calculateConcreteVolume(diameter, depth, quantity);
            Thread.sleep(2000);
            String result = page.getResult();
            System.out.println("Test Case : " + i);
            System.out.println("Diameter  : " + diameter);
            System.out.println("Depth     : " + depth);
            System.out.println("Quantity  : " + quantity);
            System.out.println("Result    : " + result);
            System.out.println("--------");
        }
    }
}