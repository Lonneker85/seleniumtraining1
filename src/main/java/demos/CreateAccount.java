package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateAccount {
    public static void main(String[] args){
        // 1. Create webdriver
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // 2. Navigate to Account Management Page >> Click on Create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.linkText("Create Account")).click();

        // 3. Fill out the form

        // How to locate elements
        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123123123");
        driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
        driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");

        // How to interact with other HTML elements
        driver.findElement(By.id("MainContent_Female")).click();
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Belgium");
        driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
        driver.findElement(By.id("MainContent_checkUpdates")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("SUCCES: " + conf);

        // 5. Close the browser
        driver.close();
    }
}
