package Selenium_Assignment_3;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChercherExplicitWaits extends DriverManager {

    @Test
    public void test1(){
        createDriver("chrome");
        navigateToPage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("button#alert")).click();

        //explicit wait
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertWait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Text from alert : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        quitBrowser();

    }


    @Test
    public void test2() {
        createDriver("chrome");
        navigateToPage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("button#populate-text")).click();

        //explicit wait
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#h2"), "Selenium Webdriver"));

        System.out.println("Text from alert : " + driver.findElement(By.cssSelector("#h2")).getText());
        quitBrowser();

    }

    @Test
    public void test3() {
        createDriver("chrome");
        navigateToPage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#display-other-button")).click();

        //explicit wait
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#hidden"))));

        System.out.println("Text from alert : " + driver.findElement(By.cssSelector("#hidden")).getText());
        quitBrowser();
    }

    @Test
    public void test4() {
        createDriver("chrome");
        navigateToPage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#enable-button")).click();

        //explicit wait
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#disable"))));

        System.out.println("Text from alert : " + driver.findElement(By.cssSelector("#disable")).getText());
        quitBrowser();
    }@Test
    public void test5() {
        createDriver("chrome");
        navigateToPage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#checkbox")).click();

        //explicit wait
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(alertWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.cssSelector("#ch")))));

        quitBrowser();
    }

}
