package stepImplementation;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import insight.UsagePoints;
import multiSense.AdministrationMultiSense;
import multiSense.DeviceManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.NameGenerator;

public class DeviceTypeSteps {
    WebDriver driver;

    @Given("^user is logged in and on device type overview$")
    public void userIsLoggedInAndOnDeviceTypeOverview() {
        driver = utilities.DriverFabriek.openBrowser("Chrome");
        driver.get("https://enexis.energyict.com/");
        driver.findElement(By.name("username")).sendKeys("Enexis_General");
        driver.findElement(By.name("password")).sendKeys("DukeS01");
        driver.findElement(By.id("button-1017-btnIconEl")).click();
        AdministrationMultiSense administrationMultiSense = new AdministrationMultiSense(driver);
        administrationMultiSense.openAdministration();
        DeviceManagement deviceManagement = new DeviceManagement(driver);
//        deviceManagement.addDeviceType();
    }

//    @After
//    public void tearDown() {
//        driver.close();
//    }



}
