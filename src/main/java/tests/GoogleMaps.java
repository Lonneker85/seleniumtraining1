package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleMaps {
    WebDriver driver;
    String browserType = "Chrome";
    String vertrekLocatie = "Orthen 61, 's Hertogenbosch";
    String aankomstLocatie = "Domisstraat 7, Maarssen";

    @Test
    public void routeNaarHuis() {
        driver.findElement(By.className("widget-consent-button-close")).click();
        driver.findElement(By.id("searchbox-directions")).click();
        driver.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).sendKeys(vertrekLocatie);
        driver.findElement(By.xpath("//*[@id=\"sb_ifc52\"]/input")).sendKeys(aankomstLocatie);
        driver.findElement(By.xpath("//*[@id=\"directions-searchbox-1\"]/button[1]")).click();
        String reisTijd = driver.findElement(By.xpath("//*[@id=\"section-directions-trip-0\"]/div[2]/div[1]/div[1]/div[1]")).getText();
        System.out.println("Actuele reistijd = " + reisTijd);
    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFabriek.openBrowser(browserType);
        driver.get("https://www.google.nl/maps");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
