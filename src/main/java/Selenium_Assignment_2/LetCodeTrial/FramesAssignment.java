package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FramesAssignment extends DriverManager {

    @Test
    public void framesTest1(){
        createDriver("chrome");
        navigateToPage("https://the-internet.herokuapp.com/nested_frames");
        maximizeWindow();
        wait(3);

        //To get text from bottom frame
        driver.switchTo().frame("frame-bottom");
        String bottomText = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]")).getText();
        System.out.println("Text from bottom frame: " + bottomText);

        //To get text from middle frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String middleText = driver.findElement(By.xpath("//div[@id='content']")).getText();
        System.out.println("Text from middle frame: " + middleText);

        //To get text from right frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        String rightText = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]")).getText();
        System.out.println("Text from right frame: " + rightText);

        //To get text from left frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(By.xpath("//body[contains(.,'LEFT')]")).getText();
        System.out.println("Text from left frame: " + leftText);

        quitBrowser();
    }

}
