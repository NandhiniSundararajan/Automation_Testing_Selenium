package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class InputFields extends DriverManager {

    String fullNameXpath = "//input[@id='fullName']";
    String appendXpath = "//input[@id='join']";
    String textBoxXpath = "//input[@id='getMe']";

    String clearTextXpath = "//input[@id='clearMe']";
    String noEditXpath = "//input[@id='noEdit']";
    String readonlyXpath = "//input[@id='dontwrite']";

    @Test
    public void inputFieldsTest() {

        createDriver("chrome");
        driver.get("https://letcode.in/edit");
        wait(4);

        driver.findElement(By.xpath(fullNameXpath)).sendKeys("Abc xyz");


        driver.findElement(By.xpath(appendXpath)).sendKeys("xyz");
        driver.findElement(By.xpath(appendXpath)).sendKeys(Keys.TAB);

        System.out.println(driver.findElement(By.xpath(textBoxXpath)).getAttribute("value"));

        driver.findElement(By.xpath(clearTextXpath)).clear();

        System.out.println(driver.findElement(By.xpath(noEditXpath)).isEnabled());

        System.out.println(driver.findElement(By.xpath(readonlyXpath)).getAttribute("readOnly"));
    }

}
