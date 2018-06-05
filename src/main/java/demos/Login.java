package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Login {

    public static void main(String[] args) {
        // 1. Define the web driver
        System.setProperty("webdriver.gecko.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // 2. Open webbrowser and navigate to web application
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // 3. Enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        // 4. Enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        // 5. Click login
        driver.findElement(By.id("MainContent_btnLogin")).click();
        // 6. Get confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION: " + message);

        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: " + pageTitle);

        // 7. Close the browser
        driver.close();
    }
}
