package testsInsight;

import login.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login {

    @Test
    public static void loginTest() {

        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

    }

}