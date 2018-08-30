package stepImplementation;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import insight.UsagePoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.NameGenerator;

import java.util.concurrent.TimeUnit;

public class UsagePointSteps {
    WebDriver driver;

    @Given("^user is logged in and on usage point overview$")
    public void userIsLoggedInAndOnUsagePointOverview() {
        driver = utilities.DriverFabriek.openBrowser("Chrome");
        driver.get("https://enexis.energyict.com/");
        driver.findElement(By.name("username")).sendKeys("Enexis_General");
        driver.findElement(By.name("password")).sendKeys("DukeS01");
        driver.findElement(By.id("button-1017-btnIconEl")).click();
        UsagePoints usagePoints = new UsagePoints(driver);
        usagePoints.openUsagePoints();
    }

    @When("^user adds a new usage point with (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void userAddsANewUsagePointWithAndServiceCategoryAndTypeOfUsagePointAndMarketCodeSectorAndMeteringPointType(String name, String serviceCategory, String typeOfUsagePoint, String marketCodeSector, String meteringPointType) {
        UsagePoints usagePoints = new UsagePoints(driver);
        usagePoints.addUsagePoint((NameGenerator.generateName(name)), serviceCategory, typeOfUsagePoint, marketCodeSector, meteringPointType);
    }

    @And("^user adds a usage point group with (.*)$")
    public void userAddsAUsagePointGroup(String name) {
        UsagePoints usagePoints = new UsagePoints(driver);
        usagePoints.addUsagePointGroup(name);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
