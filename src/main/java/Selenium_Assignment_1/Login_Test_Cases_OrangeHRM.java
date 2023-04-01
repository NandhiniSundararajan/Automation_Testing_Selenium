package Selenium_Assignment_1;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login_Test_Cases_OrangeHRM extends DriverManager {

    @Test
    public void loginTest1() {
        createDriver("chrome");
        login_OrangeHRM("Adm3in", "admin123");


        if (driver.findElement(By.className("oxd-alert--error")).isDisplayed()) {
            //By error = By.className("oxd-alert--error");
            //WebElement errorMsg = driver.findElement(error);
            System.out.println(driver.findElement(By.className("oxd-alert--error")).getText());
        }

            wait(2);
            quitBrowser();


    }

    @Test
    public void loginTest2() {
        createDriver("chrome");
        login_OrangeHRM("Admin", "admin0123");

        if (driver.findElement(By.className("oxd-alert--error")).isDisplayed()) {
            // By error = By.className("oxd-alert--error");
            //ebElement errorMsg = driver.findElement(error);
            System.out.println(driver.findElement(By.className("oxd-alert--error")).getText());
        }

        wait(2);
        quitBrowser();

    }

    @Test
    public void loginTest3() {
        createDriver("chrome");
        login_OrangeHRM("Admin00", "admin0123");

        if (driver.findElement(By.className("oxd-alert--error")).isDisplayed()) {
            // By error = By.className("oxd-alert--error");
            //ebElement errorMsg = driver.findElement(error);
            System.out.println(driver.findElement(By.className("oxd-alert--error")).getText());
        }

        wait(2);
        quitBrowser();

    }


    @Test
    public void loginTest4() {
        createDriver("chrome");
        login_OrangeHRM("Admin", "admin123");

       /* if (driver.findElement(By.className("oxd-alert--error")).) {
             By error = By.className("oxd-alert--error");
            WebElement errorMsg = driver.findElement(error);
            System.out.println(driver.findElement(By.className("oxd-alert--error")).getText());
       }*/

        wait(2);
        quitBrowser();
    }
}

