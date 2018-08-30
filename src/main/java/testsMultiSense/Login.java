package testsMultiSense;

import login.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login {


    @Test
    public void loginTest() {
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/apps/multiSense/index.html#/dashboard");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();
    }
}
