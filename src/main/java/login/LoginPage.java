package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.id("button-1017-btnIconEl")).click();
    }

    public void logOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("userMenu-1036")).click();
        driver.findElement(By.id("menu-1037-targetEl")).click();
    }
}
