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

import java.security.Key;

public class seleniumPractice {
/*
. Go to http://zero.webappsecurity.com/
 2. Click Signin button
 3. Enter login ( “username”)
 4. Enter wrong password (“password”)
 5. Click Sign in button

6. Go to Pay Bills page
7. Enter any amount into amount input
8. Enter date “2020-08-23”
9. Click Pay button
10. Verify “The payment was successfully submitted.” message is displayed
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

        driver.get("http://zero.webappsecurity.com/");
        WebElement signIn = driver.findElement(By.id("signin_button"));
        signIn.click();

        WebElement logIn = driver.findElement(By.id("user_login"));
        logIn.sendKeys("username");

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        WebElement signInBox = driver.findElement(By.name("submit"));
        signInBox.click();

        WebElement payBill = driver.findElement(By.linkText("Pay Bills"));
        payBill.click();

        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("1000");

        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("2020-08-23");

        WebElement pay = driver.findElement(By.id("pay_saved_payees"));
        pay.click();

        String actualMessage = driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
        String expectedMesaage = "The payment was successfully submitted." ;

        Assert.assertEquals(actualMessage,expectedMesaage);





    }
    @After
    public void tearDown(){

    }

}
