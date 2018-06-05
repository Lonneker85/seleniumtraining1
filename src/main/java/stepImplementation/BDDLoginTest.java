package stepImplementation;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDLoginTest {
    WebDriver driver;

    @Given("^user is on the login page$")
    public void userIsOnTheLoginPage() {
        System.out.println("User is on the login page");
        driver = utilities.DriverFabriek.openBrowser("Chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @When("^user enters correct username and correct password$")
    public void userEntersCorrectUsernameAndCorrectPassword() {
        System.out.println("User enters username and password");
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @Then("^user gets confirmation$")
    public void userGetsConfirmation() {
        System.out.println("User gets confirmation");
        Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
    }

    @When("^user enters email (.*)$")
    public void userEntersUsername(String username) {
        System.out.println("TESTING: " + username);
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
    }

    @And("^user enters password (.*)$")
    public void userEntersPassword(String password) {
        System.out.println("TESTING: " + password);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
    }

    @And("^user clicks login button$")
    public void userClicksLoginButton(){
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
