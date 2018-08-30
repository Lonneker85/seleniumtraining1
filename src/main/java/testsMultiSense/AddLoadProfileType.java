package testsMultiSense;

import insight.Administration;
import login.LoginPage;
import multiSense.AdministrationMultiSense;
import multiSense.DeviceManagement;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddLoadProfileType {
    @Test
    public void addLoadProfileType(){
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/apps/multisense/index.html#");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();


        AdministrationMultiSense administrationMultiSense = new AdministrationMultiSense(driver);
        administrationMultiSense.openAdministration();
        DeviceManagement deviceManagement = new DeviceManagement(driver);
        deviceManagement.createLoadProfileType("TestLoadProfileTom", "1.1.1.1.1.1");
    }
}
