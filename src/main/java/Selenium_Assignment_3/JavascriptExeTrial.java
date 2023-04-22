package Selenium_Assignment_3;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavascriptExeTrial extends DriverManager {

    @Test
    public void test1(){
        createDriver("chrome");
        navigateToPage("https://leafground.com/drag.xhtml;jsessionid=node01t97hmtzgqogign96btmgj00c219774.node0");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(driver.getTitle());

        String title = (String) ((JavascriptExecutor)driver).executeScript("document.title");
        System.out.println(title);
    }

    @Test
    public void test2(){
        createDriver("chrome");
        navigateToPage("https://leafground.com/dashboard.xhtml;jsessionid=node01si8zldv75lemd58ya3053xg6219937.node0");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(driver.getTitle());

        WebElement element = driver.findElement(By.xpath("(//div[@class='overview-title'])[1]"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].style.background='black'",element);

    }

}
