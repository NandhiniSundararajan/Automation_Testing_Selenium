package Selenium_Assignment_2.Leafground_Trial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Frames_2 extends DriverManager {

    @Test
    public void frameTest1(){
        createDriver("chrome");
        navigateToPage("https://leafground.com/frame.xhtml");
        maximizeWindow();
        wait(3);

        //to get the number of frames in the web page
        List<WebElement> frameList = driver.findElements(By.xpath("//iframe"));
        int noOfFrames = frameList.size();
        System.out.println("The no. of frames in the webpage is: " + noOfFrames);

        //to print the frame names
        for(WebElement frame : frameList){
            System.out.println(frame.getAttribute("src"));
        }

        //to switch to the first frame
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.xhtml']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.id("Click")).click();
        System.out.println("Text on button after click in first frame: "+ driver.findElement(By.xpath("//button[@id='Click']")).getText());

        //to switch to the second frame
        driver.switchTo().parentFrame();
        WebElement nextFrame = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
        driver.switchTo().frame(nextFrame);
        driver.switchTo().frame("frame2");
        driver.findElement(By.id("Click")).click();
        System.out.println("Text on button after click in second frame: "+ driver.findElement(By.xpath("//button[@id='Click']")).getText());


    }
}
