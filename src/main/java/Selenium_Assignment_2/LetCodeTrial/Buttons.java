package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Buttons extends DriverManager {


    By gotoHomeButtonLocator = By.xpath("//button[@id='home']");
    By findLocationButtonLocator = By.xpath("//button[@id='position']");
    By colorOfButtonLocator = By.xpath("//button[@id='color']");
    By heightWidthLocator = By.xpath("//button[@id='property']");
    By disabledButtonLocator = By.xpath("//button[@id='isDisabled']");
    By clickAndHoldButtonLocator = By.xpath("//h2[.='Button Hold!']/ancestor::button");

    @Test
    public void buttonTest(){
        createDriver("chrome");
        maximizeWindow();
        driver.get("https://letcode.in/buttons");
        wait(2);

        //to navigate to different pages
        System.out.println(driver.getTitle());
        driver.findElement(gotoHomeButtonLocator).click();
        wait(2);
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println(driver.getTitle());

        //to get the point coordinates
        Point coordinates = driver.findElement(findLocationButtonLocator).getLocation();
        System.out.println("The coordinates are: " + coordinates);
        System.out.println("X coordinate: " + coordinates.getX());
        System.out.println("Y coordinate: " + coordinates.getY());

        //to get the color of the button
        System.out.println(driver.findElement(colorOfButtonLocator).getCssValue("background-color"));

        //to get the dimensions of button
        Dimension size= driver.findElement(heightWidthLocator).getSize();
        System.out.println("Height: " + size.getHeight());
        System.out.println("Width: " + size.getWidth());

        Actions action = new Actions(driver);
        WebElement clickAndHoldButton = driver.findElement(clickAndHoldButtonLocator);
        action.clickAndHold(clickAndHoldButton).perform();
       // action.click(clickAndHoldButton).pause(10).release();


       // action.release(clickAndHoldButton).perform();
        System.out.println("click and hold performed");

        wait(15);

        quitBrowser();
    }
}
