package Selenium_Assignment_3;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElementException extends DriverManager {

    @Test
    public void test1(){
        createDriver("chrome");
        navigateToPage("https://letcode.in/buttons");

        WebElement element = driver.findElement(By.id("home"));

        driver.navigate().refresh();

        element = driver.findElement(By.id("home"));
        element.click();
    }
}
