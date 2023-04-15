package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frames extends DriverManager {

    By fnameLocator = By.xpath("//input[@name='fname']");
    By lnameLocator = By.xpath("//input[@name='lname']");
    By emailLocator = By.xpath("//input[@name='email']");
    @Test
    public void frameTest1(){
        createDriver("chrome");
        driver.get("https://letcode.in/frame");
        maximizeWindow();
        wait(3);

        //To navigate to child frame 1
        driver.switchTo().frame("firstFr");
        enterText(fnameLocator,"abc");
        enterText(lnameLocator,"xyz");
        String notification = driver.findElement(By.xpath("//p[@class='title has-text-info']")).getText();
        System.out.println("Notification from the app: " + notification);


        //To navigate to child frame 2
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='innerFrame']")));
        enterText(emailLocator,"abc@gmail.com");


        //Validation
        Assert.assertTrue(notification.contains("abc"));

        wait(2);
        driver.switchTo().parentFrame();
        driver.findElement(lnameLocator).clear();

        quitBrowser();
    }
}
