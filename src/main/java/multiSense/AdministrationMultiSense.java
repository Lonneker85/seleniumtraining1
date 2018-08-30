package multiSense;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AdministrationMultiSense {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public AdministrationMultiSense(WebDriver driver) {
        this.driver = driver;
    }

    public void openAdministration() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href=\"#/administration\"]")).click();
    }

    public void alarmCreationRule(String name) {
        driver.findElement(By.linkText("Alarm creation rules")).click(); // Alarm creation rules
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Add rule")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("template")).click(); // Rule template dropdown
        // click on dropdown item
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.x-boundlist-item"))).click();
        //etc..
    }

    // add and remove Command Limitation Rule
    public void commandLimitationRule(String name) {
        driver.findElement(By.linkText("Command limitation rules")).click(); // Command limitation rules
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Add command limitation rule")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.linkText("Add commands")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/td[1]/div/div"))).click(); // select first item in list
        driver.findElement(By.linkText("Add")).click(); // add the item
        driver.findElement(By.linkText("Add")).click(); // add the rule -> redirect to add rule screen

        // remove rule
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/td[3]/div/span"))).click(); //open settings of a rule
        driver.findElement(By.xpath("//span[text()='Remove']")).click(); //click on Remove
        driver.findElement(By.linkText("Remove")).click(); //confirm Remove
    }

    // add Communication port pools
    public void communicationPortPools(String name){
        driver.findElement(By.linkText("Communication port pools")).click(); //Communication port pools
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Add communication port pool")).click(); //click on Add communication port pool
        driver.findElement(By.xpath("//span[text()='Inbound']")).click(); //click on Inbound
        driver.findElement(By.name("name")).sendKeys(name); // enter name from generator
        driver.findElement(By.name("comPortType")).click(); // click on dropdown Type
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='UDP']"))).click(); // select SERIAL
        driver.findElement(By.name("discoveryProtocolPluggableClassId")).click(); // click on dropdown Protocol detection
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='ACE4000Inbound']"))).click(); // select ACE4000Inbound
        driver.findElement(By.linkText("Add")).click(); //

        // remove
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'CPP')]"))).click(); // open new port pool
        driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Remove')]")).click();
       // driver.findElement(By.linkText("//span[contains(text(),'Remove')]")).click();

    }
}

