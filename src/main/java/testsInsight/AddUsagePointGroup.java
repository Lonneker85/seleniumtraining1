package testsInsight;

import insight.UsagePoints;
import login.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.NameGenerator;

public class AddUsagePointGroup {
    //WebDriver driver;

    @Test
    public void addUsagePoint() {
        // Login class -> null pointer exception
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        // mandatory fields
        UsagePoints usagePoints = new UsagePoints(driver);
        usagePoints.openUsagePoints();
        usagePoints.addUsagePointGroup(NameGenerator.generateName("UPG"));

    }
}

