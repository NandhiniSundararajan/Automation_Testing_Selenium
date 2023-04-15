package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDowns extends DriverManager {

    By fruitsDropDownLocator = By.xpath("//select[@id='fruits']");
    By multipleDropDownLocator = By.xpath("//select[@id='superheros']");

    @Test
    public void dropDownTest() {

        //Select 1 option
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        maximizeWindow();
        wait(3);

        Select select = new Select(driver.findElement(fruitsDropDownLocator));
        select.selectByVisibleText("Apple");

        String notification = driver.findElement(By.xpath("//p[@class='subtitle']")).getText();
        System.out.println("Notification: " + notification);
        System.out.println(notification.contains("Apple"));

        //Validation point
        Assert.assertTrue(notification.contains("Apple"));

    }

    @Test
    public void DropDownTest2() {

        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        maximizeWindow();
        wait(3);

        //arranging the test data
        //Selecting multiple options
        Select select = new Select(driver.findElement(multipleDropDownLocator));

        //looping over a list to get options
        List<String> optionsToBeSelected = Arrays.asList("Batman", "The Avengers", "Captain America");

        //Selection logic
        if (select.isMultiple()) {
            for (String option : optionsToBeSelected) {
                select.selectByVisibleText(option);
            }
        } else {
            select.selectByVisibleText("Robin");
        }


        //hardcoding the options
        /*if(select.isMultiple()){
            select.selectByVisibleText("Batman");
            select.selectByVisibleText("The Avengers");
            select.selectByVisibleText("Captain America");*/


        //Values from the screen
        //to print all the selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        System.out.println("Selected options: ");
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        //using an Arraylist
        List<String> optionsSelectedFromApp = new ArrayList<>();
        for (WebElement option : selectedOptions) {
            optionsSelectedFromApp.add(option.getText());
        }

        //Validation
        Assert.assertTrue(optionsSelectedFromApp.containsAll(optionsToBeSelected));


    }


    @Test
    public void dropDownTest3() {
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        maximizeWindow();
        wait(3);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='lang']")));
        //to print all options from the app
        System.out.println("Available options are: ");
        List<WebElement> optionsAvailable = select.getOptions();
        for (WebElement option : optionsAvailable) {
            System.out.println(option.getText());
        }

        //to get the last selected option
        String lastSelectedOption = optionsAvailable.get(optionsAvailable.size() - 1).getText();
        select.selectByVisibleText(lastSelectedOption);
    }


    @Test
    public void dropDownTest4() {
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        maximizeWindow();
        wait(3);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        select.selectByValue("India");
        System.out.println("The selected option is: ");
        System.out.println(select.getFirstSelectedOption().getText());

        quitBrowser();

    }


}
