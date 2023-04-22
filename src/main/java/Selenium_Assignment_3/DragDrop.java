package Selenium_Assignment_3;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DragDrop extends DriverManager {

    @Test
    public void Tet1() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/drag.xhtml");

        WebElement source = driver.findElement(By.xpath("//div[@id='form:drag']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='form:drop_content']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).perform();

        quitBrowser();
    }

    @Test
    public void Test2() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/drag.xhtml");

        WebElement source = driver.findElement(By.xpath("//div[@id='form:conpnl_content']"));

        for (int i = 0; i < 5; i++) {
            Actions action = new Actions(driver);
            action.dragAndDropBy(source, 200, 0).perform();
            milliSecWait(200);
            action.dragAndDropBy(source, -200, 0).perform();
            milliSecWait(200);
        }
        quitBrowser();
        //h5[contains(.,'Draggable Rows')]/..//tr[@data-ri='1']
    }


    @Test
    public void Test3() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/drag.xhtml");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement source = driver.findElement(By.xpath("//h5[contains(.,'Draggable Rows')]/..//tr[@data-ri='8']"));

        WebElement target = driver.findElement(By.xpath("//h5[contains(.,'Draggable Rows')]/..//tr[@data-ri='7']"));

        //to print rows before drag and drop
        System.out.println(source.getText());
        System.out.println(target.getText());

        Actions action1 = new Actions(driver);
        //to drag and drop row6
        action1.dragAndDrop(source, target).perform();


        System.out.println("Message from alert:: " + driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText());

        quitBrowser();
    }

    @Test
    public void Test4ScrollToElement() {
        createDriver("chrome");
        navigateToPage("https://leafground.com/drag.xhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement source = driver.findElement(By.xpath("//h4[contains(.,'Range Slider')]"));


        //to print rows before drag and drop
        System.out.println(source.getText());


        Actions action1 = new Actions(driver);
        //to scroll to the element
        action1.scrollToElement(source).perform();

        quitBrowser();
    }

}
