package Selenium_Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial_OrangeHRM {


    public static void main(String[] args) throws InterruptedException {

        //fire up browser
        WebDriver chromedriver = new ChromeDriver();
        //chromedriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        //to open the webapp
        chromedriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        //to find username field
        WebElement usernameElement = chromedriver.findElement(By.name("username"));

        //to send a value to username field
        usernameElement.sendKeys("Admin");

        //to find password field and send value to password field
        chromedriver.findElement(By.name("password")).sendKeys("admin123");



        WebElement loginButton = chromedriver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        Thread.sleep(5000);
        chromedriver.quit();

        //error msg oxd-text oxd-text--p oxd-alert-content-text


    }
}
