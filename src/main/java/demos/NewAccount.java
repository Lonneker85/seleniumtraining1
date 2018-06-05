package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NewAccount {
    public static void main(String[] args){
        String browserType = "firefox";
        String name = "Mary Smith";
        String email = "ms@testemail.com";
        String phonenumber = "123123123";
        String gender = "Female";
        String password = "mspass";
        String country = "Belgium";
        boolean weeklyEmail = true;
        boolean monthlyEmail = true;
        boolean occasionalEmail = false;

        // Define WebDriver
        WebDriver driver;
        driver = utilities.DriverFabriek.openBrowser(browserType);

        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();

        // Define web elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phonenumberElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
        WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        WebElement updateCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

        // Fill out the form
        nameElement.sendKeys("");
        emailElement.sendKeys(email);
        phonenumberElement.sendKeys(phonenumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        // Gender Radio Button Algorithm
        if (gender.equalsIgnoreCase("Male")){maleRadio.click();}
        else {femaleRadio.click();}


        // Checkbox Algorithm
        if (weeklyEmail){if (!weeklyCheckbox.isSelected()){weeklyCheckbox.click();}
        else {if (weeklyCheckbox.isSelected()){weeklyCheckbox.click();}}}

        if(monthlyEmail){if(!monthlyCheckbox.isSelected()){monthlyCheckbox.click();}
        else {if (monthlyCheckbox.isSelected()){monthlyCheckbox.click();}}}

        if(occasionalEmail){if(!updateCheckbox.isSelected()){updateCheckbox.click();}
        else {if (updateCheckbox.isSelected()){updateCheckbox.click();}}}

        submitButton.click();

        // Get confirmation & close browser
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if (conf.contains(expected)){
            System.out.println("SUCCES: " + conf);
        }
        else{
            System.out.println("TEST FAILED");
        }

        driver.close();
    }

}
