package insight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Administration {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public Administration(WebDriver driver) {
        this.driver = driver;

    }

    // verify the links on this page
    public void openAdminstration() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("button-1050")).click();
    }

    public void verifyLinks(){
        // Data estimation
        driver.findElement(By.linkText("Estimation rule sets")); // Estimation rule sets
        driver.findElement(By.id("button-1050")).click(); // Administration
        driver.findElement(By.linkText("Estimation tasks")); // Estimation tasks
        driver.findElement(By.id("button-1050")).click(); // Administration
        // Data exchange
        driver.findElement(By.linkText("Export history")); // Export history
        driver.findElement(By.id("button-1050")).click(); // Administration
        driver.findElement(By.linkText("Export tasks")); // Export tasks
        driver.findElement(By.id("button-1050")).click(); // Administration
        driver.findElement(By.linkText("Import history")); // Import history
        driver.findElement(By.id("button-1050")).click(); // Administration
        driver.findElement(By.linkText("Import services")); // Import services
        driver.findElement(By.id("button-1050")).click(); // Administration
        driver.findElement(By.linkText("Upload file for import")); // Upload file for import
        driver.findElement(By.id("button-1050")).click(); // Administration
        // Data validation
        driver.findElement(By.linkText("Validation rule sets")); // Validation rule sets
        driver.findElement(By.id("button-1050")).click(); // Administration
        driver.findElement(By.linkText("Validation tasks")); // Validation tasks
        driver.findElement(By.id("button-1050")).click(); // Administration
        // KPIs
        driver.findElement(By.linkText("Data quality KPIs")); // Data quality KPIs
        driver.findElement(By.id("button-1050")).click(); // Administration
        // Metrology configurations management
        driver.findElement(By.linkText("Metrology configurations")); // Metrology configurations
        driver.findElement(By.id("button-1050")).click(); // Administration
        // Service categories
        driver.findElement(By.linkText("Service categories")); // Service categories
        driver.findElement(By.id("button-1050")).click(); // Administration
        // Usage point lifecycle management
        driver.findElement(By.linkText("Usage point life cycles")); // Usage point life cycles
        driver.findElement(By.id("button-1050")).click(); // Administration
    }
}
