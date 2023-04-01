package Selenium_Assignment_1;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login_Test_Cases_NopCommerce extends DriverManager {

    /*Test case: 1
    Wrong email and wrong password*/
    @Test
    public void login1(){

        createDriver("chrome");
        loginNopCommerce("admin","123");

        By emailError = By.id("Email-error");
        //By pwdError = By.className("message-error");

        //to find the error msg web element for email input
        if(driver.findElement(emailError).isDisplayed()){
            System.out.println(driver.findElement(emailError).getText());
        }

        //to get and print the error message from the webpage
        if(driver.findElement(emailError).getText().isEmpty()){
            System.out.println("Login is successful!");
        }
        else {
            System.out.println(driver.findElement(emailError).getText());
        }
        /*else if(!driver.findElement(pwdError).getText().isEmpty()){
            System.out.println(driver.findElement(pwdError).getText());
        }*/

        //to wait for 3 seconds and then close the browser
        wait(3);
        quitBrowser();
    }

    /* Test Case: 2
    Correct username and wrong password */
    @Test
    public void login2(){

        createDriver("chrome");
        loginNopCommerce("admin@yourstore.com","123");

        By emailError = By.id("Email-error");
        //By pwdError = By.className("message-error");

        //to find the error msg web element for email input
        /*if(driver.findElement(emailError).isDisplayed()){
            System.out.println(driver.findElement(emailError).getText());
        }*/

        //to get and print the error message from the webpage if error message exists
        if(driver.findElement(emailError).getText().isEmpty()){
            System.out.println("Login is successful!");
        }
        else {
            System.out.println(driver.findElement(emailError).getText());
        }
            /*if(!driver.findElement(emailError).getText().isEmpty()) {
            System.out.println(driver.findElement(emailError).getText());
        } else if(!driver.findElement(pwdError).getText().isEmpty()){
            System.out.println(driver.findElement(pwdError).getText());
        }*/

        //to wait for 3 seconds and then close the browser
        wait(3);
        quitBrowser();
    }

    //Test Case: 3
    //Wrong email and correct password
    @Test
    public void login3(){

        createDriver("chrome");
        loginNopCommerce("admin","admin");

        By emailError = By.id("Email-error");
        //By pwdError = By.className("message-error");

        //to find the error msg web element for email input
        if(driver.findElement(emailError).isDisplayed()){
            System.out.println(driver.findElement(emailError).getText());
        }

        //to get and print the error message from the webpage
        if(driver.findElement(emailError).getText().isEmpty()){
            System.out.println("Login is successful!");
        }
        else {
            System.out.println(driver.findElement(emailError).getText());
        }
        /*else if(!driver.findElement(pwdError).getText().isEmpty()){
            System.out.println(driver.findElement(pwdError).getText());
        }*/

        //to wait for 3 seconds and then close the browser
        wait(3);
        quitBrowser();
    }

    //Test Case: 4
    //Correct email and correct password
    @Test
    public void login4(){

        createDriver("chrome");
        loginNopCommerce("admin@yourstore.com","admin");

        By emailError = By.id("Email-error");
        //By pwdError = By.className("message-error");

        //to find the error msg web element for email input
       /* if(driver.findElement(emailError).isDisplayed()){
            System.out.println(driver.findElement(emailError).getText());
        }*/

        //to get and print the error message from the webpage
        /*if(driver.findElement(emailError).getText().isEmpty()){
            System.out.println("Login is successful!");
        }
        else {
            System.out.println(driver.findElement(emailError).getText());
        }
        /*else if(!driver.findElement(pwdError).getText().isEmpty()){
            System.out.println(driver.findElement(pwdError).getText());
        }*/

        //to wait for 3 seconds and then close the browser
        wait(3);
        quitBrowser();
    }

}
