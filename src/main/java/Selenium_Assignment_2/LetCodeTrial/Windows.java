package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Windows extends DriverManager {

    By homeButtonLocator = By.xpath("//button[@id='home']");
    By multiButtonLocator = By.xpath("//button[@id='multi']");

    @Test
    public void windowTest1(){
        createDriver("chrome");
        navigateToPage("https://letcode.in/windows");
        maximizeWindow();
        wait(3);

        click(homeButtonLocator);

        //to get the id of the current window
        String homeWindowID = driver.getWindowHandle();

        //to get the id of the newly opened window
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String ID : allWindowIDs){
            if(!ID.equals(homeWindowID)){
                driver.switchTo().window(ID);
                System.out.println("The title of the new window: " + driver.getTitle());
            }
        }

        //to get all the headers in the new window
        List<WebElement> headers = driver.findElements(By.xpath("//p[@class='card-header-title is-size-3']"));
        System.out.println("Headers in the new window: ");
        for(WebElement header: headers){
            System.out.println(header.getText());
        }

        //to navigate back to the old window
        driver.switchTo().window(homeWindowID);
        System.out.println("The title of the current window: " + driver.getTitle());
    }

    @Test
    public void windowTest2() {
        createDriver("chrome");
        navigateToPage("https://letcode.in/windows");
        maximizeWindow();
        wait(3);

        click(multiButtonLocator);

        //to get the id of the current window
        String homeWindowID = driver.getWindowHandle();

        //to navigate to multiple new windows and perform actions in them
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String ID : allWindowIDs) {
            driver.switchTo().window(ID);

            if (driver.findElement(By.xpath("//h1")).getText().equals("Alert")) {
                System.out.println(driver.findElement(By.id("accept")).getText());
                driver.findElement(By.id("accept")).click();
                driver.switchTo().alert().accept();

            } else if(driver.findElement(By.xpath("//h1")).getText().equals("Dropdown")) {

                Select select = new Select(driver.findElement(By.xpath("//select[@id='superheros']")));
                //to get all the options in the dropdown from the Dropdown window
                List<WebElement> options = select.getOptions();
                System.out.println("All options of the dropdown are listed below: ");
                for (WebElement option : options) {
                    System.out.println(option.getText());
                }

            }
        }

        driver.switchTo().window(homeWindowID);
        System.out.println(driver.getTitle());
        quitBrowser();
    }


}
