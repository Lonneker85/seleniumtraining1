package stepImplementation;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginCucumberSteps {
    WebDriver driver;

    @Given("^user is logged in$")
    public void userIsLoggedIn() {
        driver = utilities.DriverFabriek.openBrowser("Chrome");
        driver.get("https://enexis.energyict.com/");
        driver.findElement(By.name("username")).sendKeys("Enexis_General");
        driver.findElement(By.name("password")).sendKeys("DukeS01");
        driver.findElement(By.id("button-1017-btnIconEl")).click();
    }

    @Then("^user is logged out$")
    public void userIsLoggedOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("userMenu-1036")).click();
        driver.findElement(By.id("menu-1037-targetEl")).click();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
