package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFabriek {

    // This method returns a WebDriver object
    public static WebDriver openBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            return new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.gecko.driver", "chromedriver");
            return new ChromeDriver();
        }
    }
}
