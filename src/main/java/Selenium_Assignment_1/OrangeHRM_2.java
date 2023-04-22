package Selenium_Assignment_1;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrangeHRM_2 extends DriverManager {

    @Test
    public void orangeTest1(){
        createDriver("chrome");
        navigateToPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait(3);

        //to find username field
        WebElement usernameElement = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(By.name("password"));

        //to send a value to username field
        usernameElement.sendKeys("Admin");

        //to find password field and send value to password field
        passwordElement.sendKeys("admin123");


        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();


    }
}
