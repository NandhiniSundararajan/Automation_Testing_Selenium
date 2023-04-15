package Selenium_Assignment_2.UniversityTable;

import Common.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UniversityTest extends DriverManager {

    @Test
    public void universityTest1(){

        List<University> universityList = new ArrayList<>();

        createDriver("chrome");
        navigateToPage("https://letcode.in/advancedtable");
        //maximizeWindow();
        wait(3);

        //to get the xpaths of the university info from the table
        String noOfRowsXpath = "//tbody/tr";
        String universityNameXpath = "//tbody/tr[$$]/td[2]";
        String countryXpath = "//tbody/tr[$$]/td[3]";
        String websiteXpath = "//tbody/tr[$$]/td[4]";

        By nextButtonLocator = By.xpath("//a[text()='Next']");


        while (true){
            //to get the number of rows in the given page
            int noOfRows = driver.findElements(By.xpath(noOfRowsXpath)).size();

            //to get the university name, country and website
            for (int i = 1; i <= noOfRows; i++) {
                University university = new University();
                String uname = driver.findElement(By.xpath(universityNameXpath.replace("$$", Integer.toString(i)))).getText();
                String country = driver.findElement(By.xpath(countryXpath.replace("$$", Integer.toString(i)))).getText();
                String website = driver.findElement(By.xpath(websiteXpath.replace("$$", Integer.toString(i)))).getText();

                //to set the university info to the university object
                university.setUniversityName(uname);
                university.setCountry(country);
                university.setWebsite(website);

                //to add the university object to the university list
                universityList.add(university);
            }

            boolean flag = driver.findElement(nextButtonLocator).getAttribute("class").contains("disabled");
            if(!flag){
                driver.findElement(nextButtonLocator).click();
            }
            else{
                break;
            }
        }

        int j = 1;
        for(University university : universityList){
            System.out.println(j);
            System.out.println(university);
            j++;
        }

    }
}
