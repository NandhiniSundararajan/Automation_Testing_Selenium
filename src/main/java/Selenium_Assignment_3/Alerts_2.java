package Selenium_Assignment_3;

import Common.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Alerts_2 extends DriverManager {

    @Test
    public void alertTest1() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);


        WebElement button = driver.findElement(By.xpath("//h5[contains(.,'Alert (Simple Dialog')]/following-sibling::button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-outlined']"));
        button.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text from the alert:: " + alert.getText());
        wait(2);
        alert.accept();
        quitBrowser();
    }

    @Test
    public void alertTest2() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);


        By confirmButtonLocator = By.xpath("//h5[contains(.,'Confirm Dialog')]/following-sibling::button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-warning']");
        WebElement button = driver.findElement(confirmButtonLocator);
        button.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text from the alert:: " + alert.getText());
        wait(2);
        alert.accept();
        String textAfterAlertAccept = driver.findElement(By.xpath("//h5[contains(.,'Confirm Dialog')]/following-sibling::span")).getText();
        System.out.println("Text after accepting the alert:: " + textAfterAlertAccept);
        quitBrowser();
    }

    @Test
    public void alertTest3() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);

        By sweetAlertButtonLocator = By.xpath("//h5[contains(.,'Sweet Alert')]/following-sibling::button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']");
        WebElement sweetAlert = driver.findElement(sweetAlertButtonLocator);
        sweetAlert.click();
        By textInAlertLocator = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-secondary']/ancestor::div[@class='ui-dialog-footer ui-widget-content']/preceding-sibling::div/p");
        String textInAlert = driver.findElement(textInAlertLocator).getText();
        System.out.println("Text after accepting the alert:: " + textInAlert);
        By alertDismissButton = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-secondary']");
        WebElement dismissButton = driver.findElement(alertDismissButton);
        dismissButton.click();
        wait(2);
        quitBrowser();
    }

    @Test
    public void alertTest4() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);

        By modalAlertButtonLocator = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-help']");
        WebElement modalAlert = driver.findElement(modalAlertButtonLocator);
        modalAlert.click();
        By textInModalAlertLocator = By.xpath("//p[@class='m-0']");
        String textInAlert = driver.findElement(textInModalAlertLocator).getText();
        System.out.println("Text in the alert window:: " + textInAlert);
        By alertCloseButton = By.xpath("(//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all'])[2]");
        WebElement closeButton = driver.findElement(alertCloseButton);
        wait(2);
        closeButton.click();
        quitBrowser();
    }

    @Test
    public void alertTest5() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);

        By promptAlertButtonLocator = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-success']");
        WebElement promptAlert = driver.findElement(promptAlertButtonLocator);
        promptAlert.click();
        Alert alert = driver.switchTo().alert();
        String textInAlert = alert.getText();
        System.out.println("Text in the alert window:: " + textInAlert);
        alert.sendKeys("abcd");
        alert.accept();
        wait(3);
        By textAfterAlertLocator = By.xpath("//span[@id='confirm_result']");
        WebElement text = driver.findElement(textAfterAlertLocator);
        System.out.println("Text displayed after the alert is accepted:: "+ text.getText());
        quitBrowser();
    }

    @Test
    public void alertTest6() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);

        By confirmAlertButtonLocator = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-danger']");
        WebElement confirmAlert = driver.findElement(confirmAlertButtonLocator);
        confirmAlert.click();
        By alertDismissButtonLocator = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-confirmdialog-no ui-button-secondary']");
        WebElement alertDismissButton = driver.findElement(alertDismissButtonLocator);
        alertDismissButton.click();
        WebElement textInAlertBox = driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']"));
        String textInAlert = textInAlertBox.getText();
        System.out.println("Text in the alert window:: " + textInAlert);
        wait(3);
        quitBrowser();
    }

    @Test
    public void alertTest7() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/alert.xhtml");
        wait(3);

        By maxminiButtonLocator = By.xpath("//h5[contains(.,'Minimize and Maximize')]/following-sibling::button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-outlined']");
        WebElement confirmAlert = driver.findElement(maxminiButtonLocator);
        confirmAlert.click();
        WebElement textInAlertBox = driver.findElement(By.xpath("(//p[@class='m-0'])[2]"));
        String textInAlert = textInAlertBox.getText();
        System.out.println("Text in the alert window:: " + textInAlert);
        By minimizeButtonLocator = By.xpath("//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-minimize ui-corner-all']");
        WebElement minimizeButton = driver.findElement(minimizeButtonLocator);
        minimizeButton.click();
        wait(2);
        By maximizeButtonLocator = By.xpath("//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-maximize ui-corner-all']");
        WebElement maximizeButton = driver.findElement(maximizeButtonLocator);
        maximizeButton.click();
        wait(2);
        By closeButtonLocator = By.xpath("//span[contains(., 'Min and Max')]/following-sibling::a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all']");
        WebElement closeButton = driver.findElement(minimizeButtonLocator);
        closeButton.click();

        wait(3);
        quitBrowser();
    }
}

