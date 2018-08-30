package testsMultiSense;

import login.LoginPage;
import multiSense.WorkspaceMultiSense;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class VerifyLinks {

    @Test
    public void verifyLinks() {

        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/apps/multiSense/index.html#/dashboard");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        WorkspaceMultiSense workspaceMultiSense = new WorkspaceMultiSense(driver);
        workspaceMultiSense.openWorkspace();
        workspaceMultiSense.verifyLinks();


        // Close the driver
        // driver.quit();
    }
}

