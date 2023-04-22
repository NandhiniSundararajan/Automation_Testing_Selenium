package Selenium_Assignment_3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeadlessBrowserTrial {

    @Test
    public void test1(){

        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);

        ChromeDriver cd = new ChromeDriver(option);
        cd.get("https://leafground.com/dashboard.xhtml");

        System.out.println("Page title: " + cd.getTitle());

        System.out.println("Browser name: " + option.getBrowserName());

        System.out.println("Version: " + option.getBrowserVersion());

        System.out.println("Platform: " + option.getPlatformName());

        System.out.println(option.setImplicitWaitTimeout(Duration.ofSeconds(10)));
    }
    @Test
    public void test2(){

        EdgeOptions option = new EdgeOptions();
        option.setHeadless(true);

        EdgeDriver cd = new EdgeDriver(option);
        cd.get("https://leafground.com/dashboard.xhtml");

        System.out.println("Page title: " + cd.getTitle());

        System.out.println("Browser name: " + option.getBrowserName());

        System.out.println("Version: " + option.getBrowserVersion());

        System.out.println("Platform: " + option.getPlatformName());

        System.out.println(option.setImplicitWaitTimeout(Duration.ofSeconds(10)));

    }
}
