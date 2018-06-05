package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class Login {

    @Test
    public void loginTestPOM(){

        // Intitialize driver
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // Enter login information (Login page)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tim@testemail.com");
        loginPage.setPassword("trpass");
        loginPage.clickSubmit();

        // Get confirmation (Dashboard page)
        DashboardPage dashboardPage = new DashboardPage(driver);
        String title = dashboardPage.pageTitle();
        String conf = dashboardPage.confirmationMessage();
        System.out.println(conf);

        // Assertions
        Assert.assertTrue(title.contains("Account"));
        Assert.assertTrue(conf.contains("success"));

        // Close the driver
        driver.quit();
    }
}
