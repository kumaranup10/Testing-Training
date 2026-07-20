package com.Listbox_Items.Exmaple;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class List_Box_Items {
	WebDriver driver;
	@Test
	public void drop() throws Exception {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		Thread.sleep(10000);
		// finding the element by id country
		WebElement country_drop=driver.findElement(By.id("country"));
		Select country_list=new Select(country_drop);
		
		country_list.selectByIndex(4);
		Thread.sleep(10000);
		
		// now select by the name visible in the drop box
		country_list.selectByVisibleText("India");
		Thread.sleep(10000);
		
		
		WebElement option=country_list.getFirstSelectedOption();
        String countryName=option.getText();
        System.out.println("Selected Country : "+countryName);
//  	taking all the inputs from the drop box
        List<WebElement>c_list=country_list.getOptions();

        int total_country = c_list.size();
        System.out.println("Total Countries Count in List : "+total_country);

        // Print All Country Names
        for (WebElement ele:c_list) {

            String coun_name=ele.getText();
            System.out.println("Country Name : " +coun_name);
        }

		
		
		driver.quit();
	}
}
