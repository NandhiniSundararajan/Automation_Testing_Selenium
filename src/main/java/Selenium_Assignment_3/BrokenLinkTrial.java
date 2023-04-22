package Selenium_Assignment_3;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkTrial extends DriverManager {

    @Test
    public void test1() throws IOException {
        createDriver("chrome");
        navigateToPage("https://www.fido.ca/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List <WebElement> links = driver.findElements(By.xpath("//li[@class='mb-0']//a[@role='link']"));
        System.out.println(links);
        List<String> urls = new ArrayList<>();

        for (WebElement link : links) {
            urls.add(link.getAttribute("href"));
        }

        System.out.println(urls);

        for (String url : urls) {
            HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
            huc.connect();
            System.out.println("URL : " + url + " \n Response Code: " + huc.getResponseCode());

        }
    }
}
