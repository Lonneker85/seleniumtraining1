package testsInsight;

import login.LoginPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogOut {
    WebDriver driver;

    @Test
    public void logoutTest() {

        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();
        loginPage.logOut();

        // Close the driver
        driver.quit();
    }

}