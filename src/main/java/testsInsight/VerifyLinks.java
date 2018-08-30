package testsInsight;

import login.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import insight.Workspace;

public class VerifyLinks {

    @Test
    public void verifyLinks() {

        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        Workspace workspace = new Workspace(driver);
        workspace.openWorkspace();
        workspace.verifyLinks();

//        UsagePoints usagePoints = new UsagePoints(driver);
//        usagePoints.openUsagePoints();
//        usagePoints.verifyLinks();

//        Administration administration = new Administration(driver);
//        administration.openAdminstration();
        // verifyLinks op link naam werkt niet -> toch op ID?
        // administration.verifyLinks();


        // Close the driver
        // driver.quit();
    }
}

