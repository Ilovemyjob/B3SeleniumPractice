package com.TechProEd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

    /*
        Go to ” https://www.thetrainline.com/”
 2. Select return button
3. Check the return is selected
 4. Verify the returnDate input box is Enabled
5. Check the one way is not selected
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //   driver.manage().window().maximize();

    }

    @Test
    public void get() {
        driver.get("https://www.thetrainline.com/");

      WebElement returnBox = driver.findElement(By.id("return"));
      returnBox.click();

        WebElement returndateBox = driver.findElement(By.xpath("(//input[@class='_12p3clnNaN'])[2]"));
        Assert.assertTrue(returndateBox.isEnabled());

        WebElement single = driver.findElement(By.id("single"));
        Assert.assertFalse(single.isSelected());



    }

    @After
    public void tearDown() {

    }
}