package Selenium_Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Scanner;

public class NopCommerce_trial_2 {

    static WebDriver driver;
    static By check1 = By.id("RememberMe");
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter browser name: ");
        String browser = sc.nextLine();

        //fire up browser
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        } else{
            driver = new EdgeDriver();
        }

        //to maximize the browser
        driver.manage().window().maximize();
        //to open the webapp
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");


        Thread.sleep(3000);

        //to find username field
        WebElement emailElement = driver.findElement(By.name("Email"));
        //to send a value to username field
        emailElement.clear();
        emailElement.sendKeys("admin@yourstore.com");
        Thread.sleep(2000);

        //to find password field
        WebElement passwordElement = driver.findElement(By.name("Password"));
        //to send value to password field
        passwordElement.clear();
        passwordElement.sendKeys("admin");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();

    }
}
