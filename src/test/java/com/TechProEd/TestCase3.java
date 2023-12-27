package com.TechProEd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
    /*
    1.Go to   “https://www.saucedemo.com/”
2. Enter “standard_user” userName input box
 3. Enter “secret_sauce” password input box
 4. Click Login button
5. Get the first Item name
6. Click Add to Cart
7. Click Shopping Cart
8. Verify that is you add the item successfully.
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //   driver.manage().window().maximize();

    }
    @Test
    public void get(){
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement firstItems =driver.findElement((By.xpath("//a[@id='item_4_title_link']/div")));
     String expected = firstItems.getText();
     firstItems.click();


        WebElement addCard = driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]"));
        addCard.click();

        WebElement shopping = driver.findElement(By.xpath("//a[@href='./cart.html']"));
        shopping.click();

        WebElement items = driver.findElement(By.id("item_4_title_link"));
        String actual = items.getText();

       Assert.assertEquals(expected,actual);




    }





}
