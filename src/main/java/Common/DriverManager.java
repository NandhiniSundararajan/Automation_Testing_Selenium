package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    public WebDriver driver;

    public void createDriver(String browser){
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        } else{
            driver = new EdgeDriver();
        }
    }

    public void loginNopCommerce(String email, String password){

        //to open the webapp
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        //delay
        wait(3);

        //to find username field
        WebElement emailElement = driver.findElement(By.name("Email"));
        //to send a value to username field
        emailElement.clear();
        emailElement.sendKeys(email);


        //to find password field
        WebElement passwordElement = driver.findElement(By.name("Password"));
        //to send value to password field
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        //WebElement rememberMe = driver.findElement(By.name("RememberMe"));

        wait(3);
    }

    public void login_OrangeHRM(String username, String password){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //to maximize the browser
        driver.manage().window().maximize();

        //delay
        wait(3);

        //to find username field
        WebElement usernameElement = driver.findElement(By.name("username"));
        //to send a value to username field
        usernameElement.sendKeys(username);


        //to find password field
        WebElement passwordElement = driver.findElement(By.name("password"));
        //to send value to password field
        passwordElement.sendKeys(password);

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        //WebElement rememberMe = driver.findElement(By.name("RememberMe"));

        wait(3);

    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void navigateToPage(String url){
        driver.get(url);
    }

    public void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    public void quitBrowser(){
            driver.quit();
        }

}
