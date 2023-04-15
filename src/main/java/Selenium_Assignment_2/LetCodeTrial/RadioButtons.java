package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtons extends DriverManager {

    @Test
    public void radioTest1() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//input[@id='yes']"));
        radio1.click();

        //Validation
        Assert.assertTrue(radio1.isSelected());
    }

    @Test
    public void radioTest2() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//input[@id='one']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@id='two']"));

        radio1.click();
        //Validation
        Assert.assertTrue(radio1.isSelected());

        radio2.click();
        //Validation
        Assert.assertFalse(radio1.isSelected());
        System.out.println("Only one radio button is selected");
    }

    @Test
    public void radioTest3() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//input[@id='nobug']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@id='bug']"));

        radio1.click();
        //Validation
        Assert.assertTrue(radio1.isSelected());

        radio2.click();
        //Validation
        Assert.assertTrue(radio1.isSelected(), "Bug: Both radio buttons are selected");

        System.out.println("Bug: Both radio buttons are selected");
    }

    @Test
    public void radioTest4() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//input[@id='foo']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@id='notfoo']"));

        System.out.println(radio1.getText());
        if (radio1.isSelected()) {
            System.out.println("The selected radio button is: " + radio1.getText());
        } else if (radio2.isSelected()) {
            System.out.println("The selected radio button is: " + radio2.getText());
        }
    }

    @Test
    public void radioTest5() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//input[@id='maybe']"));
        //Validation
        Assert.assertFalse(radio1.isEnabled());
    }

    @Test
    public void radioTest6() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//label[contains(.,'Remember me')]//input[@type='checkbox']"));
        WebElement checkboxText = driver.findElement(By.xpath("//label[contains(.,'Remember me')]"));
        System.out.println("Checkbox text from app: "+ checkboxText.getText());

        //Validation
        Assert.assertTrue(radio1.isSelected());
    }

    @Test
    public void radioTest7() {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        maximizeWindow();
        wait(3);

        WebElement radio1 = driver.findElement(By.xpath("//label[contains(.,'I agree to the ')]//input"));
        radio1.click();
        WebElement checkboxText = driver.findElement(By.xpath("//label[contains(.,'I agree to the ')]"));
        System.out.println("Checkbox text from app: "+ checkboxText.getText());

        //Validation
        Assert.assertTrue(radio1.isSelected());

        quitBrowser();
    }
}