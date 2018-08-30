package multiSense;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class DashboardMultiSense {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public DashboardMultiSense(WebDriver driver) {
        this.driver = driver;

    }

    // verify the links on this page
    public void checkMultiSense() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("uni-nav-appcenter-1026")).click();
        driver.findElement(By.cssSelector("#dataview-1028 > a:nth-child(6) > div")).click();

        // verify if page is reached
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

    }
}