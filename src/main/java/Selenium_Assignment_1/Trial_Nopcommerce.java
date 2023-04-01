package Selenium_Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial_Nopcommerce {

    public static void main(String[] args) throws InterruptedException {


        //fire up browser
        WebDriver chromedriver = new ChromeDriver();

        //to open the webapp
        chromedriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        //to open the webapp
        //chromedriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        //to find username field
        WebElement emailElement = chromedriver.findElement(By.name("Email"));
        //to send a value to username field
        emailElement.clear();
        emailElement.sendKeys("admin@yourstore.com");


        //to find password field
        WebElement passwordElement = chromedriver.findElement(By.name("Password"));
        //to send value to password field
        passwordElement.clear();
        passwordElement.sendKeys("admin");

        WebElement loginButton = chromedriver.findElement(By.className("login-button"));
        loginButton.click();

        WebElement rememberMe = chromedriver.findElement(By.name("RememberMe"));

        Thread.sleep(5000);
        chromedriver.quit();

    }

}
