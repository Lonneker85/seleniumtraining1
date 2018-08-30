package testsMultiSense;

import login.LoginPage;
import multiSense.AdministrationMultiSense;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.NameGenerator;

public class AddCommunicationPortPool {
    WebDriver driver;

    @Test
    public void addCommunicationPortPool() {

        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/apps/multisense/index.html#");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        AdministrationMultiSense administrationMultiSense = new AdministrationMultiSense(driver);
        administrationMultiSense.openAdministration();
        administrationMultiSense.communicationPortPools(NameGenerator.generateName("CPP"));

    }
}


