package Selenium_Assignment_2.LetCodeTrial;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleTable extends DriverManager {

    @Test
    public void tablesTest1(){
        int sumOfPrices = 0;
        createDriver("chrome");
        navigateToPage("https://letcode.in/table");
        //maximizeWindow();
        wait(3);

        //to get all the column names of the table
        List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id='shopping']/thead//th"));
        List<String> columnNames = new ArrayList<>();
        for(WebElement column : tableColumns){
            columnNames.add(column.getText());
        }

        //to get the index of 'price' column
        int indexOfPriceColumn = columnNames.indexOf("Price") + 1;

        //to get all the price values and sum them
        List<WebElement> prices = driver.findElements(By.xpath("//table[@id='shopping']/tbody/tr/td["+indexOfPriceColumn+"]"));
        for(WebElement price : prices){
            sumOfPrices = sumOfPrices + Integer.parseInt(price.getText());
        }

        //to get the total price from the app
        int totalPriceFromApp = Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']/tfoot/td["+indexOfPriceColumn+"]/b")).getText());

        //Validation of total price
        Assert.assertEquals(sumOfPrices, totalPriceFromApp, "Total prices mismatch");

    }

    @Test
    public void tableTest2(){

        WebElement attendance = null;
        WebElement firstName = null;
        createDriver("chrome");
        navigateToPage("https://letcode.in/table");
        maximizeWindow();
        wait(3);

        //to get the column headers from the table
        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table[@id='simpletable']/thead/tr/th"));
        List<String> columns = new ArrayList<>();
        for(WebElement column : columnHeaders){
            columns.add(column.getText());
        }

        //to get the index of required columns in the table
        int indexOfFirstNameColumn = columns.indexOf("First name") + 1;
        int indexOfLastNameColumn = columns.indexOf("Last name") + 1;
        int indexOfPresentAbsentColumn = columns.indexOf("Present/Absent") + 1;
        int indexOfEmailColumn = columns.indexOf("Email address") + 1;

        //to get the list of last names
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr/td["+indexOfLastNameColumn+"]"));
        for(WebElement lastName : lastNames){
            //to mark student as present
            if(lastName.getText().equals("Raj")){
                System.out.println("Last name is: " + lastName.getText());
                attendance =  driver.findElement(By.xpath("//table[@id='simpletable']/tbody/tr/td[contains(.,'"+lastName.getText()+"')]/..//input"));
                attendance.click();
                wait(2);
                firstName = driver.findElement(By.xpath("//table[@id='simpletable']/tbody/tr/td[contains(.,'"+lastName.getText()+"')]/preceding-sibling::td"));
                System.out.println(firstName.getText() + " " + lastName.getText() + " is marked as present");
            }
        }


        //Validation - to check if the student is marked as present
        //Assert.assertTrue(driver.findElement(By.xpath("//table[@id='simpletable']/tbody/tr/td["+indexOfPresentAbsentColumn+"]/input[@id='second']")).isSelected(), "Raj is not marked as present");
        Assert.assertTrue(attendance.isSelected());

        wait(2);
        quitBrowser();

    }
}
