package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType = "chrome";
    String city = "Maastricht";
    String checkIn = "06-07-2018";
    String checkOut = "10-07-2018";
    String numOfRooms = "1";
    String numOfAdults = "3";
    String numOfChilds = "2";
    String ageChild1 = "4";
    String ageChild2 = "2";
    String searchResult = "2";

    @Test
    public void hotelReservation(){
        // Search
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
        new Select(driver.findElement(By.id("hotel-rooms-hp-hotel"))).selectByValue(numOfRooms);
        new Select(driver.findElement(By.id("hotel-1-adults-hp-hotel"))).selectByValue(numOfAdults);
        new Select(driver.findElement(By.id("hotel-1-children-hp-hotel"))).selectByValue(numOfChilds);
        new Select(driver.findElement(By.id("hotel-1-age-select-1-hp-hotel"))).selectByValue(ageChild1);
        new Select(driver.findElement(By.id("hotel-1-age-select-2-hp-hotel"))).selectByValue(ageChild2);
        driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();

        // Print the name of the city
        String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
        System.out.println("CITY: " + actualCity);

        // Analyze the results and make our selection
        driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();

        // Switch the window to the popup
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        // Print hotel name and star rating
        String hotelName = driver.findElement(By.id("hotel-name")).getText();
        String gastenRating = driver.findElement(By.xpath("/html/body/div[3]/div[9]/section/section/div[3]/article/div/div[1]/table/tbody/tr/td[1]/div/div[3]/div[2]/span[1]")).getText();
        String roomPrice = driver.findElement(By.cssSelector(".room-price-value")).getText();
        System.out.println("Hotel name: " + hotelName);
        System.out.println("Rating: " + gastenRating);
        System.out.println("Price: " + roomPrice);

        // Book reservation
        driver.findElement(By.xpath("/html/body/div[3]/div[9]/section/div[11]/div/article/table/tbody[1]/tr/td[4]/div/form/div[1]/button")).click();

        // Get confirmation
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("betaling"));
    }

    @BeforeMethod
    public void setUp(){
        driver = utilities.DriverFabriek.openBrowser(browserType);
        driver.get("https://www.expedia.nl");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.id("gdpr-banner-close")).click();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
  }
}

