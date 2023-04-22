package Selenium_Assignment_2;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class FidoXpathTrial extends DriverManager {

    @Test
    public void getMonthlyPayment() {
        createDriver("chrome");
        driver.get("https://www.fido.ca/phones/");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        ArrayList<String> phones = new ArrayList<>();
        phones.add("Samsung Galaxy S21 FE 1235G");
        phones.add("Google Pixel 6a");
        phones.add("iPhone 12 Pro Max");

        String monthlyPaymentXpath = "//p[contains(.,'$$')]/ancestor::div[contains(@class,'h-100 d-flex')]//span[@class='text-body mb-0 text-semi pr-8 ds-color-red d-inline-block']";


        for (String phone : phones) {
            if(isElementPresent(By.xpath(monthlyPaymentXpath.replace("$$", phone)))){
                String monthlyPayment = driver.findElement(By.xpath(monthlyPaymentXpath.replace("$$", phone))).getText();
                System.out.println("Phone: " + phone);
                System.out.println("Monthly payment:" + monthlyPayment);
            }
        }

        quitBrowser();

    }


}
