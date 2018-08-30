package testsInsight;

import login.LoginPage;
import multiSense.DashboardMultiSense;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ToMultiSense {
    @Test
    public void toMultiSense(){

        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        DashboardMultiSense dashboardMultiSense = new DashboardMultiSense(driver);
        dashboardMultiSense.checkMultiSense();

    }
}
