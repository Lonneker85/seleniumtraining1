package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occasionalEmail;
    WebElement nameElement, emailElement, phonenumberElement, passwordElement, verifyPasswordElement, countryElement, maleRadio, femaleRadio, weeklyCheckbox, monthlyCheckbox, updateCheckbox, submitButton;
    WebDriver driver;

    // This is our test method
    @Test
    public void newAccountTest() {
        System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);

        // Define web elements
        defineWebElements();

        // Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phonenumberElement.sendKeys(phone);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        // Gender Radio Button Algorithm
        if (gender.equalsIgnoreCase("Male")) {maleRadio.click();} else {femaleRadio.click();}

        // Checkbox Algorithm
        if (weeklyEmail) {if (!weeklyCheckbox.isSelected()) {weeklyCheckbox.click();} else {if (weeklyCheckbox.isSelected()) {weeklyCheckbox.click();}}}
        if (monthlyEmail) {if (!monthlyCheckbox.isSelected()) {monthlyCheckbox.click();} else {if (monthlyCheckbox.isSelected()) {monthlyCheckbox.click();}}}
        if (occasionalEmail) {if (!updateCheckbox.isSelected()) {updateCheckbox.click();} else {if (updateCheckbox.isSelected()) {updateCheckbox.click();}}}

        submitButton.click();
    }

    // This annotated method is designed to pass parameters into the class via constructor
    @Parameterized.Parameters
    public static List<String[]> getData() {
        return utilities.CSV.get("UserAccounts.csv");
    }

    // Contructor that passes paramaters to the test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;

        if (weeklyEmail.equals("TRUE")) {
            this.weeklyEmail = true;
        } else {
            this.weeklyEmail = false;
        }
        if (monthlyEmail.equals("TRUE")) {
            this.monthlyEmail = true;
        } else {
            this.monthlyEmail = false;
        }
        if (occasionalEmail.equals("TRUE")) {
            this.occasionalEmail = true;
        } else {
            this.occasionalEmail = false;
        }
    }

    @Before
    public void setUp() {
        driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();

    }

    @After
    public void tearDown() {
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if (conf.contains(expected)) {System.out.println("SUCCES: " + conf);} else {System.out.println("TEST FAILED");}
        driver.close();
    }

    public void defineWebElements(){
        nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        phonenumberElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
        verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        maleRadio = driver.findElement(By.id("MainContent_Male"));
        femaleRadio = driver.findElement(By.id("MainContent_Female"));
        weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        updateCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
        submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
    }
}
