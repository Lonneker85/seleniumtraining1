package insight;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginCucumber {
    WebDriver driver;

    @Given("^user is in usage point wizard$")
    public void userIsInUsagePointWizard() {
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        // mandatory fields
        UsagePoints usagePoints = new UsagePoints(driver);
        usagePoints.openUsagePoints();
    }

    @When("^user creates a service category usage point$")
    public void userCreatesAServiceCategoryUsagePoint(){
        driver.findElement(By.linkText("Add usage point")).click(); // Add usage point
        driver.findElement(By.name("name")).sendKeys("CUCUMBER");
        driver.findElement(By.name("serviceCategory")).sendKeys("test");

    }



//    @When("^user enters email (.*)$")
//    public void userEntersUsername(String username) {
//        System.out.println("TESTING: " + username);
//        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
//    }
//
//    @And("^user enters password (.*)$")
//    public void userEntersPassword(String password) {
//        System.out.println("TESTING: " + password);
//        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
//    }
//
//    @And("^user clicks login button$")
//    public void userClicksLoginButton(){
//        driver.findElement(By.id("MainContent_btnLogin")).click();
//    }
//
    @After
    public void tearDown(){
        driver.close();
    }


}
