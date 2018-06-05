package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;

public class LoginFactory {

    String username = "tim@testemail.com";
    String password = "trpass";

    public void loginTestPageFactory(){
        // Initialize driver
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // Enter login
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(username, password);
    }
}
