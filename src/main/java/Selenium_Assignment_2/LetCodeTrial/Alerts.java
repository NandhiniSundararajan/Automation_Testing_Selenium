package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts extends DriverManager {

    @Test
    public void alertTest1() {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        maximizeWindow();
        wait(3);

        WebElement simpleButton = driver.findElement(By.xpath("//button[@id='accept']"));
        simpleButton.click();

        String expectedAlertText = "Hey! Welcome to LetCode";

        String alertTextFromApp = driver.switchTo().alert().getText();

        //Validation
        Assert.assertEquals(alertTextFromApp, expectedAlertText, "Alert text mismatch");

    }

    @Test
    public void alertTest2() {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        maximizeWindow();
        wait(3);

        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@id='confirm']"));
        confirmAlertButton.click();

        String expectedAlertText = "Are you happy with LetCode?";

        Alert alert = driver.switchTo().alert();

        String alertTextFromApp = alert.getText();

        //Validation
        Assert.assertEquals(alertTextFromApp, expectedAlertText, "Alert text mismatch");

        wait(3);
        alert.dismiss();

    }

    @Test
    public void alertTest3() {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        maximizeWindow();
        wait(3);

        WebElement promptAlertButton = driver.findElement(By.xpath("//button[@id='prompt']"));
        promptAlertButton.click();
        Alert alert = driver.switchTo().alert();

        //to pass name name and then accept alert
        String name = "Selenium";
        alert.sendKeys(name);
        wait(3);
        alert.accept();

        String notificationText = driver.findElement(By.xpath("//p[@id='myName']")).getText();
        System.out.println("Notification text from app:" + notificationText);

        //Validation
        Assert.assertTrue(notificationText.contains(name));
    }

    @Test
    public void alertTest4(){ createDriver("chrome");
        driver.get("https://letcode.in/alert");
        maximizeWindow();
        wait(3);

        WebElement modernAlertButton = driver.findElement(By.xpath("//button[@id='modern']"));
        modernAlertButton.click();

        String expectedAlertText = "Modern Alert - Some people address me as sweet alert as well";
        String textFromAlert = driver.findElement(By.xpath("//p[@class='title']")).getText();
        wait(3);

        WebElement closeButton = driver.findElement(By.xpath("//button[@class='modal-close is-large']"));
        closeButton.click();

        //Validation
        Assert.assertEquals(textFromAlert,expectedAlertText);

    }

}