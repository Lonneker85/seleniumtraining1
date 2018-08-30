package insight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class UsagePoints {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public UsagePoints(WebDriver driver) {
        this.driver = driver;
    }

    // verify the links on this page
    public void openUsagePoints() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("button-1049")).click();
    }

    public void verifyLinks() {
        // Usage point group
        driver.findElement(By.linkText("Usage point groups")).click(); // Usage point groups
        driver.findElement(By.id("button-1049")).click(); // Usage points
        // Usage point lifecycle management
        driver.findElement(By.linkText("Add usage point")).click(); // Add usage point
        driver.findElement(By.id("button-1049")).click(); // Usage points

//        driver.findElement(By.id("menuitem-1090")).click();
//        driver.findElement(By.id("button-1049")).click(); // Usage points
//        driver.findElement(By.id("menuitem-1091")).click();

    }

    public void addUsagePoint(String name, String serviceCategory, String typeOfUsagePoint, String marketCodeSector, String meteringPointType) {
        // Step 1: General information
        driver.findElement(By.linkText("Add usage point")).click(); // Add usage point
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("serviceCategory")).sendKeys(serviceCategory);
        driver.findElement(By.name("typeOfUsagePoint")).sendKeys(typeOfUsagePoint);
        driver.findElement(By.name("serviceDeliveryRemark")).click();
        driver.findElement(By.linkText("Next")).click(); // to Step 2

        // Step 2: Technical information
        driver.findElement(By.linkText("Next")).click(); // to Step 3

        // Step 3: General
        driver.findElement(By.name("properties.marketCodeSector")).sendKeys(marketCodeSector);
        driver.findElement(By.name("properties.meteringPointType")).sendKeys(meteringPointType);
        driver.findElement(By.linkText("Next")).click(); // to Step 4

        // Step 4: Technical information (Electricity)
        driver.findElement(By.linkText("Next")).click(); // to Step 5

        // Step 5: Technical installation (Electricity)
        driver.findElement(By.name("properties.substationDistance")).sendKeys("0");
        driver.findElement(By.linkText("Next")).click(); // to Step 6

        // Step 6: Link metrology configuration
        driver.findElement(By.linkText("Next")).click(); // to Step 7

        // Step 7: Calendars
        driver.findElement(By.linkText("Next")).click(); // to Step 8
    }

    public void addUsagePointGroup(String name) {
        driver.findElement(By.linkText("Usage point groups")).click(); // go to Usage point groups
        driver.findElement(By.linkText("Add usage point group")).click(); // select Add usage point group
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("//label[contains(text(),'Static usage')]")).click();
        driver.findElement(By.linkText("Next")).click();
        driver.findElement(By.xpath("Span[contains(text(),'Next')]")).click();
        // error op pagina

    }
}
